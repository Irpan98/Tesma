package id.itborneo.testmagangandroidv4.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel

class ItemSingleListViewModel(placeModel: PlaceModel) : ViewModel() {

    var title: ObservableField<String?> = ObservableField(placeModel.title)
    var content: ObservableField<String?> = ObservableField(placeModel.content)
    var imageUrl: ObservableField<String?> = ObservableField(placeModel.image)


}