package com.example.logindb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Details::class], version = 1, exportSchema = false)
abstract class LoginDatabase:RoomDatabase() {
    abstract fun loginDetailDao(): LoginDao
    companion object {
        @Volatile
        var INSTANCE: LoginDatabase? = null
        fun getInstance(context: Context): LoginDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LoginDatabase::class.java,
                        "LoginDb"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}
