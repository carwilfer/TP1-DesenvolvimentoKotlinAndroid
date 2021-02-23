package com.carwilfer.carlos_ferreira_dr3_tp1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos

@Database(
    entities = [
        Cliente::class, Oculos::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun oculosDao(): OculosDao

    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase{
            if(instance == null)
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database.db"
                ).build()
            return instance as AppDatabase
        }
    }
}