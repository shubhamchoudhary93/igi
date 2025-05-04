package com.shubham.igi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shubham.igi.data.dao.InventoryDao
import com.shubham.igi.data.dao.UpdateDao
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [InventoryItem::class, InventoryUpdate::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun inventoryDao(): InventoryDao
    abstract fun updateDao(): UpdateDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

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
                            val dao = INSTANCE?.inventoryDao()
                            val updateDao = INSTANCE?.updateDao()

                            // Insert demo items
                            val riceId = dao?.insertItem(InventoryItem(name = "Rice", category = "Food", amount = 100)) ?: 0L
                            val wheatId = dao?.insertItem(InventoryItem(name = "Wheat", category = "Food", amount = 150)) ?: 0L
                            val shampooId = dao?.insertItem(InventoryItem(name = "Shampoo", category = "Toiletries", amount = 30)) ?: 0L

                            // Insert demo updates
                            updateDao?.insertUpdate(
                                InventoryUpdate(itemId = riceId as Int, itemName = "Rice", date = "2025-05-03", change = 10)
                            )
                            updateDao?.insertUpdate(
                                InventoryUpdate(itemId = wheatId as Int,  itemName = "Wheat", date = "2025-05-03", change = -5)
                            )
                            updateDao?.insertUpdate(
                                InventoryUpdate(itemId = riceId as Int,  itemName = "Rice", date = "2025-05-04", change = 15)
                            )
                            updateDao?.insertUpdate(
                                InventoryUpdate(itemId = shampooId as Int,  itemName = "Shampoo", date = "2025-05-04", change = -2)
                            )
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
