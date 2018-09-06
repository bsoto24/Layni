package pe.openlab.layni.ui.perfil

import pe.openlab.layni.entity.User

interface Perfil {

    interface Model{

        fun obtenerPerfil()

    }

    interface View{

        fun mostrarPerfil(user: User)
        fun mostrarError(mensaje: String)

    }

    interface Presenter{

        fun obtenerPerfil()
        fun mostrarPerfil(user: User)
        fun mostrarError(mensaje: String)

    }

}