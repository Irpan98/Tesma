package id.itborneo.testmagangandroidv4.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.testmagangandroidv4.data.TesmaRepository
import id.itborneo.testmagangandroidv4.data.remote.RemoteDataSource
import id.itborneo.testmagangandroidv4.data.response.GalleryResponse
import id.itborneo.testmagangandroidv4.data.response.PlaceResponse
import id.itborneo.testmagangandroidv4.data.response.UserResponse

class MainViewModel : ViewModel() {

    val repo = TesmaRepository.getInstance(RemoteDataSource.getInstance())


    private lateinit var placeResponse: LiveData<PlaceResponse>
    private lateinit var galleryResponse: LiveData<GalleryResponse>
    private lateinit var user: LiveData<UserResponse>

    private var isInHomeFragment = true


    fun getPlaces(): LiveData<PlaceResponse> {
        if (::placeResponse.isInitialized) return placeResponse
        placeResponse = repo.getPlaces()
        return placeResponse
    }

    fun getGallery(): LiveData<GalleryResponse> {
//        if (::galleryResponse.isInitialized) return galleryResponse
        galleryResponse = repo.getGallery()
        return galleryResponse
    }

    fun getUser(): LiveData<UserResponse> {
        if (::user.isInitialized) return user
        user = repo.getUser()
        return user
    }



}