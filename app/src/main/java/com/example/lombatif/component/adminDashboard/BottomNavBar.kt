package com.example.lombatif.component.adminDashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavBar(selected: Int, onItemSelected: (Int) -> Unit) {
    val items = listOf(
        Pair("Home", Icons.Default.Home),
        Pair("Lomba", Icons.Default.EmojiEvents),
        Pair("Peserta", Icons.Default.Person),
        Pair("Juri", Icons.Default.Gavel),
        Pair("User", Icons.Default.Groups),
        Pair("Sertif", Icons.Default.WorkspacePremium)
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == index,
                onClick = { onItemSelected(index) },
                icon = { Icon(item.second, contentDescription = item.first) },
                label = { Text(item.first) }
            )
        }
    }
}