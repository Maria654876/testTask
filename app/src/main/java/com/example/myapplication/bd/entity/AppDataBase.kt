package com.example.myapplication.bd.entity

import android.content.Context
import android.location.Location
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.bd.LocationDao
import com.example.myapplication.bd.Locations


@Database(entities = [Locations::class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    companion object{

        fun buildDatabase(context: Context)= Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "AppDatabase").build()

    }


  abstract  fun getLocationsDao(): LocationDao

}