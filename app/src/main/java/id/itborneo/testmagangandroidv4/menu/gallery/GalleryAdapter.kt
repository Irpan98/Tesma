package id.itborneo.testmagangandroidv4.menu.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.networks.response.GalleryDataItem
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapter(
    private val listener: ( GalleryDataItem) -> Unit) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    private var galleryData = listOf<GalleryDataItem>()


    fun setAllPlaces(data: List<GalleryDataItem>) {
        galleryData = data
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(galleryData[position])
    }

    override fun getItemCount(): Int = galleryData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dataItem: GalleryDataItem) {

            itemView.setOnClickListener {
                listener(dataItem)
            }
            Picasso.get()
                .load(dataItem.thumbnail)
                .resize(250, 250)
                .centerCrop()
                .into(itemView.ivGallery)



        }

    }

}