package br.com.pokedex_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pokedex_android.api.PokemonRepository
import br.com.pokedex_android.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()

    init {
        Thread(Runnable {
            loadPokenons()
        }).start()
    }

    private fun loadPokenons() {
        val pokemonsApiResult = PokemonRepository.getAll()

        pokemonsApiResult?.results?.let {
            pokemons.postValue(it.map { pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()
                val pokemonApiResult = PokemonRepository.getById(number)

                pokemonApiResult?.let {
                    return@map  Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}