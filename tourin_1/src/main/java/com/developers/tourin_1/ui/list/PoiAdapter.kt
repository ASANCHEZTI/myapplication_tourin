package com.developers.tourin_1.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developers.tourin_1.R
import com.developers.tourin_1.model.PoiItem
import com.squareup.picasso.Picasso

class PoiAdapter(
    private val Poilist: ArrayList<PoiItem>,
    private val onItemClicked: (PoiItem) -> Unit,
) : RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item, parent,false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poi = Poilist[position]
        holder.itemView.setOnClickListener { onItemClicked (Poilist[position])}
        holder.bind(poi)
    }

    override fun getItemCount():Int = Poilist.size

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        private var nameTextView: TextView = itemview.findViewById(R.id.name_text_view)
        private var gradeTextView: TextView = itemview.findViewById(R.id.grade_text_view)
        private var briefTextView: TextView = itemview.findViewById(R.id.description_text_view)
        private var pictureImageView: ImageView = itemview.findViewById(R.id.picture_image_view)

        fun bind(poi: PoiItem){
            nameTextView.text = poi.name
            gradeTextView.text = poi.grade
            briefTextView.text = poi.summary
            Picasso.get().load(poi.urlPicture).into(pictureImageView)

        }
    }
}