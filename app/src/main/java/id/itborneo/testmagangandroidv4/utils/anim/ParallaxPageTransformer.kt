package id.itborneo.testmagangandroidv4.utils.anim

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.ViewPager
import id.itborneo.testmagangandroidv4.R

class ParallaxPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val viewImage: AppCompatImageView = page.findViewById(R.id.imageViewItemListDetail)
        val pageWidth = page.width
        if (position < -1) {
            page.alpha = 1F
        } else if (position <= 1) {
            viewImage.translationX = -position * (pageWidth / 2)
        } else {
            page.alpha = 1F
        }
    }

}