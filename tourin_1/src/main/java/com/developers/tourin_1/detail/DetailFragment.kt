package com.developers.tourin_1.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.developers.tourin_1.databinding.FragmentDetailBinding
import com.developers.tourin_1.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poi = args.poi


        with(detailBinding) {
            nameTextView.text = poi.name
            gradeTextView.text = poi.grade
            locationTextView.text = poi.location
            temperatureTextView.text = poi.temperatureC
            descriptionTextView.text = poi.description
            com.squareup.picasso.Picasso.get().load(poi.urlPicture).into(pictureImageView)
        }

    }
}