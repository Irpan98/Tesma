package id.itborneo.testmagangandroidv4.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import id.itborneo.testmagangandroidv4.menu.list.models.ListHeaderModel

class ItemHeaderViewModel(listHeaderModel: ListHeaderModel) : ViewModel() {
    var title: ObservableField<String?> = ObservableField(listHeaderModel.title)
    var subTitle: ObservableField<String?> = ObservableField(listHeaderModel.subtitle)
}