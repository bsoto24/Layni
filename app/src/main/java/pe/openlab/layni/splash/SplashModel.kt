package pe.openlab.layni.splash

import android.content.Context
import pe.openlab.layni.repository.local.session.SessionManager

class SplashModel(val presenter: Splash.Presenter?): Splash.Model {

    override fun verificarAutenticacion(context: Context) {
        SessionManager.init(context)
        if (SessionManager.isLogged){
            presenter?.usuarioAutenticado()
        }else{
            presenter?.usuarioNoAutenticado()
        }
    }

}