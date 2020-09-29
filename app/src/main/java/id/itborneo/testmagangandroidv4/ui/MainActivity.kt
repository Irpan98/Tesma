package id.itborneo.testmagangandroidv4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import id.itborneo.testmagangandroidv4.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNav()
        initTollbarListener()

    }

    private fun initTollbarListener() {
        tbApp.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun initBottomNav() {
        val navController = Navigation.findNavController(this, R.id.mainNavHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

    }


}