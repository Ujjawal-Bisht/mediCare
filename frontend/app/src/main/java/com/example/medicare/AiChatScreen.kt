package com.example.healthui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicare.R

@Composable
fun AiChatScreen() {

    val greenGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF0A8A39), Color(0xFF7ED957))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        // ---------------------------
        // Heading
        // ---------------------------
        Text(
            text = "conversate\nwith AI",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0A8A39),
            lineHeight = 32.sp,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // ---------------------------
        // Big Green Mic PNG
        // ---------------------------
        Box(
            modifier = Modifier
                .size(180.dp)
                .background(Color(0xFF0A8A39), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_mic),
                contentDescription = "",
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        // ---------------------------
        // Audio Wave PNG
        // ---------------------------
        Image(
            painter = painterResource(id = R.drawable.ic_wave),
            contentDescription = "",
            modifier = Modifier
                .width(220.dp)
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // ---------------------------
        // Chat Bubbles
        // ---------------------------
        AiChatBubble(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            isUser = false
        )

        Spacer(modifier = Modifier.height(20.dp))

        AiChatBubble(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            isUser = true
        )

        Spacer(modifier = Modifier.weight(1f))

        // ---------------------------
        // Bottom Navigation
        // ---------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(Icons.Default.Home, "home")
            BottomNavHighlight("ask ai")
            BottomNavItem(Icons.Default.Notifications, "alerts")
            BottomNavItem(Icons.Default.Settings, "settings")
        }
    }
}

@Composable
fun AiChatBubble(text: String, isUser: Boolean) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(
                if (isUser) Color(0xFFC7F6D1) else Color.White,
                RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
            .fillMaxWidth(0.85f)
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}

@Composable
fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            icon,
            contentDescription = "",
            tint = Color(0xFF0A8A39),
            modifier = Modifier.size(30.dp)
        )
        Text(label, fontSize = 12.sp)
    }
}

@Composable
fun BottomNavHighlight(label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .background(Color(0xFF0A8A39), RoundedCornerShape(20.dp))
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            Text(label, color = Color.White, fontSize = 14.sp)
        }
    }
}
