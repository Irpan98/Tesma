package id.itborneo.testmagangandroidv4.networks.rest

import id.itborneo.testmagangandroidv4.menu.list.models.response.PlaceResponseModel
import id.itborneo.testmagangandroidv4.networks.basemodels.ApiServiceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiPlace {

    @GET("place.json")
    suspend fun place(): Response<ApiServiceModel<PlaceResponseModel>>
}

