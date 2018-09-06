package pe.openlab.layni.ui.registro

import android.content.Context
import pe.openlab.layni.entity.User

class RegistroPresenter(val view: Registro.View?, val context: Context): Registro.Presenter {

    private val model: Registro.Model? = RegistroModel(this, context)

    override fun registrar(user: User) {

        model?.registrar(user)

    }

    override fun mostrarError(mensaje: String) {

        view?.mostrarError(mensaje)

    }

    override fun mostrarConfirmacion(mensaje: String) {

        view?.mostrarConfirmacion(mensaje)

    }
}