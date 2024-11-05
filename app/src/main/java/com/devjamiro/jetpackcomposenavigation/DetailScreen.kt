package com.devjamiro.jetpackcomposenavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.devjamiro.jetpackcomposenavigation.core.navigation.SettingsInfo

@Composable
fun DetailScreen(
    name: String,
    navigateToSettings: (SettingsInfo) -> Unit,
    navigateBack: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Detail Screen $name",
            fontSize = (25.sp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            val settingsInfo = SettingsInfo(
                name = "Settings",
                id = 1,
                darkMode = true
            )
            navigateToSettings(settingsInfo)
        }) {
            Text("Navigate to Config")
        }
        Button(onClick = { navigateBack() }) {
            Text("LogOut")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}