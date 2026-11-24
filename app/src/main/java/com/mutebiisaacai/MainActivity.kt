package com.mutebiisaacai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Gold = Color(0xFFD6AD55)
private val Black = Color(0xFF080808)
private val Panel = Color(0xFF191919)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IsaacHome()
        }
    }
}

@Composable
fun IsaacHome() {
    var message by remember { mutableStateOf("") }
    var reply by remember {
        mutableStateOf("Hello Isaac! I am ready to assist you.")
    }
    var selectedTab by remember { mutableStateOf("Home") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "MUTEBI ISAAC AI",
            color = Gold,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "THE HOUSE",
            color = Color.White,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Panel
            )
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "YOUR WORKSPACE",
                    color = Gold,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "ISAAC",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Your personal assistant",
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "🏠  WELCOME HOME",
                    color = Gold,
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Panel
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "LIVING ROOM",
                    color = Gold,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "🧑🏽‍💼",
                    fontSize = 65.sp
                )

                Text(
                    text = "Isaac is here!",
                    color = Color.White,
                    fontSize = 19.sp
                )

                Text(
                    text = "Your digital companion",
                    color = Color.LightGray
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Panel
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "ISAAC CHAT",
                    color = Gold,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = reply,
                    color = Color.White,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier.weight(1f),
                        placeholder = {
                            Text("Type your message")
                        },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Gold,
                            unfocusedBorderColor = Gold
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            if (message.isNotBlank()) {
                                reply = "You said: $message"
                                message = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Gold,
                            contentColor = Black
                        )
                    ) {
                        Text("SEND")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = {
                        reply = "Voice assistant features will be added next."
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Gold,
                        contentColor = Black
                    )
                ) {
                    Text("🎙  VOICE ASSISTANT")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "QUICK NAVIGATION",
            color = Gold,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("Home", "Chat", "History", "Settings").forEach { tab ->
                TextButton(
                    onClick = { selectedTab = tab },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = if (selectedTab == tab)
                            Gold else Color.White
                    )
                ) {
                    Text(tab)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "MUTEBI ISAAC AI • VERSION 1.0",
            color = Gold,
            fontSize = 11.sp
        )
    }
}
