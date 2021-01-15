package id.itborneo.testmagangandroidv4.networks.repository

import id.itborneo.testmagangandroidv4.networks.RemoteDataSource

class PlaceRepository private constructor(
    private val remoteDataSource: RemoteDataSource
) {
    companion object {

        @Volatile
        private var instance: PlaceRepository? = null

        fun getInstance(remoteData: RemoteDataSource): PlaceRepository =
            instance ?: PlaceRepository(remoteData)
    }


    fun getPlaces() = remoteDataSource.getPlaces()

//    fun getGallery() = remoteDataSource.getGallery()

//    fun getUser() = remoteDataSource.getUser()


}