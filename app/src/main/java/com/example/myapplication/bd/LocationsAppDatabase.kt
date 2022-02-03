package com.example.myapplication.bd

interface LocationsAppDatabase {
   fun getLocationDao(): LocationDao
}