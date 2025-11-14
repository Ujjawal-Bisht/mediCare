package com.example.medicare

import androidx.compose.runtime.*
import androidx.compose.material3.*
import com.example.healthui.AiChatScreen

enum class Screen {
    HOME, SETTINGS, TRACKER
}

@Composable
fun AppNavigator() {

    var currentScreen by remember { mutableStateOf(Screen.HOME) }

    when (currentScreen) {
        Screen.HOME -> HomeScreen(
            onNavigate = { screen -> currentScreen = screen }
        )
        Screen.SETTINGS -> SettingsScreen(
            onNavigate = { screen -> currentScreen = screen }
        )
        Screen.TRACKER -> TrackerScreen(
            onNavigate = { screen -> currentScreen = screen }
        )
    }
}
