package com.shubham.igi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shubham.igi.client.data.dao.ClientDao
import com.shubham.igi.client.data.dao.ReceiptDao
import com.shubham.igi.client.data.model.Client
import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.inventory.data.dao.Converters
import com.shubham.igi.inventory.data.dao.FilmInventoryDao
import com.shubham.igi.inventory.data.dao.InventoryDao
import com.shubham.igi.inventory.data.dao.UpdateDao
import com.shubham.igi.inventory.data.model.FilmInventoryItem
import com.shubham.igi.inventory.data.model.InventoryItem
import com.shubham.igi.inventory.data.model.InventoryUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [InventoryItem::class, InventoryUpdate::class, FilmInventoryItem::class, Client::class,
        Receipt::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun inventoryDao(): InventoryDao
    abstract fun updateDao(): UpdateDao
    abstract fun filmInventoryDao(): FilmInventoryDao
    abstract fun clientDao(): ClientDao // 👈 NEW
    abstract fun receiptDao(): ReceiptDao // 👈 NEW

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Create Client table
                db.execSQL(
                    """
            CREATE TABLE IF NOT EXISTS `Client` (
                `clientId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `name` TEXT NOT NULL,
                `address` TEXT,
                `phone` TEXT
            )
        """.trimIndent()
                )

                // Create Receipt table
                db.execSQL(
                    """
            CREATE TABLE IF NOT EXISTS `Receipt` (
                `receiptId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `clientOwnerId` INTEGER NOT NULL,
                `date` TEXT NOT NULL,
                `amount` REAL NOT NULL,
                `paidAmount` REAL NOT NULL DEFAULT 0.0,
                `imageUri` TEXT NOT NULL,
                FOREIGN KEY(`clientOwnerId`) REFERENCES `Client`(`clientId`) ON DELETE CASCADE
            )
        """.trimIndent()
                )

                // Add index for clientOwnerId for performance
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_Receipt_clientOwnerId` ON `Receipt` (`clientOwnerId`)")
            }
        }

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "inventory_database"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            populateData(INSTANCE)
                        }
                    }
                }).addMigrations(MIGRATION_1_2).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
