package id.itborneo.testmagangandroidv4.networks.repository

import id.itborneo.testmagangandroidv4.networks.RemoteDataSource
import id.itborneo.testmagangandroidv4.networks.response.UserResponse

class ProfileRepository private constructor(
    private val remoteDataSource: RemoteDataSource
) {
    companion object {

        @Volatile
        private var instance: ProfileRepository? = null

        fun getInstance(remoteData: RemoteDataSource): ProfileRepository =
            instance ?: ProfileRepository(remoteData)
    }


//    fun getPlaces() = remoteDataSource.getPlaces()

//    fun getGallery() = remoteDataSource.getGallery()

    fun getUser(response: (UserResponse) -> Unit) = remoteDataSource.getUser(response)


}