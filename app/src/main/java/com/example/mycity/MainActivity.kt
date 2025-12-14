package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.findNavController
import com.example.mycity.ui.theme.CategoryScreen
import androidx.compose.foundation.background
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.theme.CityScreen
import com.example.mycity.ui.theme.DetailScreen
import com.example.mycity.ui.theme.ExpandedCityScreen
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.ui.theme.util.CityAppState
import com.example.mycity.ui.theme.util.CityContentType
import com.example.mycity.ui.theme.util.rememberCityAppState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    CityApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }
}

@Composable
fun CityApp(windowSize: WindowWidthSizeClass) {
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> CityContentType.LIST_AND_DETAIL
        else -> CityContentType.LIST_ONLY
    }

    val appState = rememberCityAppState(contentType)

    if (contentType == CityContentType.LIST_AND_DETAIL) {
        ExpandedCityScreen(appState = appState)
    } else {
        CompactCityApp(appState = appState)
    }
}

@Composable
fun CompactCityApp(appState: CityAppState) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "city"
    ) {
        composable("city") {
            CityScreen(
                navController = navController,
                onCategorySelected = { category ->
                    appState.selectCategory(category)
                }
            )
        }
        composable("category/{categoryName}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            CategoryScreen(
                navController = navController,
                categoryName = categoryName,
                onPlaceSelected = { place ->
                    appState.selectPlace(place)
                }
            )
        }
        composable("detail/{placeId}") { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")?.toIntOrNull() ?: 0
            DetailScreen(
                navController = navController,
                placeId = placeId
            )
        }
    }
}