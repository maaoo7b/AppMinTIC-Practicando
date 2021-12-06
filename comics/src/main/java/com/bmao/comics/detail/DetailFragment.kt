package com.bmao.comics.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bmao.comics.databinding.FragmentDetailBinding
import com.bmao.comics.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var DetailBinding : FragmentDetailBinding
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        DetailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return DetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val superheroe = args.superheroe
        with(DetailBinding){
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            cityTextView.text = superheroe.city
            occupationTextView.text = superheroe.occupation
            facebookTextView.text = superheroe.facebook
            powersTextView.text = superheroe.powers
            com.squareup.picasso.Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }
    }
}