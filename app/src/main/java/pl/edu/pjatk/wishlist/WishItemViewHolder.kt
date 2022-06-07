package pl.edu.pjatk.wishlist

import androidx.recyclerview.widget.RecyclerView
import pl.edu.pjatk.wishlist.databinding.WishItemBinding

class WishItemViewHolder(
    private val wishItemBinding: WishItemBinding,
    private val clickListener: WishItemClickListener
) : RecyclerView.ViewHolder(wishItemBinding.root) {

    fun bindWish(wish: Wish) {
        wishItemBinding.wishItemThumb.setImageResource(wish.thumb)
        wishItemBinding.wishItemName.text = wish.name
        wishItemBinding.wishItemLocation.text = wish.location

        wishItemBinding.cardView.setOnClickListener {
            clickListener.onClick(wish)
        }
    }
}