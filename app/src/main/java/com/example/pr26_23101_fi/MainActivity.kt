package com.example.pr26_23101_fi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "wallet") {

        composable("wallet") {
            WalletScreen(
                onNavigateToAddPayment = { navController.navigate("add_payment") },
                onNavigateToTracking = { navController.navigate("tracking") },
                onNavigateToSendPackage = { navController.navigate("send_package") }
            )
        }

        composable("add_payment") {
            AddPaymentMethodScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable("tracking") {
            TrackingPackageScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToDeliverySuccess = { navController.navigate("delivery_success") }
            )
        }

        composable("delivery_success") {
            DeliverySuccessScreen1(onNavigateToWallet = {
                navController.navigate("wallet") { popUpTo("wallet") { inclusive = true } }
            })
        }

        composable("send_package") {
            SendPackageScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}