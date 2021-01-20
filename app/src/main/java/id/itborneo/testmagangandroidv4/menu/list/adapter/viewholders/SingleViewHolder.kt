package id.itborneo.testmagangandroidv4.menu.list.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.testmagangandroidv4.databinding.ItemListSingleBinding
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.menu.list.viewmodels.ItemSingleListViewModel
import id.itborneo.testmagangandroidv4.menu.list.views.FragmentListDirections
import id.itborneo.testmagangandroidv4.utils.logDebug


class SingleViewHolder(
    val binding: ItemListSingleBinding,
    val listener: (PlaceModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(placeModel: PlaceModel) {

        binding.place = ItemSingleListViewModel(placeModel)

        binding.root.setOnClickListener {
            val action = FragmentListDirections.actionPlacesFragmentToDetailPlaceFragment()
            action.dataPlace = placeModel

            logDebug("item clicked")
            it?.findNavController()?.navigate(action)

        }
        binding.executePendingBindings()


    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClickListener: (PlaceModel) -> Unit
        ): SingleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemListSingleBinding =
                ItemListSingleBinding.inflate(inflater, parent, false)
            return SingleViewHolder(binding, onClickListener)
        }
    }

}