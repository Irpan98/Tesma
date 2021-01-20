package id.itborneo.testmagangandroidv4.networks.basemodels

import androidx.annotation.Keep

@Keep
class ApiServiceModelList<T> (
    val status_code: Int?,
    val message: String?,
    val data: MutableList<T>
)