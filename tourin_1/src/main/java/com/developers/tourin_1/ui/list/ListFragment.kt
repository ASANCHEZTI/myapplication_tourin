package com.developers.tourin_1.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.developers.tourin_1.data.PoiRepository
import com.developers.tourin_1.databinding.FragmentListBinding
import com.developers.tourin_1.ui.main.MainActivity
import com.developers.tourin_1.model.Poi
import com.developers.tourin_1.model.PoiItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
        (activity as MainActivity?)?.hideIcon()
        listPoi = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(listPoi, onItemClicked = { onPoiClicked(it) })


        listBinding.poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiClicked(poi: PoiItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment2(poi = poi))

    }




    private fun loadMockPoiFromJson(): ArrayList<PoiItem> {
        val poiString: String = context?.assets?.open("poi.json")?.bufferedReader().use { it!!.readText()}
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Poi::class.java)
        return poiList
    }

}