package id.itborneo.testmagangandroidv4.ui.main.places

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.response.PlaceContentItem
import kotlinx.android.synthetic.main.item_place.view.*
import kotlinx.android.synthetic.main.item_place_multiple.view.*


class PlacesAdapter(private val listener: (PlaceContentItem) -> Unit) :
    RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {
    private val TAG = "PlacesAdapter"

    companion object {
        const val VIEW_SINGLE = 1
        const val VIEW_MULTIPLE = 2
    }

    private var placeItem = listOf<PlaceContentItem>()

    fun setAllPlaces(places: List<PlaceContentItem>) {
        placeItem = places
        Log.d(TAG, placeItem.toString())
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = when (viewType) {
            VIEW_SINGLE -> {
                LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)

            }
            else -> {
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_place_multiple,
                    parent,
                    false
                )

            }

        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (placeItem[position].type == "image") {
            holder.bind(placeItem[position])

        } else {
            holder.bindMultiple(placeItem[position])
        }

    }

    override fun getItemCount(): Int = placeItem.size


    override fun getItemViewType(position: Int): Int {
        return if (placeItem[position].type == "image") {
            1
        } else {
            2
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(placeContentItem: PlaceContentItem) {
            Log.d(TAG, "ViewHolder ${placeContentItem.title}")
            itemView.tvTitle.text = placeContentItem.title
            itemView.tvSubTitle.text = placeContentItem.content


            Picasso.get()
                .load(placeContentItem.image)
                .placeholder(R.drawable.loading_image)
                .fit()
                .into(itemView.ivPlace)

            onClickListener(placeContentItem)

        }

        fun bindMultiple(placeContentItem: PlaceContentItem) {
            itemView.tvSubTitleMultiple.text = placeContentItem.content
            itemView.tvTitleMultiple.text = placeContentItem.title
            itemView.setOnClickListener { listener(placeContentItem) }
            initImageAdapter(placeContentItem)
        }

        private fun initImageAdapter(placeContentItem: PlaceContentItem) {
            val images: MutableList<String> = placeContentItem.media?.toMutableList()
                ?: mutableListOf()
            val layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemView.lvImage.layoutManager = layoutManager
            val adapter = ImagesAdapter(images) { listener(placeContentItem) }
            itemView.lvImage.adapter = adapter
        }


        private fun onClickListener(placeContentItem: PlaceContentItem) {
            itemView.setOnClickListener {
                Log.d(TAG, "item clicked")
                listener(placeContentItem)
            }
        }

    }
}