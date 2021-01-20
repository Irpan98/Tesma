package id.itborneo.testmagangandroidv4.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel

class GalleryDetailViewModel(galleryModel: GalleryModel?) : ViewModel() {

    var imageUrl: ObservableField<String?> = ObservableField(galleryModel?.image)
    var caption: ObservableField<String?> = ObservableField(galleryModel?.caption)

}