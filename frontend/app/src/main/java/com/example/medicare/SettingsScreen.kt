package com.example.medicare

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(onNavigate: (Screen) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F4))
            .padding(20.dp)
    ) {

        // -------------------------------
        // Heading
        // -------------------------------
        Text(
            text = "Settings",
            fontSize = 28.sp,
            color = Color(0xFF0A8A39),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        // -------------------------------
        // Settings Options
        // -------------------------------
        SettingItemVector(
            icon = Icons.Default.Person,
            title = "Profile",
            subtitle = "Manage your account"
        )

        SettingItemVector(
            icon = Icons.Default.Notifications,
            title = "Notifications",
            subtitle = "Alerts & reminders"
        )

        // PRIVACY → USING DRAWABLE IMAGE
        SettingItemImage(
            iconRes = R.drawable.security,
            title = "Privacy",
            subtitle = "Manage data & permissions"
        )

        SettingItemVector(
            icon = Icons.Default.Info,
            title = "About",
            subtitle = "App version, developer info"
        )

        Spacer(modifier = Modifier.weight(1f))

        // -------------------------------
        // Bottom Navigation Bar
        // -------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(icon = Icons.Default.Home, label = "home")
            BottomNavItem(icon = Icons.Default.AddCircle, label = "add")
            BottomNavItem(icon = Icons.Default.Notifications, label = "alerts")
            BottomNavItem(icon = Icons.Default.Settings, label = "settings")
        }
    }
}

//
// ─────────────────────────────────────────────────────────
//  TWO SEPARATE SETTING ITEM COMPOSABLES
// ─────────────────────────────────────────────────────────
// 1. VECTOR ICON VERSION
//
@Composable
fun SettingItemVector(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color(0xFF0A8A39),
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Text(subtitle, fontSize = 13.sp, color = Color.Gray)
        }
    }
}

//
// 2. IMAGE RESOURCE VERSION (for your privacy icon)
//
@Composable
fun SettingItemImage(iconRes: Int, title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = "",
            tint = Color(0xFF0A8A39),
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Text(subtitle, fontSize = 13.sp, color = Color.Gray)
        }
    }
}

//
// ─────────────────────────────────────────────────────────
// Bottom Navigation Item
// ─────────────────────────────────────────────────────────
//
@Composable
fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            icon,
            contentDescription = "",
            tint = Color(0xFF0A8A39),
            modifier = Modifier.size(28.dp)
        )
        Text(label, fontSize = 12.sp)
    }
}
