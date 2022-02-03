package com.example.myapplication.fragment

import com.example.myapplication.bd.Locations

interface NetworkLocations {
    fun getLocations(): List<Locations>
}