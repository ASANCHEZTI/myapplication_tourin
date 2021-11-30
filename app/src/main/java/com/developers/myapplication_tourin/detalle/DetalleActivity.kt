package com.developers.myapplication_tourin.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developers.myapplication_tourin.databinding.ActivityDetalleBinding
import com.developers.myapplication_tourin.model.PoiItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)



        val poi: PoiItem = intent.extras?.getSerializable("poi") as PoiItem
        with(detalleBinding){
            nameTextView.text = poi.name
            gradeTextView.text = poi.grade
            locationTextView.text = poi.location
            temperatureTextView.text = poi.temperatureC
            descriptionTextView.text = poi.description
            Picasso.get().load(poi.urlPicture).into(pictureImageView)

        }
    }

}
//config develop