package id.itborneo.testmagangandroidv4.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.menu.gallery.viewmodels.GalleryDetailViewModel
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.MultipleDetailViewModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.SingleDetailViewModel

class ViewModelFragmentFactory(private val params: Any) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            SingleDetailViewModel::class.java -> {
                SingleDetailViewModel(params as PlaceModel) as T
            }
            MultipleDetailViewModel::class.java -> {
                MultipleDetailViewModel(params as PlaceModel) as T
            }
            GalleryDetailViewModel::class.java -> {
                GalleryDetailViewModel(params as GalleryModel) as T
            }
            else -> super.create(modelClass)
        }
    }
}