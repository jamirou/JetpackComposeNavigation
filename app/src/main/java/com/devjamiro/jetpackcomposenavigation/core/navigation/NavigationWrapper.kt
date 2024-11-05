package com.devjamiro.jetpackcomposenavigation.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.devjamiro.jetpackcomposenavigation.DetailScreen
import com.devjamiro.jetpackcomposenavigation.HomeScreen
import com.devjamiro.jetpackcomposenavigation.LoginScreen
import com.devjamiro.jetpackcomposenavigation.SettingsScreen
import com.devjamiro.jetpackcomposenavigation.core.navigation.type.createNavType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen { navController.navigate(Home) }
        }
        composable<Home> {
            HomeScreen { name -> navController.navigate(Detail(name = name)) }
        }
        composable<Detail> { it ->
            val detail = it.toRoute<Detail>()
            DetailScreen(
                name = detail.name,
                navigateBack = { navController.navigateUp() },
                navigateToSettings = { navController.navigate(Settings(it)) })
        }
        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavType<SettingsInfo>())) { backStackEntry ->
            val settings: Settings = backStackEntry.toRoute()
            SettingsScreen(settings.info)
        }
    }
}