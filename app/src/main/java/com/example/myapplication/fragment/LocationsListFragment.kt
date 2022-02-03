package com.example.myapplication.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bd.entity.AppDatabaseImp

class LocationsListFragment: Fragment() {

    private val viewModel by viewModels<LocationsViewModel>()
    private var adapter: LocationRecyclerAdapter?=null
    private lateinit var locationRecycleView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setLocationDao(AppDatabaseImp.getInstance(requireContext()).getLocationDao())

        lifecycle.addObserver(viewModel)
        locationRecycleView=view.findViewById(R.id.recyclerView)
        locationRecycleView.run{
            layoutManager= GridLayoutManager(context, 3, LinearLayoutManager.HORIZONTAL, false).apply {
                stackFromEnd=true
            }
        }
        subscribeToLiveData()
    }

    private fun subscribeToLiveData(){
        viewModel.locationsLiveData.observe(viewLifecycleOwner,{locations->
            adapter=LocationRecyclerAdapter(locations ){ locations -> Log.d(TAG, locations.toString()) }
        })
    }
}