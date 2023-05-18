package com.southgard.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.southgard.learningapp.login.LoginScreen
import com.southgard.learningapp.login.LoginViewModel
import com.southgard.learningapp.ui.theme.LearningAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val navigationController = rememberNavController()
//                    NavHost(navController = navigationController, startDestination = Routes.Screen1.route) {
//                        composable(route = Routes.Screen1.route) { Screen1(navigationController) }
//                        composable(route = Routes.Screen2.route) { Screen2(navigationController) }
//                        composable(route = Routes.Screen3.route) { Screen3(navigationController) }
//                        composable(route = Routes.Screen4.route,
//                            arguments = listOf(navArgument("age") {type = NavType.IntType})
//                        ) { BackStackEntry ->
//                            Screen4(
//                                navigationController,
//                                BackStackEntry.arguments?.getInt("age") ?: 0
//                            )
//                        }
//                        composable(route = Routes.Screen5.route,
//                            arguments = listOf(navArgument("name") {defaultValue = ""})
//                        ) { BackStackEntry ->
//                            Screen5(
//                                navigationController,
//                                BackStackEntry.arguments?.getString("name")
//                            )
//                        }
//
//                    }

                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningAppTheme {
        Greeting("Android")
    }
}