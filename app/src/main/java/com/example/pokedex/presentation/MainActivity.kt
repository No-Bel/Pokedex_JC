package com.example.pokedex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.presentation.pokemonList.PokemonListScreen
import com.example.pokedex.presentation.ui.theme.PokedexTheme
import com.example.pokedex.presentation.util.Constants.DOMAIN_COLOR
import com.example.pokedex.presentation.util.Constants.POKEMON_DETAIL_SCREEN
import com.example.pokedex.presentation.util.Constants.POKEMON_LIST_SCREEN
import com.example.pokedex.presentation.util.Constants.POKEMON_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = POKEMON_LIST_SCREEN
                ) {
                    composable(POKEMON_LIST_SCREEN) {
                        PokemonListScreen(navController = navController)
                    }
                    composable("$POKEMON_DETAIL_SCREEN/{$DOMAIN_COLOR}/{$POKEMON_NAME}",
                        arguments = listOf(
                            navArgument(DOMAIN_COLOR) {
                                type = NavType.IntType
                            },
                            navArgument(POKEMON_NAME) {
                                type = NavType.StringType
                            }
                        )) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt(DOMAIN_COLOR)
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString(POKEMON_NAME)
                        }
                    }
                }
            }
        }
    }
}