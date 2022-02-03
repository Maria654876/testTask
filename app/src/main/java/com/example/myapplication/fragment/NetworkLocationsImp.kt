package com.example.myapplication.fragment

import com.example.myapplication.bd.Locations

class NetworkLocationsImp:NetworkLocations {

    private val locations= listOf(
        Locations(id=null , name="Image12", imageUrl = "R.drawable.image12"),
        Locations(id=null, name="image13",imageUrl ="R.drawable.image13"),
        Locations(id=null, name="image14",imageUrl ="R.drawable.image13"),
        Locations(id=null, name="image15",imageUrl ="R.drawable.image13"),
        Locations(id=null, name="image16",imageUrl ="R.drawable.image13"),
        Locations(id=null, name="image17",imageUrl ="R.drawable.image13")

    )

    override fun getLocations(): List<Locations> = locations

}