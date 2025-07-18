package com.example.lombatif.component.juriDashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lombatif.component.adminDashboard.ProfileScreen
import com.example.lombatif.ui.theme.LombaTIFTheme
import com.example.lombatif.viewModels.ViewProfile


// Fungsi ini dipanggil dari JuriMainScreen
@Composable
fun JuriDashboardScreen(
    onLogout: () -> Unit,
    profileViewModel: ViewProfile = viewModel()
) {
    var showProfile by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF0F2F5)).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Tambahkan jarak antar item
        ) {
            // Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Dashboard Juri",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Ikon Profil",
                        modifier = Modifier.size(40.dp).clickable { showProfile = true },
                        tint = Color.Gray
                    )
                }
            }

            // ============================================
            // BAGIAN DESAIN YANG HILANG (DIKEMBALIKAN)
            // ============================================
            // Kartu Ringkasan
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SummaryCard("Submission Total", "3", Color(0xFFE0E7FF))
                    SummaryCard("Sudah Dinilai", "3", Color(0xFFD1FAE5))
                    SummaryCard("Belum Dinilai", "0", Color(0xFFFEE2E2))
                }
            }

            // Tabel Submission Terbaru
            item {
                SubmissionTerbaru()
            }
            // ============================================
        }

        if (showProfile) {
            ProfileScreen(
                viewModel = profileViewModel,
                onBack = { showProfile = false },
                onLogout = onLogout
            )
        }
    }
}


// Helper Composable untuk desain Anda
@Composable
fun RowScope.SummaryCard(title: String, value: String, backgroundColor: Color) {
    Card(
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(backgroundColor)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SubmissionTerbaru() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Submission Terbaru", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Text("Lihat Semua", color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Header Tabel
            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                Text("NAMA PESERTA", modifier = Modifier.weight(1f), color = Color.Gray, fontSize = 12.sp)
                Text("NAMA LOMBA", modifier = Modifier.weight(1.5f), color = Color.Gray, fontSize = 12.sp)
                Text("TANGGAL", modifier = Modifier.weight(1f), color = Color.Gray, fontSize = 12.sp)
                Text("AKSI", modifier = Modifier.weight(0.5f), color = Color.Gray, fontSize = 12.sp)
            }
            Divider()

            // Contoh Baris Tabel
            SubmissionRow("Dandy Teguh Pratama", "PORSENI VOLI HIMATIF", "11/6/2025")
        }
    }
}

@Composable
fun SubmissionRow(nama: String, lomba: String, tanggal: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(nama, modifier = Modifier.weight(1f), fontSize = 14.sp)
        Text(lomba, modifier = Modifier.weight(1.5f), fontSize = 14.sp)
        Text(tanggal, modifier = Modifier.weight(1f), fontSize = 14.sp)
        Text("Nilai", modifier = Modifier.weight(0.5f), color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
    }
    Divider()
}


@Preview(showBackground = true)
@Composable
fun JuriDashboardScreenPreview() {
    LombaTIFTheme {
        JuriDashboardScreen(onLogout = {})
    }
}