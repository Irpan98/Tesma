package id.itborneo.testmagangandroidv4.menu.gallery.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import id.itborneo.testmagangandroidv4.menu.gallery.adapters.viewholders.GalleryViewHolder
import id.itborneo.testmagangandroidv4.menu.gallery.models.responses.GalleryModel
import id.itborneo.testmagangandroidv4.utils.AdapterCallback

class GalleryAdapter(
    private val listener: (GalleryModel) -> Unit
) :
    ListAdapter<GalleryModel, GalleryViewHolder>(AdapterCallback.DiffGalleryCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {

        return GalleryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val model = getItem(position)

        holder.bind(model)
        holder.itemView.setOnClickListener {
            listener(model)
        }
    }

//    override fun getItemCount(): Int = galleryData.size
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(model: GalleryModel) {
//
//
////            Picasso.get()
////                .load(model.thumbnail)
////                .resize(250, 250)
////                .centerCrop()
////                .into(itemView.ivGallery)
//
//
//        }
//
//    }

}