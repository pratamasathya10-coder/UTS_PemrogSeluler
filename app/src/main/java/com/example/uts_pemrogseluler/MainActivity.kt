package com.example.uts_pemrogseluler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.example.uts_pemrogseluler.ui.theme.UTS_PemrogSelulerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            UTS_PemrogSelulerTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {

                    composable("login") {
                        LoginScreen(navController)
                    }

                    composable("panel/{nama}") { backStackEntry ->

                        val nama =
                            backStackEntry.arguments?.getString("nama") ?: ""

                        PanelScreen(nama)

                    }

                }

            }

        }
    }
}