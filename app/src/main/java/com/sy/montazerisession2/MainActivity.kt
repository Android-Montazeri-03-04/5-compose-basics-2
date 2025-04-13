@file:OptIn(ExperimentalMaterial3Api::class)

package com.sy.montazerisession2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sy.montazerisession2.ui.theme.MontazeriSession2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = listOf(
            Icons.Default.AccountCircle to "Account",
            Icons.Default.Notifications to "Notification",
            Icons.Default.Lock to "Privacy",
            Icons.Default.Info to "Help",
            Icons.Default.ExitToApp to "Logout"
        )
        setContent {
            val context = LocalContext.current
            MontazeriSession2Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    TopAppBar()
                    Spacer(modifier = Modifier.height(12.dp))
                    items.forEach {
                        SettingItem(icon = it.first, title = it.second) {
                            Toast.makeText(context, it.second, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = "Settings",
            fontSize = 24.sp,
            fontWeight = FontWeight.Black
        )
    }, navigationIcon = {
        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "back")
    }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent))
}

@Composable
fun SettingItem(icon: ImageVector, title: String, onItemClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable { onItemClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = "")
        Spacer(modifier = Modifier.width(26.dp))
        Text(text = title)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.AutoMirrored.Default.KeyboardArrowRight, contentDescription = "")
    }
}