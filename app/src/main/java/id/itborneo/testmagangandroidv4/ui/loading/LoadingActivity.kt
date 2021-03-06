package id.itborneo.testmagangandroidv4.ui.loading

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.testmagangandroidv4.R
import id.itborneo.testmagangandroidv4.ui.main.MainActivity

@Suppress("DEPRECATION")
class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        initTimerToNavigation()
    }

    private fun initTimerToNavigation() {
        val handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }, 3000)
    }
}