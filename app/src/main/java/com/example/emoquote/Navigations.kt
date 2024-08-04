package com.example.emoquote

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.emoquote.pages.Anger
import com.example.emoquote.pages.Happy
import com.example.emoquote.pages.HomePage
import com.example.emoquote.pages.LoginPage
import com.example.emoquote.pages.Love
import com.example.emoquote.pages.Sad
import com.example.emoquote.pages.SignupPage

@Composable
fun Navigations(modifier:Modifier=Modifier,authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginPage(modifier,navController,authViewModel)
        }
        composable("signup"){
            SignupPage(modifier,navController,authViewModel)
        }
        composable("home"){
            HomePage(modifier,navController,authViewModel)
        }
        composable("happy") {
            Happy(modifier, navController, authViewModel)
        }
        composable("sad") {
            Sad(modifier, navController, authViewModel)
        }
        composable("anger") {
            Anger(modifier, navController, authViewModel)
        }
        composable("love") {
            Love(modifier, navController, authViewModel)
        }

    })


}
