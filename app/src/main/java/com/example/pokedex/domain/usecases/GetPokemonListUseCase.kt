package com.example.pokedex.domain.usecases

import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.presentation.util.Resource
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(limit: Int, offset: Int): Resource<PokemonList> {
        return repository.getPokemonList(limit, offset)
    }
}