package pe.openlab.layni.splash

import android.content.Context

class SplashPresenter(val view: Splash.View) : Splash.Presenter {

    val model: Splash.Model = SplashModel(this)

    override fun verificarAutenticacion(context: Context) {
        model.verificarAutenticacion(context)
    }

    override fun usuarioAutenticado() {
        view.usuarioAutenticado()
    }

    override fun usuarioNoAutenticado() {
        view.usuarioNoAutenticado()
    }

}