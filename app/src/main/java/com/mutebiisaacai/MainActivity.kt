package com.mutebiisaacai

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    // ===== EXCELLENT BRAIN - HANDS =====
    // 1. Open ANY app on your phone
    fun openAnyApp(appName: String): String {
        val cleanName = appName.lowercase().trim()
        if (cleanName.isEmpty()) return "TELL ME WHICH APP BOSS"
        val pm = packageManager
        val apps = pm.getInstalledApplications(PackageManager.GET_META_DATA)
        for (app in apps) {
            val label = pm.getApplicationLabel(app).toString()
            if (label.lowercase().contains(cleanName)) {
                val intent = pm.getLaunchIntentForPackage(app.packageName)
                if (intent != null) {
                    startActivity(intent)
                    return "OPENING: ${label.uppercase()} IN WORKING SPACE"
                }
            }
        }
        return "APP NOT FOUND: ${appName.uppercase()} - CHECK NAME"
    }

    // 2. Do ANY task
    fun doTask(command: String): String {
        val text = command.lowercase().trim()
        return when {
            text.contains("open") -> {
                val appName = text.replace("open", "").replace("isaac", "").replace("please", "").trim()
                openAnyApp(appName)
            }
            text.contains("call") -> {
                val number = text.replace("call", "").replace("isaac", "").trim()
                try {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                    startActivity(intent)
                    "CALLING: $number IN WORKING SPACE"
                } catch (e: Exception) { "CANNOT CALL NOW BOSS" }
            }
            text.contains("youtube") || text.contains("play") -> {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))
                    startActivity(intent)
                    "OPENING YOUTUBE IN WORKING SPACE"
                } catch (e: Exception) { "CANNOT OPEN YOUTUBE" }
            }
            text.contains("trading") || text.contains("chart") -> "TRADING IS OPEN IN WORKING SPACE - BALANCE: \$12,450.32"
            text.contains("camera") -> openAnyApp("camera")
            text.contains("whatsapp") -> openAnyApp("whatsapp")
            text.contains("hello") || text.contains("hi") -> "HELLO BOSS, I AM READY IN WORKING SPACE"
            text.contains("who are you") -> "I AM ISAAC AI, YOUR HELPER BOSS"
            else -> "DOING TASK: ${command.uppercase()} IN WORKING SPACE"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { IsaacApp() }
    }

    @Composable
    fun IsaacApp() {
        var message by remember { mutableStateOf("") }
        var workingSpaceText by remember { mutableStateOf("READY BOSS - SAY ANY APP OR TASK") }
        var chatText by remember { mutableStateOf("AI: Yes boss, I am ready!") }

        val Black = Color(0xFF0B0B0B)
        val Panel = Color(0xFF111111)
        val Gold = Color(0xFFFFD700)
        val GoldDark = Color(0xFFD4AF37)

        Column(modifier = Modifier.fillMaxSize().background(Black).padding(6.dp)) {

            // 1. WORKING SPACE - EVERYTHING HAPPENS HERE
            Box(modifier = Modifier.weight(5f).fillMaxWidth().border(4.dp, Gold, RoundedCornerShape(16.dp)).background(Panel, RoundedCornerShape(16.dp)).padding(12.dp)) {
                Column {
                    Text("WORKING SPACE", color = Gold, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("Balance: \$12,450.32  +\$423.50", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(workingSpaceText, color = Color(0xFF00FF00), fontSize = 19.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Button(onClick = { workingSpaceText = "BUY DONE IN WORKING SPACE" }, colors = ButtonDefaults.buttonColors(containerColor = GoldDark), modifier = Modifier.weight(1f)) { Text("BUY", fontWeight = FontWeight.Bold, color = Color.Black) }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { workingSpaceText = "SELL DONE IN WORKING SPACE" }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853)), modifier = Modifier.weight(1f)) { Text("SELL", fontWeight = FontWeight.Bold, color = Color.White) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // 2. MESSAGE + LIVING ROOM - YOUR REAL PICTURE, NO EMOJIS
            Row(modifier = Modifier.weight(2.5f).fillMaxWidth()) {
                Column(modifier = Modifier.weight(2f).fillMaxHeight().border(3.dp, GoldDark, RoundedCornerShape(12.dp)).background(Panel, RoundedCornerShape(12.dp)).padding(10.dp).verticalScroll(rememberScrollState())) {
                    Text("AI conversation", color = Gold, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("You: Isaac open trading", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(chatText, color = Gold, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(6.dp))
                Column(modifier = Modifier.weight(1f).fillMaxHeight().border(3.dp, GoldDark, RoundedCornerShape(12.dp)).background(Panel, RoundedCornerShape(12.dp)).padding(6.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Mutebi Isaac", color = Gold, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Image(painter = painterResource(id = R.drawable.isaac_living_room), contentDescription = "Isaac", modifier = Modifier.size(80.dp))
                    Text("Living Room", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // 3. APPS ROW - TEXT ONLY, NO EMOJIS
            Row(modifier = Modifier.fillMaxWidth().height(60.dp).border(3.dp, GoldDark, RoundedCornerShape(12.dp)).background(Panel, RoundedCornerShape(12.dp)), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                Text("CAMERA", color = Gold, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("WHATSAPP", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("TRADING", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("CALL", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("WEB", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))

            // 4. TYPE HERE + SEND - THE BRAIN BUTTON
            Row(modifier = Modifier.fillMaxWidth().height(60.dp)) {
                TextField(value = message, onValueChange = { message = it }, placeholder = { Text("Type here...", color = GoldDark, fontWeight = FontWeight.Bold) }, modifier = Modifier.weight(1f).border(3.dp, GoldDark, RoundedCornerShape(12.dp)), colors = TextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White, focusedContainerColor = Panel, unfocusedContainerColor = Panel))
                Spacer(modifier = Modifier.width(6.dp))
                Button(onClick = {
                    if (message.isNotBlank()) {
                        val result = doTask(message)
                        workingSpaceText = result
                        chatText = "AI: Yes boss, $result"
                        message = ""
                    } else {
                        Toast.makeText(this@MainActivity, "Type something Boss", Toast.LENGTH_SHORT).show()
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = GoldDark), modifier = Modifier.width(80.dp)) { Text("SEND", fontWeight = FontWeight.Bold, color = Color.Black) }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // 5. BOTTOM MENU
            Row(modifier = Modifier.fillMaxWidth().height(55.dp).border(3.dp, GoldDark, RoundedCornerShape(12.dp)).background(Panel, RoundedCornerShape(12.dp)), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                Text("Home", color = Gold, fontWeight = FontWeight.Bold)
                Text("Chart", color = Color.White, fontWeight = FontWeight.Bold)
                Text("History", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Settings", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("MUTEBI ISAAC AI - VERSION 1.0", color = Gold, fontSize = 11.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
