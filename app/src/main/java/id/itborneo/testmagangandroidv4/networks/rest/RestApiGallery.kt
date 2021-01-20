package id.itborneo.testmagangandroidv4.networks.rest

import id.itborneo.testmagangandroidv4.networks.basemodels.ApiServiceModelList
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiGallery {


    @GET("gallery.json")
    suspend fun gallery(): Response<ApiServiceModelList<GalleryModel>>
}