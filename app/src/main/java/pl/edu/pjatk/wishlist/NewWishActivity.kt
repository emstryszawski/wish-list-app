package pl.edu.pjatk.wishlist

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.edu.pjatk.wishlist.databinding.ActivityNewWishBinding
import java.io.File


class NewWishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewWishBinding
    private lateinit var path: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        path = intent.getStringExtra(PHOTO_EXTRA).toString()
        getBitmap(path).let {
            binding.thumb.setImageBitmap(it)
        }

        onSaveClick()
    }

    private fun onSaveClick() {
        binding.saveButton.setOnClickListener {
            wishesList.add(
                Wish(
                    thumb = getBitmap(path),
                    name = binding.wishItemName.text.toString(),
                    location = binding.wishItemLocation.text.toString()
                )
            )
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getBitmap(path: String): Bitmap {
        val image = File(path)
        val bitmap = BitmapFactory.decodeFile(image.absolutePath)
        return rotateImage(bitmap, 90f)
    }

    private fun rotateImage(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(
            source, 0, 0, source.width, source.height,
            matrix, true
        )
    }
}