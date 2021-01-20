package id.itborneo.testmagangandroidv4.utils.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions
import de.hdodenhof.circleimageview.CircleImageView
import id.itborneo.testmagangandroidv4.utils.glide.GlideApp

@BindingAdapter("setAvatar")
fun CircleImageView.setAvatar(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
//        .placeholder(R.drawable.placeholder_user)
//        .error(R.drawable.placeholder_user)
        .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
        .into(this)
}

@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
//        .placeholder(R.drawable.placeholder_image)
//        .error(R.drawable.placeholder_image)
        .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
        .into(this)
}