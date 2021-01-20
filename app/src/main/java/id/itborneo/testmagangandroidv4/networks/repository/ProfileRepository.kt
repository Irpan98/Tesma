package id.itborneo.testmagangandroidv4.networks.repository

import id.itborneo.testmagangandroidv4.menu.profile.models.ProfileModel
import id.itborneo.testmagangandroidv4.networks.SafeApiRequest
import id.itborneo.testmagangandroidv4.networks.ServiceFactory
import id.itborneo.testmagangandroidv4.networks.rest.RestApiProfile
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ProfileRepository(private val scope: CoroutineScope) : SafeApiRequest() {

    private val restApi = ServiceFactory.getApiService(RestApiProfile::class.java)

    fun getProfile(onSuccess: (ProfileModel?) -> Unit, onError: (Throwable) -> Unit) {
        scope.launch {
            try {
                val result = apiRequest { restApi.profile() }
                onSuccess(result?.data)
            } catch (throwable: Throwable) {
                if (throwable !is CancellationException) {
                    onError(throwable)
                }
            }
        }
    }


}