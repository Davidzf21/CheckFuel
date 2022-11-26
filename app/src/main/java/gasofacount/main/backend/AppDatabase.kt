package gasofacount.main.backend

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Gasolina::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gasolinas(): GasolinaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(constext: Context): AppDatabase {
            var temp = INSTANCE
            if(temp != null){
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    constext.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }

    }
}