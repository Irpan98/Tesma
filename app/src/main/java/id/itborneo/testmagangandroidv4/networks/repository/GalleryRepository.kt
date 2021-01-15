package id.itborneo.testmagangandroidv4.networks.repository

import id.itborneo.testmagangandroidv4.networks.RemoteDataSource

class GalleryRepository private constructor(
    private val remoteDataSource: RemoteDataSource
) {
    companion object {

        @Volatile
        private var instance: GalleryRepository? = null

        fun getInstance(remoteData: RemoteDataSource): GalleryRepository =
            instance ?: GalleryRepository(remoteData)
    }


//    fun getPlaces() = remoteDataSource.getPlaces()

    fun getGallery() = remoteDataSource.getGallery()

//    fun getUser() = remoteDataSource.getUser()


}