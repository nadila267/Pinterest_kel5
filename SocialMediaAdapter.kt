package id.pinterest.app.inbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.pinterest.app.create.ImageModel
import id.pinterest.app.databinding.ItemImageBinding
import id.pinterest.app.databinding.ItemSocialBinding

class SocialMediaAdapter : ListAdapter<ImageModel, SocialMediaAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    inner class ViewHolder(private val binding: ItemSocialBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.imageView.setImageResource(imageModel.imageRes)
            binding.textView.text = imageModel.title
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
        return ViewHolder(ItemSocialBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}