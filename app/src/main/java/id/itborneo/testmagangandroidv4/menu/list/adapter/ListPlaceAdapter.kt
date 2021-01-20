package id.itborneo.testmagangandroidv4.menu.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.testmagangandroidv4.menu.list.adapter.viewholders.HeaderViewHolder
import id.itborneo.testmagangandroidv4.menu.list.adapter.viewholders.MultipleViewHolder
import id.itborneo.testmagangandroidv4.menu.list.adapter.viewholders.SingleViewHolder
import id.itborneo.testmagangandroidv4.menu.list.models.ListHeaderModel
import id.itborneo.testmagangandroidv4.menu.list.models.PlaceModel
import id.itborneo.testmagangandroidv4.utils.AdapterCallback


class ListPlaceAdapter(private val listener: (PlaceModel) -> Unit) :
    ListAdapter<Any, RecyclerView.ViewHolder>(AdapterCallback.DiffListPlaceCallback) {

    companion object {
        const val ITEM_HEADER = 0
        const val VIEW_SINGLE = 1
        const val VIEW_MULTIPLE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {

            ITEM_HEADER -> {
                HeaderViewHolder.from(parent)
            }

            VIEW_SINGLE -> {
                SingleViewHolder.from(parent, listener)
            }
            else -> {
                MultipleViewHolder.from(parent, listener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {

            is HeaderViewHolder -> {
                holder.bind(getItem(position) as ListHeaderModel)
            }

            is SingleViewHolder -> {
                holder.bind(getItem(position) as PlaceModel)
            }
            is MultipleViewHolder -> {
                holder.bind(getItem(position) as PlaceModel)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ListHeaderModel) {
            ITEM_HEADER
        } else {
            val placeModel = getItem(position) as PlaceModel
            return if (placeModel.type == "image") {
                VIEW_SINGLE
            } else {
                VIEW_MULTIPLE
            }
        }


    }


}