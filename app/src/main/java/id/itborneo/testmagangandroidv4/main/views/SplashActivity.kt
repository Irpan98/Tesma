package id.itborneo.testmagangandroidv4.main.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        initTimerToNavigation()
    }

    private fun initTimerToNavigation() {

        lifecycleScope.launch {
            delay(3000)
            actionToHome()
        }
    }

    private fun actionToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}