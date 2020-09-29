package id.itborneo.testmagangandroidv4.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class PlaceResponse(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("data")
	val placeData: placeData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class placeData(

	@field:SerializedName("header")
	val header: Header? = null,

	@field:SerializedName("content")
	val placeContent: List<PlaceContentItem?>? = null
)

data class Header(

	@field:SerializedName("subtitle")
	val subtitle: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

@Parcelize
data class PlaceContentItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("media")
	val media: List<String>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("content")
	val content: String? = null
) : Parcelable
