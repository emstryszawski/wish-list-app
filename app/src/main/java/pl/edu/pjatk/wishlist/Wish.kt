package pl.edu.pjatk.wishlist

import android.graphics.Bitmap

var wishesList = mutableListOf<Wish>()

const val WISH_ID_EXTRA = "wishExtra"
const val PHOTO_EXTRA = "photoExtra"

data class Wish(
    var thumb: Bitmap,
    var name: String,
    var location: String,
    val id: Int? = wishesList.size
//    var uri: Uri
)
