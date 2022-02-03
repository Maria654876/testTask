package com.example.myapplication

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.location.Location
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.bd.Locations
import com.example.myapplication.fragment.LocationRecyclerAdapter
import com.example.myapplication.fragment.LocationsListFragment
import com.example.myapplication.fragment.URIPathHelper

class MainActivity : AppCompatActivity() {


    val REQUEST_CODE = 200
    val uriPathHelper = URIPathHelper()
    //val filePath = uriPathHelper.getPath(this, imageUrl)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
       // val adapter = LocationRecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = adapter
    }

    fun gel(){
        openGalleryForImages()
    }

    private fun openGalleryForImages() {

        if (Build.VERSION.SDK_INT < 19) {
            var intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Choose Pictures")
                , REQUEST_CODE
            )
        }
        else {
            var intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE);
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {

            if (data?.getClipData() != null) {
                var count = data.clipData!!.itemCount
                for (i in 0..count - 1) {
                    var imageUri: Uri = data.clipData!!.getItemAt(i).uri
                }

            } else if (data?.getData() != null) {
                var imageUri: Uri = data.data!!
            }
        }
    }
}

/*
Все что упела накидать за пару дней,
а так у меня небольшой опыт разработки на Kotlin)
 */