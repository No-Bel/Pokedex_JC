package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.presentation.util.Resource
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi
): PokemonRepository{
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            pokeApi.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("an unknown error occured.")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            pokeApi.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("an unknown error occured.")
        }
        return Resource.Success(response)
    }
}