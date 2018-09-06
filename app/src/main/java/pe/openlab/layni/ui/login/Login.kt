package pe.openlab.layni.ui.login

import pe.openlab.layni.entity.User

interface Login {

    interface Model {

        fun login(email:String)

    }

    interface View {

        fun usuarioExiste(user: User)
        fun usuarioNuevo()
        fun mostrarError(mensaje: String)
    }

    interface Presenter {

        fun login(email:String)
        fun usuarioExiste(user: User)
        fun usuarioNuevo()
        fun mostrarError(mensaje: String)
    }


}