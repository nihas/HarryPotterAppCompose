package app.map.harrypotter.presentation.introscreen

import androidx.annotation.DrawableRes
import app.map.harrypotter.R

// Defines model of Onboarding page
data class Page(
    val title: String,
    val desc: String,
    @DrawableRes val image: Int
)

// Contents for Onboarding page
val pages = listOf(
    Page(
        title = "Shop Awesome Products",
        desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.ic_illustration_shopping
    ),
    Page(
        title = "One Day Delivery",
        desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.ic_illustration_delivery
    ),
    Page(
        title = "Amazing Customer Support",
        desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.ic_illustration_research
    ),
)