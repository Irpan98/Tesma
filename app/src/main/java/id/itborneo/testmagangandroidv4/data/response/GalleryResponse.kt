package id.itborneo.testmagangandroidv4.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class GalleryResponse(
	val statusCode: Int? = null,
	val data: List<GalleryDataItem?>? = null,
	val message: String? = null
)

@Parcelize
data class GalleryDataItem(
	val image: String? = null,
	val thumbnail: String? = null,
	val caption: String? = null
) : Parcelable

