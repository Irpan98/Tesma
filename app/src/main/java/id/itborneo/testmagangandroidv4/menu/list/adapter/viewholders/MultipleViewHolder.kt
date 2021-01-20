package id.itborneo.testmagangandroidv4.menu.list.adapter.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.testmagangandroidv4.databinding.ItemListMultipleBinding
import id.itborneo.testmagangandroidv4.menu.list.adapter.ImagesAdapter
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.menu.list.views.FragmentListDirections
import id.itborneo.testmagangandroidv4.utils.logDebug


class MultipleViewHolder(
    val binding: ItemListMultipleBinding,
    val listener: (PlaceModel) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(placeModel: PlaceModel) {

        binding.tvSubTitleMultiple.text = placeModel.content
        binding.tvTitleMultiple.text = placeModel.title
        initImageAdapter(placeModel)

        binding.root.setOnClickListener {
        }

        binding.executePendingBindings()


    }


    private fun openDetail(view: View, placeModel: PlaceModel) {
        val action = FragmentListDirections.actionPlacesFragmentToFragmentMultipleDetail()
        action.dataPlace = placeModel

        logDebug("item clicked")
        view.findNavController().navigate(action)
    }


    companion object {
        fun from(parent: ViewGroup, listener: (PlaceModel) -> Unit): MultipleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding =
                ItemListMultipleBinding.inflate(inflater, parent, false)
            return MultipleViewHolder(binding, listener)
        }
    }


    private fun initImageAdapter(placeModel: PlaceModel) {
        val images: MutableList<String> = placeModel.media?.toMutableList()
            ?: mutableListOf()
        val layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        binding.lvImage.layoutManager = layoutManager
        val adapter = ImagesAdapter(images) {
            openDetail(binding.root, placeModel)
        }

        binding.lvImage.adapter = adapter
    }

}