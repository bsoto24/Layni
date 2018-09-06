package pe.openlab.layni.ui.login

import android.content.Context
import pe.openlab.layni.entity.User

class LoginPresenter(val view: Login.View?, val context: Context) : Login.Presenter {


    val model: Login.Model? = LoginModel(this, context)

    override fun login(email: String) {
        model?.login(email)
    }

    override fun mostrarError(mensaje: String) {
        view?.mostrarError(mensaje)
    }

    override fun usuarioExiste(user: User) {
        view?.usuarioExiste(user)
    }

    override fun usuarioNuevo() {
        view?.usuarioNuevo()
    }
}