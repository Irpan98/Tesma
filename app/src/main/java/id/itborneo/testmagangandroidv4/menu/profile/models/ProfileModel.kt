package id.itborneo.testmagangandroidv4.menu.profile.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class ProfileModel(
    val id: Int?,
    val username: String?,
    val fullname: String?,
    val email: String?,
    val phone: String?,
    val avatar: String?
) : Parcelable