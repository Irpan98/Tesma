package id.itborneo.testmagangandroidv4.ui.gallery

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.data.response.GalleryDataItem
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapter(
    private val listener: ( GalleryDataItem) -> Unit) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    private val TAG = "GalleryAdapter"
    private var galleryData = listOf<GalleryDataItem>()


    fun setAllPlaces(data: List<GalleryDataItem>) {
        galleryData = data
        Log.d(TAG, galleryData.toString())
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dataItem: GalleryDataItem) {
            Log.d(TAG, " ViewHolder " + dataItem.thumbnail)
//
//            Glide.with(itemView.context)
//                .load(dataItem.thumbnail)
//                .into(itemView.ivGallery)

            itemView.setOnClickListener {
                listener(dataItem)
            }
            Picasso.get()
                .load(dataItem.thumbnail)
                .resize(250, 250)
                .placeholder(R.drawable.loading_image)

                .centerCrop()
                .into(itemView.ivGallery)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(galleryData[position])
    }

    override fun getItemCount(): Int = galleryData.size


}