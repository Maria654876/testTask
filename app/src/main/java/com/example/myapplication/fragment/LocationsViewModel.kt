package com.example.myapplication.fragment

import android.location.Location
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.myapplication.bd.LocationDao
import com.example.myapplication.bd.Locations

class LocationsViewModel: ViewModel(), LifecycleEventObserver {

    companion object {
        private const val TAG = "LocationsViewModel"
    }

    private var locationDao: LocationDao?=null
    val locationsLiveData = MutableLiveData<List<Locations>>()
    private val locationsModel: NetworkLocations = NetworkLocationsImp()

    fun setLocationDao(locationDao: LocationDao){
        this.locationDao=locationDao
    }

    private fun getLocations(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val locations=locationsModel.getLocations()
                locationDao?.insertLocations(locations)
                locationsLiveData.postValue(locations)
            }catch (exception: Exception){
                Log.e(TAG, exception.message?:"")
            }
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        getLocations()
    }

}


