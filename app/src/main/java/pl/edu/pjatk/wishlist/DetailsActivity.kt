package pl.edu.pjatk.wishlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.edu.pjatk.wishlist.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wishID = intent.getIntExtra(WISH_ID_EXTRA, -1)
        val wish = wishFromId(wishID)
        if (wish != null) {
            binding.wishItemThumb.setImageResource(wish.thumb)
            binding.wishItemName.text = wish.name
            binding.wishItemLocation.text = wish.location
        }
    }

    private fun wishFromId(wishID: Int): Wish? {
        for (wish in wishesList) {
            if (wish.id == wishID) {
                return wish
            }
        }
        return null
    }
}