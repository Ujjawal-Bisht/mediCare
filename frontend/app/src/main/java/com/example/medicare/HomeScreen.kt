package com.example.medicare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {

    val gradientGreen = Brush.verticalGradient(
        colors = listOf(Color(0xFF0A8A39), Color(0xFF7ED957))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F4))
    ) {

        // TOP CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = gradientGreen,
                    shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(20.dp)
            ) {
                Text("Good", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Text("Morning", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
            }

            // Profile Icon
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterEnd)
                    .padding(20.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "",
                    tint = Color(0xFF0A8A39),
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // SEARCH BAR
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(Color.White, RoundedCornerShape(50.dp))
                .fillMaxWidth()
                .height(50.dp)
                .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(Icons.Default.Search, contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text("Search...", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // CATEGORY BUTTONS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryItem(R.drawable.ic_general, "general")
            CategoryItem(R.drawable.ic_mental, "mental")
            CategoryItem(R.drawable.ic_hygiene, "hygiene")
            CategoryItem(R.drawable.ic_specialist, "specialist")
        }

        Spacer(modifier = Modifier.height(25.dp))

        // ASK DOUBTS
        Text(
            "Ask Doubts",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        val query = remember { mutableStateOf("") }

        TextField(
            value = query.value,
            onValueChange = { query.value = it },
            placeholder = { Text("enter your query") },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .border(1.dp, Color(0xFF0A8A39), RoundedCornerShape(50.dp))
        )

        // REMINDERS
        Text(
            "Reminders",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = "")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("appointment with Dr. Keshav")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Info, contentDescription = "")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("notify Dr. Keshav about new symptoms")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // BOTTOM NAVIGATION
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomIcon(Icons.Default.Home, "home")
            BottomIcon(Icons.Default.AddCircle, "add")
            BottomIcon(Icons.Default.Notifications, "alerts")
            BottomIcon(Icons.Default.Settings, "settings")
        }
    }
}

@Composable
fun CategoryItem(icon: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color(0xFFD9F5DF), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier.size(45.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(label)
    }
}

@Composable
fun BottomIcon(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = "", tint = Color(0xFF0A8A39), modifier = Modifier.size(30.dp))
        Text(label, fontSize = 12.sp)
    }
}
@Composable
fun BottomNavItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            icon,
            contentDescription = "",
            tint = Color(0xFF0A8A39),
            modifier = Modifier
                .size(28.dp)
                .clickable { onClick() }
        )
        Text(label, fontSize = 12.sp)
    }
}

