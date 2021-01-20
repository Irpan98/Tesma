package id.itborneo.testmagangandroidv4.networks.repository

import id.itborneo.testmagangandroidv4.menu.list.models.response.PlaceResponseModel
import id.itborneo.testmagangandroidv4.networks.SafeApiRequest
import id.itborneo.testmagangandroidv4.networks.ServiceFactory
import id.itborneo.testmagangandroidv4.networks.rest.RestApiPlace
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PlaceRepository(
    private val scope: CoroutineScope

) : SafeApiRequest() {

    private val restApi = ServiceFactory.getApiService(RestApiPlace::class.java)


    fun getPlace(onSuccess: (PlaceResponseModel?) -> Unit, onError: (Throwable) -> Unit) {
        scope.launch {
            try {
                val result = apiRequest {
                    restApi.place()
                }
                onSuccess(result?.data)

            } catch (throwable: Throwable) {
                if (throwable !is CancellationException) {
                    onError(throwable)
                }
            }
        }
    }


}