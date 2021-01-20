package id.itborneo.testmagangandroidv4.menu.list.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.testmagangandroidv4.menu.list.models.response.PlaceResponseModel
import id.itborneo.testmagangandroidv4.networks.repository.PlaceRepository

class ListViewModel : ViewModel() {

    private val placeRepository = PlaceRepository(viewModelScope)

    var isLoading: ObservableBoolean = ObservableBoolean()
    var listPlace: MutableLiveData<PlaceResponseModel> = MutableLiveData()


    fun getListPlace() {
        isLoading.set(true)
        placeRepository.getPlace({
            isLoading.set(false)
            listPlace.postValue(it)
        }, {
            isLoading.set(false)
        })
    }


}