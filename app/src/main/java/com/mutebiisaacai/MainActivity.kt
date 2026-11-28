package com.mutebi.isaacai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Gold = Color(0xFFD4AF62)
private val BrightGold = Color(0xFFFFE5A0)
private val DarkGold = Color(0xFF80602C)
private val Black = Color(0xFF050505)
private val Panel = Color(0xFF11100D)
private val White = Color(0xFFF8F5EE)
private val Green = Color(0xFF39E600)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { FinalApp() }
    }
}

@Composable
fun FinalApp() {
    var message by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf("Home") }
    var monitorOpen by remember { mutableStateOf(false) }

    BackHandler(enabled = monitorOpen) { monitorOpen = false }

    Box(modifier = Modifier.fillMaxSize().background(Black).safeDrawingPadding()) {
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp, vertical = 8.dp)) {

            // UPPER WORKING SPACE / MONITOR - DO NOT CHANGE
            Column(
                modifier = Modifier.fillMaxWidth().weight(1.30f).clip(RoundedCornerShape(25.dp)).background(Color(0xFF090909)).border(1.5.dp, Gold, RoundedCornerShape(25.dp)).clickable { monitorOpen = true }.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier.size(75.dp), contentAlignment = Alignment.Center) {
                    Text("★", color = BrightGold, fontSize = 43.sp, modifier = Modifier.align(Alignment.TopCenter))
                    Text("🎙", fontSize = 48.sp, modifier = Modifier.align(Alignment.BottomCenter))
                }
                Spacer(Modifier.height(5.dp))
                Text("Welcome", color = BrightGold, fontSize = 39.sp, fontWeight = FontWeight.Normal)
                Text("Your AI Assistant is Ready", color = Gold, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(20.dp))
                Box(modifier = Modifier.size(94.dp).border(1.dp, Gold, CircleShape), contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier.size(72.dp).border(1.dp, DarkGold, CircleShape), contentAlignment = Alignment.Center) {
                        Text("✧", color = BrightGold, fontSize = 43.sp)
                    }
                }
                Spacer(Modifier.height(12.dp))
                Text("Ready to assist you anytime, 24/7", color = BrightGold, fontSize = 14.sp)
            }

            Spacer(Modifier.height(9.dp))

            // USER MESSAGE
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Column(horizontalAlignment = Alignment.End) {
                    Box(modifier = Modifier.fillMaxWidth(0.76f).clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp, bottomStart = 18.dp, bottomEnd = 4.dp)).background(Color(0xFFB9914B)).padding(14.dp)) {
                        Text("You: Hello Isaac", color = White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    }
                    Text("12:55 AM", color = Gold, fontSize = 12.sp)
                }
            }

            Spacer(Modifier.height(9.dp))

            // AI CHAT AND LIVING ROOM
            Row(modifier = Modifier.fillMaxWidth().weight(0.85f), horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                Column(modifier = Modifier.weight(1.35f).fillMaxHeight().clip(RoundedCornerShape(21.dp)).background(Panel).border(1.dp, DarkGold, RoundedCornerShape(21.dp)).padding(11.dp)) {
                    Text("AI conversation", color = Gold, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(10.dp))
                    Column(modifier = Modifier.fillMaxWidth().weight(1f).clip(RoundedCornerShape(16.dp)).background(Color(0xFF211E14)).border(1.dp, DarkGold, RoundedCornerShape(16.dp)).padding(12.dp)) {
                        Text("AI:", color = BrightGold, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Text("Welcome! I am your AI assistant created by Mutebi Isaac. How can I help you?", color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, lineHeight = 20.sp)
                    }
                    Spacer(Modifier.height(5.dp))
                    Text("12:55 AM", color = Gold, fontSize = 12.sp)
                }
                Column(modifier = Modifier.weight(0.90f).fillMaxHeight().clip(RoundedCornerShape(21.dp)).background(Color(0xFF19130E)).border(1.dp, Gold, RoundedCornerShape(21.dp)).padding(7.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Mutebi Isaac", color = BrightGold, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(6.dp))
                    Box(modifier = Modifier.fillMaxWidth().weight(1f).clip(RoundedCornerShape(14.dp)).background(Color(0xFF493522)), contentAlignment = Alignment.Center) {
                        Text("👨🏿‍💼", fontSize = 65.sp)
                    }
                    Text("Living Room", color = Gold, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(10.dp))

            // SEVEN GOLD SHORTCUTS
            Row(modifier = Modifier.fillMaxWidth().height(57.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                GoldIcon("👥"); GoldIcon("☎"); GoldIcon("🧭"); GoldIcon("◎"); GoldIcon("✎"); GoldIcon("⛵"); GoldIcon("℗")
            }

            Spacer(Modifier.height(10.dp))

            // MESSAGE INPUT AND GOLD MIC
            Row(modifier = Modifier.fillMaxWidth().height(61.dp), verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(35.dp)).background(Panel).border(1.5.dp, Gold, RoundedCornerShape(35.dp)).padding(horizontal = 17.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.weight(1f)) {
                        if (message.isEmpty()) { Text("Type here", color = Gold, fontSize = 19.sp) }
                        BasicTextField(value = message, onValueChange = { message = it }, singleLine = true, textStyle = TextStyle(color = White, fontSize = 18.sp), cursorBrush = SolidColor(Gold), modifier = Modifier.fillMaxWidth())
                    }
                    Text("🎙", fontSize = 23.sp)
                }
                Spacer(Modifier.width(9.dp))
                Box(modifier = Modifier.size(60.dp).background(Color(0xFFFFD777), CircleShape).border(2.dp, BrightGold, CircleShape), contentAlignment = Alignment.Center) {
                    Text("🎙", fontSize = 29.sp)
                }
            }

            Spacer(Modifier.height(9.dp))

            // BOTTOM NAVIGATION
            Row(modifier = Modifier.fillMaxWidth().height(57.dp).clip(RoundedCornerShape(17.dp)).background(Panel).border(1.dp, DarkGold, RoundedCornerShape(17.dp)), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                listOf("Home", "Chart", "History", "Settings").forEach { tab ->
                    Column(modifier = Modifier.weight(1f).fillMaxHeight().clickable { selectedTab = tab }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(when (tab) { "Home" -> "⌂"; "Chart" -> "▥"; "History" -> "◷"; else -> "⚙" }, color = if (selectedTab == tab) BrightGold else Gold, fontSize = 21.sp)
                        Text(tab, color = if (selectedTab == tab) BrightGold else Gold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(5.dp))
            Text("MUTEBI ISAAC AI - VERSION 1.0", color = Gold, fontSize = 11.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }

        // FULL-SCREEN WORKING SPACE DOOR
        if (monitorOpen) {
            Column(modifier = Modifier.fillMaxSize().background(Black).padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text("★", color = BrightGold, fontSize = 55.sp)
                Text("🎙", fontSize = 60.sp)
                Spacer(Modifier.height(15.dp))
                Text("WELCOME TO", color = Gold, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Text("MUTEBI ISAAC AI", color = BrightGold, fontSize = 30.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                Spacer(Modifier.height(25.dp))
                Text("WORKING SPACE", color = Green, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(12.dp))
                Text("Your AI Assistant is Ready", color = White, fontSize = 17.sp)
                Spacer(Modifier.height(35.dp))
                Box(modifier = Modifier.fillMaxWidth().height(60.dp).clip(RoundedCornerShape(30.dp)).background(Color(0xFFB9914B)).clickable { monitorOpen = false }, contentAlignment = Alignment.Center) {
                    Text("CLOSE WORKING SPACE", color = Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun GoldIcon(emoji: String) {
    Box(modifier = Modifier.size(46.dp).background(Panel, CircleShape).border(1.5.dp, Gold, CircleShape), contentAlignment = Alignment.Center) {
        Text(emoji, fontSize = 21.sp)
    }
}
