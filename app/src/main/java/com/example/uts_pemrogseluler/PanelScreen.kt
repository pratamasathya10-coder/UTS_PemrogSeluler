package com.example.uts_pemrogseluler

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PanelScreen(nama: String) {

    var jumlahMahasiswa by remember { mutableStateOf("") }
    var rataNilai by remember { mutableStateOf("") }

    var hasil by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Selamat bertugas, Dosen $nama")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = jumlahMahasiswa,
            onValueChange = { jumlahMahasiswa = it },
            label = { Text("Jumlah Mahasiswa") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = rataNilai,
            onValueChange = { rataNilai = it },
            label = { Text("Rata-rata Nilai") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val jumlah = jumlahMahasiswa.toIntOrNull() ?: 0
            val nilai = rataNilai.toIntOrNull() ?: 0

            // IF ELSE
            val status = when {
                nilai >= 80 -> "Sangat Baik"
                nilai >= 60 -> "Cukup"
                else -> "Kurang"
            }

            var daftar = "Status Kelas: $status\n\nDaftar Absen:\n"

            // FOR LOOP
            for (i in 1..jumlah) {
                daftar += "Mahasiswa $i : ______\n"
            }

            hasil = daftar

        }) {

            Text("PROSES DATA")

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(hasil)

    }
}