package com.example.medicare

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrackerScreen(onNavigate: (Screen) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F4))
            .padding(20.dp)
    ) {

        // Title
        Text(
            text = "Health Tracker",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0A8A39)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // -----------------------------
        // Appointments Section
        // -----------------------------
        Text("Upcoming Appointments", fontSize = 20.sp, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(12.dp))

        SimpleCard("• 25 Nov — General Checkup at 10:30 AM")
        Spacer(modifier = Modifier.height(8.dp))

        SimpleCard("• 12 Dec — Eye Specialist at 01:00 PM")
        Spacer(modifier = Modifier.height(8.dp))

        SimpleCard("• 04 Jan — Dental Care at 09:45 AM")

        Spacer(modifier = Modifier.height(30.dp))

        // -----------------------------
        // Period Tracker (Simple Text)
        // -----------------------------
        Text("Period Tracker", fontSize = 20.sp, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(12.dp))

        SimpleCard("Status: Safe Period")
        Spacer(modifier = Modifier.height(8.dp))

        SimpleCard("Cycle Day: 12 / 28")
        Spacer(modifier = Modifier.height(8.dp))

        SimpleCard("Next Period: Approx. 3 Dec 2025")
    }
}

@Composable
fun SimpleCard(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(text, fontSize = 16.sp)
    }
}
