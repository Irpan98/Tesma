package id.itborneo.testmagangandroidv4.menu.list.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.testmagangandroidv4.databinding.ItemHeaderBinding
import id.itborneo.testmagangandroidv4.menu.list.models.ListHeaderModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.ItemHeaderViewModel
import id.itborneo.testmagangandroidv4.utils.logDebug

class HeaderViewHolder(val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(listHeaderModel: ListHeaderModel) {
        logDebug("HeaderViewHolder bind called : $listHeaderModel")
        binding.header = ItemHeaderViewModel(listHeaderModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemHeaderBinding = ItemHeaderBinding.inflate(inflater, parent, false)
            return HeaderViewHolder(binding)
        }
    }

}