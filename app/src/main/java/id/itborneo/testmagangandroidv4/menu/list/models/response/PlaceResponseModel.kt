package id.itborneo.testmagangandroidv4.menu.list.models.response

import id.itborneo.testmagangandroidv4.menu.list.models.ListHeaderModel
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel


data class PlaceResponseModel(

    val header: ListHeaderModel?,
    val content: List<PlaceModel?>?
)



