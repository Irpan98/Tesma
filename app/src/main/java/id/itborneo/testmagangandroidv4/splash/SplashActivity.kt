package id.itborneo.testmagangandroidv4.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.main.HomeActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initTimerToNavigation()
    }

    private fun initTimerToNavigation() {
        val handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }, 3000)
    }
}