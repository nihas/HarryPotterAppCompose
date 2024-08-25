package app.map.harrypotter.presentation.introscreen

import androidx.annotation.DrawableRes
import app.map.harrypotter.R

// Defines model of Onboarding page
data class Page(
    val title: String,
    val desc: String,
    val image: String
)

// Contents for Onboarding page
val pages = listOf(
    Page(
        title = "Hogwarts Characters & Spells",
        desc = "Discover detailed profiles of your favorite Hogwarts characters and learn about the spells they use.",
        image = "https://cdn.shopify.com/s/files/1/0558/6413/1764/files/Harry_Potter_Illustration_30_1024x1024.jpg?v=1701584801"
    ),
    Page(
        title = "Spell & House Guide",
        desc = "Get to know all the spells from the Harry Potter series and learn about each Hogwarts house.",
        image = "https://kindledspirits.blog/wp-content/uploads/2020/11/1609910dfd9d4fed121026787cde1183-1.jpg"
    ),
    Page(
        title = "Potterverse Profiles",
        desc = "Browse through detailed profiles of characters and spells from the Harry Potter universe.",
        image = "https://i.pinimg.com/736x/80/1e/1f/801e1fa0d105379c768ed89bb7fd2a07.jpg"
    ),
)

data class HomeCard(
    val title: String,
    val image: String
)
val homePages = listOf(
    HomeCard(
        title = "All Characters",
        image = "https://cdn.shopify.com/s/files/1/0558/6413/1764/files/Harry_Potter_Illustration_30_1024x1024.jpg?v=1701584801"
    ),
    HomeCard(
        title = "Hogwards Students",
        image = "https://i.pinimg.com/736x/80/1e/1f/801e1fa0d105379c768ed89bb7fd2a07.jpg"
    ),
    HomeCard(
        title = "Hogwarts Staff",
        image = "https://i.pinimg.com/originals/81/ac/37/81ac3773d259c4e0d9f38f34e1e778ec.jpg"
    ),
    HomeCard(
        title = "Hogwarts Houses",
        image = "https://m.media-amazon.com/images/I/71OikeUsN5L._AC_UF894,1000_QL80_.jpg"
    ),
    HomeCard(
        title = "Spells",
        image = "https://kindledspirits.blog/wp-content/uploads/2020/11/1609910dfd9d4fed121026787cde1183-1.jpg"
    ),
)