package com.developers.tourin_1.ui.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developers.tourin_1.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /** Manipulates the map once available.*/

        val monserrate = LatLng (4.6057243, -74.0573406)
        googleMap.addMarker(MarkerOptions().position(monserrate).title("This is Monserrate!"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(monserrate,12F))

        val plazadebolivar = LatLng (4.5981259, -74.0782375)
        googleMap.addMarker(MarkerOptions().position(plazadebolivar).title("This is Plaza de Bolivar!"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plazadebolivar,12F))

        val boteromuseum = LatLng (4.5965425, -74.0753197)
        googleMap.addMarker(MarkerOptions().position(boteromuseum).title("This is Botero Museum!"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(boteromuseum,12F))

        val simonbolivarpark = LatLng (4.6584849, -74.0956519)
        googleMap.addMarker(MarkerOptions().position(simonbolivarpark).title("This is Simon Bolivar Park!"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(simonbolivarpark,12F))

        val nationalmuseum = LatLng (4.6154977, -74.070481)
        googleMap.addMarker(MarkerOptions().position(nationalmuseum).title("This is Colombia's National Museum!"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nationalmuseum,12F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}