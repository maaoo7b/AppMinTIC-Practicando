package com.bmao.comics.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmao.comics.R
import com.bmao.comics.databinding.FragmentListBinding
import com.bmao.comics.main.MainActivity
import com.bmao.comics.model.Superheroe
import com.bmao.comics.model.SuperheroeItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listaSuperheroe : ArrayList<SuperheroeItem>
    private lateinit var listBinding : FragmentListBinding
    private lateinit var superheroesAdapter : SuperheroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listaSuperheroe = loadMockSuperheroeJSON()
        superheroesAdapter = SuperheroesAdapter(listaSuperheroe,onItemClicked = {onSuperheroeClicked(it)})
        listBinding.superheroesRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = superheroesAdapter
            setHasFixedSize(false)

        }
    }

    private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe = superheroe))
    }


    private fun loadMockSuperheroeJSON(): ArrayList<SuperheroeItem> {
        var superheroesString : String = context?.assets?.open("superheroes.json")?.bufferedReader().use { it!!.readText() } //TODO reparaar
        val gson = Gson()
        val data = gson.fromJson(superheroesString, Superheroe::class.java)
        return data
    }
}