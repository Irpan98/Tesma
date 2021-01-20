package id.itborneo.testmagangandroidv4.menu.gallery.models.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class GalleryModel(
    val image: String? = null,
    val thumbnail: String? = null,
    val caption: String? = null
) : Parcelable

