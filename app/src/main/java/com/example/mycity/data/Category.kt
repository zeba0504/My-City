package com.example.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val imageRes: Int,
    val type: Categories
)
