package id.itborneo.testmagangandroidv4.ui.main.places

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.itborneo.testmagangandroidv4.R
import kotlinx.android.synthetic.main.item_image.view.*


class ImagesAdapter(private val images: List<String>, private val listener: () -> Unit) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(images: String) {
            itemView.setOnClickListener {
                Log.d("ImagesAdapter", "image clicked")

                listener()
            }

            Picasso.get()
                .load(images)
                .placeholder(R.drawable.loading_image)
                .fit()
                .into(itemView.ivImage)
        }

    }
}
