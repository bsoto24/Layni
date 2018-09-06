package pe.openlab.layni.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pe.openlab.layni.ui.main.MainActivity
import pe.openlab.layni.R
import pe.openlab.layni.ui.login.LoginActivity
import kotlin.concurrent.thread

class SplashActivity: AppCompatActivity(), Splash.View {

    val presenter: Splash.Presenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        thread {

            Thread.sleep(1000)
            presenter.verificarAutenticacion(this)

        }

    }

    override fun usuarioAutenticado() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    override fun usuarioNoAutenticado() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()

    }


}