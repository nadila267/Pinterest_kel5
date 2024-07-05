package id.pinterest.app.create

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.pinterest.app.databinding.ItemImageBinding

data class ImageModel (
    @DrawableRes val imageRes: Int,
    val title: String? = null
)

class ImageAdapter : ListAdapter<ImageModel, ImageAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    inner class ViewHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.imageView.setImageResource(imageModel.imageRes)
            if (!imageModel.title.isNullOrEmpty()) {
                binding.textView.apply {
                    text = imageModel.title
                    isVisible = true
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImageModel>() {
            override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}