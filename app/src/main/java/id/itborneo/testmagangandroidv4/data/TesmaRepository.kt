package id.itborneo.testmagangandroidv4.data

import id.itborneo.testmagangandroidv4.data.remote.RemoteDataSource

class TesmaRepository private constructor(
    private val remoteDataSource: RemoteDataSource
) {
    companion object {

        @Volatile
        private var instance: TesmaRepository? = null

        fun getInstance(remoteData: RemoteDataSource): TesmaRepository =
            instance ?: TesmaRepository(remoteData)
    }


    fun getPlaces() = remoteDataSource.getPlaces()

    fun getGallery() = remoteDataSource.getGallery()

    fun getUser() = remoteDataSource.getUser()


}