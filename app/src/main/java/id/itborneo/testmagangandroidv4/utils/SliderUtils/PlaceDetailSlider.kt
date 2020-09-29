package id.itborneo.testmagangandroidv4.utils.SliderUtils

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import id.itborneo.testmagangandroidv4.R

class PlaceDetailSlider(
    private val context: Context,
    private val viewPager: ViewPager,
    private val sliderDots: LinearLayout,
    private val images: List<String>
) {

    fun initialize() {
        val viewPager = viewPager as ViewPager?

        val sliderDotspanel = sliderDots as LinearLayout?
        val viewPagerAdapter = ViewPagerAdapter(context, images)
        viewPager?.adapter = viewPagerAdapter
        val dotscount = viewPagerAdapter.count
        val dots = arrayOfNulls<ImageView?>(dotscount)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(context)
            dots[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.nonactive_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel?.addView(dots.get(i), params)
        }

        dots[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.active_dot
            )
        )

        viewPager?.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    for (i in 0 until dotscount) {
                        dots[i]?.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.nonactive_dot
                            )
                        )
                    }
                    dots[position]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.active_dot
                        )
                    )
                }

                override fun onPageScrollStateChanged(state: Int) {}
            })
    }


}