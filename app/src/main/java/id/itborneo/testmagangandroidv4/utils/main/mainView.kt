package id.itborneo.testmagangandroidv4.utils.main

import android.app.Activity
import android.widget.Toolbar
import id.itborneo.testmagangandroidv4.R

object MainViewUtils {

    fun initAppbar(activity: Activity, title: String, showIcon: Boolean = true) {
        val tollbar = activity.findViewById<Toolbar>(R.id.tbApp)
        tollbar.title = title
        if (showIcon) tollbar.setNavigationIcon(R.drawable.ic_back) else {
            tollbar.navigationIcon = null

        }

    }


}