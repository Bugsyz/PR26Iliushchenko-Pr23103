package com.example.pr26_23101_fi

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun DeliverySuccessScreen1(
    onNavigateToWallet: () -> Unit,
    modifier: Modifier = Modifier
) {
    var progress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progress < 1f) {
            delay(50)
            progress = (progress + 0.02f).coerceAtMost(1f)
        }
        delay(1000)
        onNavigateToWallet()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(120.dp),
            strokeWidth = 8.dp,
            color = Color(0xFF0560FA),
            trackColor = Color(0xFF0560FA).copy(alpha = 0.1f)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "Your Order",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Processing...",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNavigateToWallet,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0560FA)
            )
        ) {
            Text("Done", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}