package id.itborneo.testmagangandroidv4.networks

import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T? {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()
        } else {
            // TO DO
            // Handle error or error code 400, 401, 500, etc
            throw Throwable("Failed")
        }
    }

}