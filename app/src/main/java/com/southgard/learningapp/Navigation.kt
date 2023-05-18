package com.southgard.learningapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.southgard.learningapp.model.Routes

@Composable
fun Screen1(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Cyan)){
        Text(text = "SCREEN 1", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(
            Routes.Screen2.route) })
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green)){
        Text(text = "SCREEN 2", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Screen3.route) })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow)){
        Text(text = "SCREEN 3", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Screen4.createRoute(15)) })
    }
}

@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)){
        Text(text = age.toString(), modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Screen5.createRoute("Guillem")) })
    }
}

@Composable
fun Screen5(navController: NavHostController, name: String?) {
    Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray)){
        Text(text = "$name", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Screen4.createRoute(15)) })
    }
}