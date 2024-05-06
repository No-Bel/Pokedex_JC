package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.presentation.util.Constants.GET_POKEMON
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET(GET_POKEMON)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("$GET_POKEMON/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon
}