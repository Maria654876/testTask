package com.example.myapplication.bd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Locations(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id:Int?,
    @ColumnInfo(name="name")
    val name:String,
    @ColumnInfo(name="imageUrl")
    val imageUrl: String
)
