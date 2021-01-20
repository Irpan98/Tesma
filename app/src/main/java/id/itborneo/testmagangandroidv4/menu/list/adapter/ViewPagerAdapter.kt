package id.itborneo.testmagangandroidv4.menu.list.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.itborneo.testmagangandroidv4.menu.list.views.FragmentImage

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    private val listImage: List<String>?
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return FragmentImage.getInstance(listImage?.get(position))
    }

    override fun getCount(): Int {
        return listImage?.size ?: 0
    }
}