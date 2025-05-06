package com.shubham.igi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shubham.igi.data.dao.FilmInventoryDao
import com.shubham.igi.data.dao.InventoryDao
import com.shubham.igi.data.dao.UpdateDao
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [InventoryItem::class, InventoryUpdate::class, FilmInventoryItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun inventoryDao(): InventoryDao
    abstract fun updateDao(): UpdateDao
    abstract fun filmInventoryDao(): FilmInventoryDao

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
                            populateData(INSTANCE)
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
