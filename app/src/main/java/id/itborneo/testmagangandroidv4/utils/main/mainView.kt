package id.itborneo.testmagangandroidv4.utils.main

import android.app.Activity
import com.google.android.material.appbar.MaterialToolbar
import id.itborneo.testmagangandroidv4.R

object MainViewUtils {

    fun initAppbar(activity: Activity, title: String, showIcon: Boolean = true) {
        val toolbar = activity.findViewById<MaterialToolbar>(R.id.tbApp)
        toolbar.title = title
        if (showIcon) toolbar.setNavigationIcon(R.drawable.ic_back) else {
            toolbar.navigationIcon = null

        }

    }


}