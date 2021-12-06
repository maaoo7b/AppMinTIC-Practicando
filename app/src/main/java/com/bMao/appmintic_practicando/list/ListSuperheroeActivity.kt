package com.bMao.appmintic_practicando.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bMao.appmintic_practicando.Main.MainActivity
import com.bMao.appmintic_practicando.R
import com.bMao.appmintic_practicando.model.Superheroe
import com.bMao.appmintic_practicando.model.SuperheroeItem
import com.google.gson.Gson

class ListSuperheroeActivity : AppCompatActivity() {

    private lateinit var listaSuperheroe : ArrayList<SuperheroeItem>
    private lateinit var superheroesAdapter : SuperheroesAdapter
    private lateinit var superheroesRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_superheroe)

        superheroesRecyclerView = findViewById(R.id.superheroes_recycler_view)


        //listaSuperheroe = createMockSuperHeroes()
        listaSuperheroe = loadMockSuperheroeJSON()
        superheroesAdapter = SuperheroesAdapter(listaSuperheroe,onItemClicked = {onSuperheroeClicked(it)})

        superheroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superheroesAdapter
            setHasFixedSize(false)
        }

        //superheroesRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        //superheroesRecyclerView.adapter = superheroesAdapter
    }

    private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
        Log.d("alias", superheroe.alias)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("superheroe",superheroe)
        startActivity(intent)
    }

    private fun loadMockSuperheroeJSON(): ArrayList<SuperheroeItem> {
        var superheroesString : String = applicationContext.assets.open("superheroes.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(superheroesString, Superheroe::class.java)
        return data
    }

}