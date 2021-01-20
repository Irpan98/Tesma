package id.itborneo.testmagangandroidv4.menu.gallery.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.testmagangandroidv4.databinding.ItemGalleryBinding
import id.itborneo.testmagangandroidv4.menu.gallery.viewmodels.ItemGalleryViewModel
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel

class GalleryViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(galleryModel: GalleryModel) {
        binding.gallery = ItemGalleryViewModel(galleryModel)

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GalleryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemGalleryBinding = ItemGalleryBinding.inflate(inflater, parent, false)
            return GalleryViewHolder(binding)
        }
    }

}