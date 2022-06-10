package com.example.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// CLASS WITH RESPONSIBILITY TO MANAGE OUR ENTITIES AND OUR ROOM
@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun businessDao(): BusinessCardDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}