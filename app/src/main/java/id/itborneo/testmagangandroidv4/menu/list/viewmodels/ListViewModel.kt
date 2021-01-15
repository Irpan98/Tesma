package id.itborneo.testmagangandroidv4.menu.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.testmagangandroidv4.networks.RemoteDataSource
import id.itborneo.testmagangandroidv4.networks.repository.PlaceRepository
import id.itborneo.testmagangandroidv4.networks.response.PlaceResponse

class ListViewModel : ViewModel() {

    private val repo = PlaceRepository.getInstance(RemoteDataSource.getInstance())


    private lateinit var placeResponse: LiveData<PlaceResponse>
//    private lateinit var galleryResponse: LiveData<GalleryResponse>
//    private lateinit var user: LiveData<UserResponse>


    fun getPlaces(): LiveData<PlaceResponse> {
        if (::placeResponse.isInitialized) return placeResponse
        placeResponse = repo.getPlaces()
        return placeResponse
    }

//    fun getGallery(): LiveData<GalleryResponse> {
//        galleryResponse = repo.getGallery()
//        return galleryResponse
//    }
//
//    fun getUser(): LiveData<UserResponse> {
//        if (::user.isInitialized) return user
//        user = repo.getUser()
//        return user
//    }


}