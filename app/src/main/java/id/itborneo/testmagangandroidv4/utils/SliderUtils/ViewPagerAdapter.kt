package id.itborneo.testmagangandroidv4.utils.SliderUtils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import id.itborneo.testmagangandroidv4.R


class ViewPagerAdapter(private val context: Context, private val images: List<String>) :
    PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater!!.inflate(R.layout.custom_layout, null)
        val imageView = view.findViewById<View>(R.id.imageView) as ImageView

        Glide.with(context)
            .load(images[position])
            .into(imageView)


        val vp: ViewPager = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp: ViewPager = container as ViewPager
        val view = `object` as View?
        vp.removeView(view)
    }


}
