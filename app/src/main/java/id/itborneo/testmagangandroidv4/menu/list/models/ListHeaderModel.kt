package id.itborneo.testmagangandroidv4.menu.list.models

import com.google.gson.annotations.SerializedName

data class ListHeaderModel(

    @field:SerializedName("subtitle")
    val subtitle: String? = null,

    @field:SerializedName("title")
    val title: String? = null
)