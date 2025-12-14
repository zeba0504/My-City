package com.example.mycity.ui.theme.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.mycity.data.Categories
import com.example.mycity.data.Category
import com.example.mycity.data.Place

class CityAppState(
    val contentType: CityContentType
) {
    var selectedCategory by mutableStateOf<Category?>(null)
    var selectedPlace by mutableStateOf<Place?>(null)

    fun selectCategory(category: Category) {
        selectedCategory = category
        selectedPlace = null
    }

    fun selectPlace(place: Place) {
        selectedPlace = place
    }
}

@Composable
fun rememberCityAppState(
    contentType: CityContentType
): CityAppState {
    return remember(contentType) {
        CityAppState(contentType)
    }
}