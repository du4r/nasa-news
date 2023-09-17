package com.example.nasacollection.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.nasacollection.ui.Home.HomeScreen
import com.example.nasacollection.ui.theme.LightColorScheme
import com.example.nasacollection.ui.theme.NasaCollectionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaCollectionTheme {
                MaterialTheme(colorScheme = LightColorScheme) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}

