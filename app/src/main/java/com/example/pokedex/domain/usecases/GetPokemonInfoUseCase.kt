package com.example.pokedex.domain.usecases

import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.presentation.util.Resource
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(name: String): Resource<Pokemon> {
        return repository.getPokemonInfo(name)
    }
}