package id.itborneo.testmagangandroidv4.menu.list.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaceModel(

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
