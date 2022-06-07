package pl.edu.pjatk.wishlist

var wishesList = mutableListOf<Wish>()

const val WISH_ID_EXTRA = "wishExtra"

data class Wish(
    var thumb: Int,
    var name: String,
    var location: String,
    val id: Int? = wishesList.size
//    var uri: Uri
)
