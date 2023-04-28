package br.com.pokedex_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.pokedex_android.R
import br.com.pokedex_android.domain.Pokemon
import br.com.pokedex_android.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokenon)
        val layoutManager = LinearLayoutManager(this)

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            "Charmander",
            listOf(
                PokemonType("Fire")
            )
        )
        val pokemons = listOf(charmander, charmander, charmander, charmander, charmander)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}