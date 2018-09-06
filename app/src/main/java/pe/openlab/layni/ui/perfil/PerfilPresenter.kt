package pe.openlab.layni.ui.perfil

import android.content.Context
import pe.openlab.layni.entity.User

class PerfilPresenter(val view: Perfil.View?, val context: Context): Perfil.Presenter {

    val model: Perfil.Model? = PerfilModel(this, context)


    override fun obtenerPerfil() {

        model?.obtenerPerfil()

    }

    override fun mostrarPerfil(user: User) {

        view?.mostrarPerfil(user)

    }

    override fun mostrarError(mensaje: String) {

        view?.mostrarError(mensaje)

    }

}