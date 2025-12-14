package com.example.mycity.data

import com.example.mycity.R

enum class Categories (name: String) {
    SIGHT(name = "Достопримечательности"), PARK(name = "Парки"), CAFE(name = "Кафе")
}
val categories = listOf(
    Category(1, R.string.sight, R.drawable.sight, Categories.SIGHT),
    Category(2, R.string.cafe, R.drawable.cafe, Categories.CAFE),
    Category(3, R.string.park, R.drawable.park, Categories.PARK)
)

val places = listOf(
    Place(1, R.string.sight1, 10, R.drawable.sight1, Categories.SIGHT, R.string.sight1descr),
    Place(2, R.string.sight2, 12, R.drawable.sight2, Categories.SIGHT, R.string.sight2descr),
    Place(3, R.string.sight3, 11, R.drawable.sight3, Categories.SIGHT, R.string.sight3descr),
    Place(4, R.string.cafe1, 234, R.drawable.cafe1, Categories.CAFE, R.string.cafe1descr),
    Place(5, R.string.cafe2, 123, R.drawable.cafe2, Categories.CAFE, R.string.cafe2descr),
    Place(6, R.string.park1, 45, R.drawable.park1, Categories.PARK, R.string.park1descr),
    Place(7, R.string.park2, 32, R.drawable.park2, Categories.PARK, R.string.park2descr)
)