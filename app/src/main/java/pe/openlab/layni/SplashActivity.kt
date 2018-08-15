package pe.openlab.layni

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.concurrent.thread

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        thread {

            Thread.sleep(1000)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }

    }

}