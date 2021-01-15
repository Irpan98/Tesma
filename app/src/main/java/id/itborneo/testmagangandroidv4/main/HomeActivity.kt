package id.itborneo.testmagangandroidv4.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this

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