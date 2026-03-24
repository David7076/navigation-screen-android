package com.example.app_navigation_screen__android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_navigation_screen__android.screens.MenuScreen
import com.example.app_navigation_screen__android.screens.PedidosScreen
import com.example.app_navigation_screen__android.screens.PerfilScreen
import com.example.app_navigation_screen__android.screens.LoginScreen
import com.example.app_navigation_screen__android.ui.theme.AppnavigationscreenandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Ponto de entrada da UI
        setContent {
            AppnavigationscreenandroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Variavel responsavel por gerenciar a navegação entre as telas
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(
                            //Url que pode carregar um dado chamado cliente
                            route = "pedidos?cliente={cliente}",
                            //lista de argumentos que aguarda um texto chamado cliente,
                            // se nao trouxer nada, traz o texto Cliente Generico
                            arguments = listOf(navArgument("cliente"){
                                defaultValue = "Cliente Genérico"
                            })
                            ) {
                            PedidosScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                //Variavel que guarda os argumentos enviados  na rota pedidos
                                //GetString acessa os argumentos enviados
                                it.arguments?.getString("cliente"))
                        }
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                //Configuração de validação , exige que seja um tipo String
                                navArgument("nome") {type = NavType.StringType},
                                navArgument("idade") {type = NavType.IntType}
                            )

                        ) {
                            val nome: String? = it.arguments?.getString("nome", "Usuario generico")
                            val idade: Int? = it.arguments?.getInt("idade", 0)
                            PerfilScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                //Diz que esse valor nao é null
                                nome!!,
                                idade!!
                            )
                        }
                    }
                }
            }
        }
    }
}
