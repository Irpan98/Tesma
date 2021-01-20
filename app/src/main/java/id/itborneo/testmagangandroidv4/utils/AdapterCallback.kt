package id.itborneo.testmagangandroidv4.utils

import androidx.recyclerview.widget.DiffUtil
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel

object AdapterCallback {

    val DiffListPlaceCallback = object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return if (oldItem is PlaceModel && newItem is PlaceModel) {
                oldItem.title == newItem.title
            } else {
                true
            }
        }
    }

    val DiffGalleryCallback = object : DiffUtil.ItemCallback<GalleryModel>() {

        override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(
            oldItem: GalleryModel,
            newItem: GalleryModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}