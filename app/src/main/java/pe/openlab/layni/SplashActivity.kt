package pe.openlab.layni

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pe.openlab.layni.database.DatabaseHandler
import pe.openlab.layni.session.SessionManager
import kotlin.concurrent.thread

class SplashActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DatabaseHandler(this)

        thread {

            Thread.sleep(1000)

            var intent: Intent

            SessionManager.init(this)

            if (SessionManager.isLogged){
                intent = Intent(this, MainActivity::class.java)
            }else{
                intent = Intent(this, LoginActivity::class.java)
            }

            startActivity(intent)
            finish()

        }

    }

}