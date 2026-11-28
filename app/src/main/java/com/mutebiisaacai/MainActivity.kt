
package com.mutebi.isaacai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.input.KeyboardType

private val Gold = Color(0xFFE5C477)
private val LightGold = Color(0xFFFFE6A0)
private val DarkGold = Color(0xFF98702E)
private val Black = Color(0xFF050505)
private val Panel = Color(0xFF101010)
private val White = Color(0xFFF8F3E8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = android.graphics.Color.BLACK
        window.navigationBarColor = android.graphics.Color.BLACK

        setContent {
            MaterialTheme {
                FinalApp()
            }
        }
    }
}

@Composable
fun FinalApp() {
    var text by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf("Home") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(horizontal = 13.dp, vertical = 8.dp)
    ) {

        // =========================
        // TOP WELCOME SCREEN
        // =========================

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(12.dp))

            // GOLD MICROPHONE AND STAR
            Box(
                modifier = Modifier.size(78.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "★",
                    color = LightGold,
                    fontSize = 39.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset(y = 0.dp)
                )

                Text(
                    text = "🎙",
                    fontSize = 55.sp,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
            }

            Spacer(Modifier.height(4.dp))

            Text(
                text = "Welcome",
                color = LightGold,
                fontSize = 43.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = "Your AI Assistant is Ready",
                color = Gold,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(20.dp))

            // DECORATIVE GOLD EMBLEM
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .border(
                        1.dp,
                        Brush.linearGradient(
                            listOf(LightGold, DarkGold, LightGold)
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .border(1.dp, Gold.copy(alpha = 0.45f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "✧",
                        color = Gold,
                        fontSize = 45.sp
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            Text(
                text = "Ready to assist you anytime, 24/7",
                color = LightGold,
                fontSize = 14.sp
            )

            Spacer(Modifier.weight(1f))

            // USER MESSAGE BUBBLE
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.78f)
                            .shadow(7.dp, RoundedCornerShape(20.dp))
                            .clip(
                                RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomStart = 20.dp,
                                    bottomEnd = 4.dp
                                )
                            )
                            .background(
                                Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFFD5B16B),
                                        Color(0xFFB98B42)
                                    )
                                )
                            )
                            .padding(15.dp)
                    ) {
                        Text(
                            "You: Hello Isaac",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        "12:55 AM",
                        color = Gold.copy(alpha = 0.8f),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(
                            end = 12.dp,
                            top = 4.dp
                        )
                    )
                }
            }

            Spacer(Modifier.height(8.dp))
        }

        // =========================
        // CHAT AND LIVING ROOM
        // =========================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.95f),
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {

            // AI CONVERSATION
            Column(
                modifier = Modifier
                    .weight(1.35f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFF171510),
                                Color(0xFF090909)
                            )
                        )
                    )
                    .border(
                        1.dp,
                        Gold.copy(alpha = 0.65f),
                        RoundedCornerShape(22.dp)
                    )
                    .padding(12.dp)
            ) {

                Text(
                    "AI conversation",
                    color = Gold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(9.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(17.dp))
                        .background(Color(0xFF211E13))
                        .border(
                            1.dp,
                            DarkGold.copy(alpha = 0.7f),
                            RoundedCornerShape(17.dp)
                        )
                        .padding(12.dp)
                ) {
                    Text(
                        "AI:",
                        color = LightGold,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "Welcome! I am your AI assistant created by Mutebi Isaac. How can I help you?",
                        color = White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 21.sp
                    )
                }

                Spacer(Modifier.height(7.dp))

                Text(
                    "12:55 AM",
                    color = Gold,
                    fontSize = 12.sp
                )
            }

            // ISAAC LIVING ROOM
            Column(
                modifier = Modifier
                    .weight(0.9f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFF302319),
                                Color(0xFF100D09)
                            )
                        )
                    )
                    .border(
                        1.dp,
                        Gold.copy(alpha = 0.75f),
                        RoundedCornerShape(22.dp)
                    )
                    .padding(7.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "Mutebi Isaac",
                    color = LightGold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(5.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color(0xFF59402A),
                                    Color(0xFF21170F)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    // TEMPORARY AVATAR.
                    // Your actual Isaac picture can be added here.

                    Text(
                        "👨🏿‍💼",
                        fontSize = 66.sp
                    )
                }

                Spacer(Modifier.height(5.dp))

                Text(
                    "Living Room",
                    color = Gold,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        // =========================
        // SEVEN GOLD SHORTCUTS
        // =========================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GoldIcon("👤")
            GoldIcon("☎")
            GoldIcon("🧭")
            GoldIcon("◎")
            GoldIcon("✎")
            GoldIcon("⛵")
            GoldIcon("℗")
        }

        Spacer(Modifier.height(12.dp))

        // =========================
        // MESSAGE INPUT AND MICROPHONES
        // =========================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color(0xFF0B0B0B))
                    .border(
                        1.5.dp,
                        Brush.horizontalGradient(
                            listOf(LightGold, DarkGold, Gold)
                        ),
                        RoundedCornerShape(35.dp)
                    )
                    .padding(horizontal = 17.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(modifier = Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        Text(
                            "Type here",
                            color = Gold.copy(alpha = 0.8f),
                            fontSize = 20.sp
                        )
                    }

                    BasicTextField(
                        value = text,
                        onValueChange = { text = it },
                        singleLine = true,
                        textStyle = androidx.compose.ui.text.TextStyle(
                            color = White,
                            fontSize = 18.sp
                        ),
                        cursorBrush = SolidColor(Gold),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Text(
                    "🎙",
                    fontSize = 24.sp
                )
            }

            Spacer(Modifier.width(9.dp))

            // MAIN GOLD VOICE ORB
            Box(
                modifier = Modifier
                    .size(62.dp)
                    .shadow(12.dp, CircleShape)
                    .background(
                        Brush.radialGradient(
                            listOf(
                                Color(0xFFFFF0B5),
                                Color(0xFFFFD66D),
                                Color(0xFFAA7829)
                            )
                        ),
                        CircleShape
                    )
                    .border(2.dp, LightGold, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "🎙",
                    fontSize = 29.sp
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        // =========================
        // BOTTOM NAVIGATION
        // =========================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(59.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(Color(0xFF11100D))
                .border(
                    1.dp,
                    Gold.copy(alpha = 0.55f),
                    RoundedCornerShape(18.dp)
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            listOf(
                "Home",
                "Chart",
                "History",
                "Settings"
            ).forEach { tab ->

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { selectedTab = tab },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        when (tab) {
                            "Home" -> "⌂"
                            "Chart" -> "▥"
                            "History" -> "◷"
                            else -> "⚙"
                        },
                        color = if (selectedTab == tab) LightGold else Gold.copy(alpha = 0.65f),
                        fontSize = 21.sp
                    )

                    Text(
                        tab,
                        color = if (selectedTab == tab) LightGold else Gold.copy(alpha = 0.75f),
                        fontSize = 13.sp,
                        fontWeight = if (selectedTab == tab) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(Modifier.height(5.dp))

        Text(
            "MUTEBI ISAAC AI - VERSION 1.0",
            color = Gold,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

// =================================
// BEAUTIFUL GOLD CIRCULAR SHORTCUT
// =================================

@Composable
fun GoldIcon(emoji: String) {

    Box(
        modifier = Modifier
            .size(48.dp)
            .shadow(5.dp, CircleShape)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF262015),
                        Color(0xFF080808)
                    )
                ),
                CircleShape
            )
            .border(
                1.5.dp,
                Brush.linearGradient(
                    listOf(
                        LightGold,
                        DarkGold,
                        Gold
                    )
                ),
                CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            emoji,
            color = LightGold,
            fontSize = 23.sp
        )
    }
}
