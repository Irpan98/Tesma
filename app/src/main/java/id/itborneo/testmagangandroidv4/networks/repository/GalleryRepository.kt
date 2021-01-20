package id.itborneo.testmagangandroidv4.networks.repository

import id.itborneo.testmagangandroidv4.networks.SafeApiRequest
import id.itborneo.testmagangandroidv4.networks.ServiceFactory
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.networks.rest.RestApiGallery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

class GalleryRepository(
    private val scope: CoroutineScope
) : SafeApiRequest() {
    private val restApi = ServiceFactory.getApiService(RestApiGallery::class.java)


    fun getGallery(onSuccess: (MutableList<GalleryModel>?) -> Unit, onError: (Throwable) -> Unit) {
        scope.launch {
            try {

                val result = apiRequest { restApi.gallery() }
                onSuccess(result?.data)

            } catch (throwable: Throwable) {
                if (throwable !is CancellationException) {
                    onError(throwable)
                }
            }
        }
    }
}