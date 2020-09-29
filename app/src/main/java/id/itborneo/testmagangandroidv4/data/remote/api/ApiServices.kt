package id.itborneo.testmagangandroidv4.data.remote.api


import id.itborneo.testmagangandroidv4.data.response.GalleryResponse
import id.itborneo.testmagangandroidv4.data.response.PlaceResponse
import id.itborneo.testmagangandroidv4.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("place.json")
    fun getPlaces(): Call<PlaceResponse>

    @GET("gallery.json")
    fun getGallery(): Call<GalleryResponse>

    @GET("user.json")
    fun getUser(): Call<UserResponse>





}