package com.bMao.appmintic_practicando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.bMao.appmintic_practicando.databinding.ActivityMainBinding
import com.bMao.appmintic_practicando.model.SuperheroeItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val superheroe : SuperheroeItem = intent.extras?.getSerializable("superheroe") as SuperheroeItem
        with(mainBinding){
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            cityTextView.text = superheroe.city
            occupationTextView.text = superheroe.occupation
            facebookTextView.text = superheroe.facebook
            powersTextView.text = superheroe.powers
            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }

    }
}