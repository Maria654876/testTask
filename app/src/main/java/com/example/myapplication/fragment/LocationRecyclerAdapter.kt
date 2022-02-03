package com.example.myapplication.fragment

import android.location.Location
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.bd.Locations

class LocationRecyclerAdapter(private val locations: List<Locations>, private val selectedItem: (Locations)-> Unit):
 RecyclerView.Adapter<LocationRecyclerAdapter.LocationViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationRecyclerAdapter.LocationViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.location_item,parent,false)
        return LocationViewHolder(view, selectedItem)
    }

    override fun onBindViewHolder(
        holder: LocationRecyclerAdapter.LocationViewHolder,
        position: Int
    ) {
        holder.setLocation(locations [position])
    }

    override fun getItemCount(): Int =locations.size

    class LocationViewHolder(private val view: View, val selectedItem: (Locations) -> Unit): RecyclerView.ViewHolder(view){

        private var locations: Locations?=null
        private var image:ImageView?=null
        init{
            view.setOnClickListener{
                locations?.let{
                    selectedItem(it)
                }
            }
        }

        fun setLocation(locations: Locations){
            image=view.findViewById(R.id.imageViewItem)

            this.locations=locations
            image?.let{Glide.with(view.context).load(locations.imageUrl).into(it)}
        }
    }


}