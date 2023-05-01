package br.com.pokedex_android.api

import android.util.Log
import br.com.pokedex_android.api.model.PokemonApiResult
import br.com.pokedex_android.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun getAll(limit: Int = 151): PokemonsApiResult? {
        var call = service.getAll(limit)
        return call.execute().body()
    }

    fun getById(number: Int): PokemonApiResult? {
        var call = service.getById(number)
        return call.execute().body()
    }
}