package id.itborneo.testmagangandroidv4.networks

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.itborneo.testmagangandroidv4.networks.api.ApiClient
import id.itborneo.testmagangandroidv4.networks.response.GalleryResponse
import id.itborneo.testmagangandroidv4.networks.response.PlaceResponse
import id.itborneo.testmagangandroidv4.networks.response.UserResponse
import id.itborneo.testmagangandroidv4.utils.logError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor() {

    private val apiClient = ApiClient.instance()


    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null


        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }

    }


    fun getPlaces(): LiveData<PlaceResponse> {


        val result = MutableLiveData<PlaceResponse>()
        apiClient.getPlaces().enqueue(object : Callback<PlaceResponse> {

            override fun onResponse(call: Call<PlaceResponse>, response: Response<PlaceResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        result.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<PlaceResponse>, t: Throwable) {
                logError("onFailure: $t")

            }
        })

        return result
    }

    fun getGallery(): LiveData<GalleryResponse> {
        val result = MutableLiveData<GalleryResponse>()
        apiClient.getGallery().enqueue(object : Callback<GalleryResponse> {

            override fun onResponse(
                call: Call<GalleryResponse>,
                response: Response<GalleryResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        result.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<GalleryResponse>, t: Throwable) {
                logError("onFailure: $t")

            }
        })

        return result
    }


    fun getUser(response: (UserResponse) -> Unit) {
        val result = MutableLiveData<UserResponse>()
        apiClient.getUser().enqueue(object : Callback<UserResponse> {

            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        result.postValue(response.body())
                        response(body)
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                logError("onFailure: $t")


            }
        })

    }

}