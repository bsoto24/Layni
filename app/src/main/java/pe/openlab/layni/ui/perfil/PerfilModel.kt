package pe.openlab.layni.ui.perfil

import android.content.Context
import pe.openlab.layni.repository.local.database.DatabaseHandler
import pe.openlab.layni.repository.local.session.SessionManager

class PerfilModel(val presenter: Perfil.Presenter?, val context: Context): Perfil.Model {

    override fun obtenerPerfil() {

        val db = DatabaseHandler(context)

        if (SessionManager.isLogged){
            val user = db.getUser()
            if (!user.id.isEmpty()){
                presenter?.mostrarPerfil(db.getUser())
            } else{
                presenter?.mostrarError("Algo salio mal, vuelva a iniciar sesion")
            }
        }else{
            presenter?.mostrarError("El usuario aun no se ha registrado")
        }


    }

}