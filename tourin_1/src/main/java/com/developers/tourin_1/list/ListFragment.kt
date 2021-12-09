package com.developers.tourin_1.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developers.tourin_1.databinding.FragmentListBinding
import com.developers.tourin_1.model.Poi
import com.developers.tourin_1.model.PoiItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var listPoi: ArrayList<PoiItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        super.onViewCreated (view, savedInstanceState)
        listPoi = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(listPoi, onItemClicked = { onPoiClicked(it) })
    }

    private fun onPoiClicked(poi: PoiItem) {
        //TODO programar detalle
    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem> {
        val poiString: String = context?.assets?.open("poi.json")?.bufferedReader().use { it!!.readText()} //TODO reparar !!
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Poi::class.java)
        return poiList
    }

}