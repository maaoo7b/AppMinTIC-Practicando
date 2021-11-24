package com.bMao.appmintic_practicando.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bMao.appmintic_practicando.R
import com.bMao.appmintic_practicando.model.SuperheroeItem
import com.squareup.picasso.Picasso

class SuperheroesAdapter(private val superHeroesList : ArrayList<SuperheroeItem>,private val onItemClicked:(SuperheroeItem)-> Unit) : RecyclerView.Adapter<SuperheroesAdapter.ViewHolder>() {

    override fun onCreateViewHolder (parent: ViewGroup,viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_superheroe_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superheroe = superHeroesList[position]
        holder.itemView.setOnClickListener{onItemClicked(superHeroesList[position])}
        holder.bind(superheroe)
    }

    override fun getItemCount(): Int {
        return superHeroesList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private var nameTextView : TextView = view.findViewById(R.id.name_text_view)
        private var aliasTextView : TextView = view.findViewById(R.id.label_alias_text_view)
        private var image : ImageView = view.findViewById(R.id.picture_image_view)

        fun bind(superheroe: SuperheroeItem){
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            Picasso.get().load(superheroe.urlPicture).into(image);

        }

    }
}