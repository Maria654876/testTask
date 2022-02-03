package com.example.myapplication.bd.entity

import android.content.Context
import com.example.myapplication.bd.LocationDao
import com.example.myapplication.bd.LocationsAppDatabase

class AppDatabaseImp private constructor(): LocationsAppDatabase {

    companion object{

        private var instance: AppDatabaseImp?=null
        private var locationDao:LocationDao?=null


        fun getInstance(context: Context): AppDatabaseImp{
            if (instance==null){
                instance= AppDatabaseImp()
                locationDao=AppDataBase.buildDatabase(context).getLocationsDao()
            }
            return instance!!
        }

    }


    override fun getLocationDao(): LocationDao =locationDao!!

}