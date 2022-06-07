package pl.edu.pjatk.wishlist

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import pl.edu.pjatk.wishlist.*
import pl.edu.pjatk.wishlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), WishItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mockWishList()
        onNewWishBtnClick()

        val mainActivity = this
        binding.wishList.apply {
            layoutManager = GridLayoutManager(applicationContext, 1)
            adapter = WishItemAdapter(wishesList, mainActivity)
        }
    }

    override fun onClick(wish: Wish) {
        val intent = Intent(applicationContext, DetailsActivity::class.java)
        intent.putExtra(WISH_ID_EXTRA, wish.id)
        startActivity(intent)
    }

    private fun onNewWishBtnClick() {
        binding.addWishItem.setOnClickListener {
            val intent = Intent(applicationContext, DataActivity::class.java)
            startActivity(intent)
        }
    }

    private fun mockWishList() {
//        wishesList.add(
//            Wish(
//                BitmapFactory.decodeFile(R.drawable.airmax),
//                "Nike Air Max",
//                "Złote Tarasy"
//            )
//        )
//
//        wishesList.add(
//            Wish(
//                R.drawable.basketball,
//                "Piłka do kosza - Spalding",
//                "Intersport na Reducie"
//            )
//        )
//
//        wishesList.add(
//            Wish(
//                R.drawable.bike,
//                "Rower górski",
//                "TREK, Jerozolimskie 200 "
//            )
//        )
//
//        wishesList.add(
//            Wish(
//                R.drawable.cap,
//                "Czapeczka",
//                "Sizeer w Złotych"
//            )
//        )
//
//        wishesList.add(
//            Wish(
//                R.drawable.etui,
//                "Etui na iphone 11",
//                "iDream, Blue City"
//            )
//        )
//
//        wishesList.add(
//            Wish(
//                R.drawable.sunglasses,
//                "Okulary przeciwsłoneczne",
//                "Vision express Złote Tarasy"
//            )
//        )
    }
}