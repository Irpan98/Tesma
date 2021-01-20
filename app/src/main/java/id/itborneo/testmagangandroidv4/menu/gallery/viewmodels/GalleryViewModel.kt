package id.itborneo.testmagangandroidv4.menu.gallery.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.networks.repository.GalleryRepository
import id.itborneo.testmagangandroidv4.utils.logDebug

class GalleryViewModel : ViewModel() {

    private val repo = GalleryRepository(viewModelScope)

    var isLoading: ObservableBoolean = ObservableBoolean()
    var listGallery: MutableLiveData<MutableList<GalleryModel>> = MutableLiveData()

    fun getGallery() {
        repo.getGallery({
            logDebug("gallery item count : ${it?.size}")
            isLoading.set(false)
            listGallery.postValue(it)
        }, {
            isLoading.set(false)

        })
    }


}