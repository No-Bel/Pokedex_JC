package com.example.pokedex.presentation.pokemon_detail

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.repository.PokemonRepositoryImpl
import com.example.pokedex.domain.usecases.GetPokemonInfoUseCase
import com.example.pokedex.presentation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return getPokemonInfoUseCase(pokemonName)
    }
}