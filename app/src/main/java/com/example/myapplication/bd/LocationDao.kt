package com.example.myapplication.bd


import androidx.room.*


@Dao
interface LocationDao {

    @Insert
    fun insertLocation(locations: Locations)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocations(locations: List<Locations>)

    @Delete
    fun deleteLocation(locations: Locations)

    @Delete
    fun deleteLocation(vararg  locations: Locations)

    @Update
    fun updateLocation(locations: Locations)

    @Query ("SELECT * FROM locations  WHERE  name LIKE :locationName")
    fun searchAlbum(locationName: String):List<Locations>

//    @Query("SELECT * FROM locations")
//    fun getLocations(locations: Locations)


}