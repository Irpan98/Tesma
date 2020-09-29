package id.itborneo.testmagangandroidv4.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.itborneo.testmagangandroidv4.data.remote.api.ApiClient
import id.itborneo.testmagangandroidv4.data.response.GalleryResponse
import id.itborneo.testmagangandroidv4.data.response.PlaceResponse
import id.itborneo.testmagangandroidv4.data.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor() {
    private val TAG = "RemoteDataSource"

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
                Log.d(TAG, "getPlaces ${response.body().toString()}")
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        result.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<PlaceResponse>, t: Throwable) {
                Log.d(TAG, "getPlaces: onFailure")

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
                Log.d(TAG, "getGallery ${response.body().toString()}")
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        result.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<GalleryResponse>, t: Throwable) {
                Log.d(TAG, "getUser: onFailure")

            }
        })

        return result
    }


    fun getUser(): LiveData<UserResponse> {
        val result = MutableLiveData<UserResponse>()
        apiClient.getUser().enqueue(object : Callback<UserResponse> {

            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                Log.d(TAG, "getUser ${response.body().toString()}")
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        result.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d(TAG, "getUser: onFailure")

            }
        })

        return result
    }

}