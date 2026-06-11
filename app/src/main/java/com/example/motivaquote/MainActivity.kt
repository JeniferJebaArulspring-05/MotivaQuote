package com.example.motivaquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivaquote.ui.theme.MotivaQuoteTheme

data class Quote(
    val text: String,
    val author: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MotivaQuoteTheme {
                QuoteScreen()
            }
        }
    }
}

@Composable
fun QuoteScreen() {

    val quotes = listOf(
        Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
        Quote("Success is not final, failure is not fatal.", "Winston Churchill"),
        Quote("Stay hungry, stay foolish.", "Steve Jobs"),
        Quote("Dream big and dare to fail.", "Norman Vaughan"),
        Quote("The future depends on what you do today.", "Mahatma Gandhi"),
        Quote("It always seems impossible until it's done.", "Nelson Mandela"),
        Quote("Never give up.", "Winston Churchill"),
        Quote("Turn your wounds into wisdom.", "Oprah Winfrey"),
        Quote("Be yourself; everyone else is already taken.", "Oscar Wilde"),
        Quote("Opportunities don't happen. You create them.", "Chris Grosser")
    )

    var currentQuote by remember {
        mutableStateOf(quotes.random())
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.motivation_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xAA111111)
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "🔥MotivaQuote",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "❝",
                    color = Color.White,
                    fontSize = 40.sp
                )

                Text(
                    text = currentQuote.text,
                    color = Color.White,
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "- ${currentQuote.author}",
                    color = Color.LightGray,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        currentQuote = quotes.random()
                    }
                ) {
                    Text("Get Inspired ✨")
                }
            }
        }
    }
}