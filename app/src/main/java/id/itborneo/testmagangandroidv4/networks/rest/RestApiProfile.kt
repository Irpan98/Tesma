package id.itborneo.testmagangandroidv4.networks.rest

import id.itborneo.testmagangandroidv4.menu.profile.models.ProfileModel
import id.itborneo.testmagangandroidv4.networks.basemodels.ApiServiceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiProfile {

    @GET("user.json")
    suspend fun profile(): Response<ApiServiceModel<ProfileModel>>

}