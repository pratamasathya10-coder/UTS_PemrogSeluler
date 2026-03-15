package com.example.uts_pemrogseluler

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var namaDosen by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Portal Login Dosen")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = namaDosen,
            onValueChange = { namaDosen = it },
            label = { Text("Nama Dosen") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("panel/$namaDosen")
            }
        ) {
            Text("MASUK")
        }

    }
}