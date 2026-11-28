package com.mutebi.isaacai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { FinalApp() }
    }
}

@Composable
fun FinalApp() {
    var text by remember { mutableStateOf("") }
    val gold = Color(0xFFD4AF37)
    val bg = Color(0xFF0F0F0F)
    val card = Color(0xFF1C1C1C)

    Column(modifier = Modifier.fillMaxSize().background(bg).padding(16.dp)) {
        Text("Welcome", color = gold, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text("Your AI Assistant is Ready", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text("Ready to assist you anytime, 24/7", color = Color(0xFFAAAAAA), fontSize = 13.sp)
        Spacer(modifier = Modifier.height(18.dp))

        Column(modifier = Modifier.fillMaxWidth().weight(1f).clip(RoundedCornerShape(18.dp)).background(card).padding(14.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Box(modifier = Modifier.clip(RoundedCornerShape(14.dp)).background(gold).padding(12.dp)) {
                    Text("You: Hello Isaac", color = Color.Black, fontSize = 14.sp)
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Box(modifier = Modifier.clip(RoundedCornerShape(14.dp)).background(Color(0xFF2B2B2B)).padding(12.dp)) {
                Text("AI: Welcome! I am your AI assistant created by Mutebi Isaac. How can I help you?", color = Color.White, fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.height(18.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            GoldIcon("👤"); GoldIcon("💬"); GoldIcon("🧭"); GoldIcon("📸"); GoldIcon("✏️"); GoldIcon("🏀"); GoldIcon("📌")
        }
        Spacer(modifier = Modifier.height(18.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.weight(1f).height(52.dp).clip(RoundedCornerShape(28.dp)).background(card).padding(horizontal = 16.dp, vertical = 14.dp)) {
                if (text.isEmpty()) Text("Type here...", color = Color.Gray, fontSize = 15.sp)
                BasicTextField(value = text, onValueChange = { text = it }, modifier = Modifier.fillMaxWidth())
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(gold), contentAlignment = Alignment.Center) { Text("🎤", fontSize = 22.sp) }
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(gold), contentAlignment = Alignment.Center) { Text("🎤", fontSize = 22.sp) }
        }
        Spacer(modifier = Modifier.height(18.dp))

        Row(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(card).padding(vertical = 12.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text("🏠 Home", color = gold, fontWeight = FontWeight.Bold)
            Text("📊 Chart", color = Color.Gray)
            Text("🕒 History", color = Color.Gray)
            Text("⚙️ Settings", color = Color.Gray)
        }
    }
}

@Composable
fun GoldIcon(emoji: String) {
    Box(modifier = Modifier.size(46.dp).clip(CircleShape).background(Color(0xFF1C1C1C)), contentAlignment = Alignment.Center) {
        Text(emoji, fontSize = 20.sp)
    }
}
