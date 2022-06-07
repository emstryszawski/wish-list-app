package pl.edu.pjatk.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.edu.pjatk.wishlist.databinding.WishItemBinding

class WishItemAdapter(
    private val wishes: List<Wish>,
    private val clickListener: WishItemClickListener
) : RecyclerView.Adapter<WishItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = WishItemBinding.inflate(from, parent, false)
        return WishItemViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: WishItemViewHolder, position: Int) =
        holder.bindWish(wishes[position])

    override fun getItemCount(): Int = wishes.size
}