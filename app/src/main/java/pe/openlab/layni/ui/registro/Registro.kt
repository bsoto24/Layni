package pe.openlab.layni.ui.registro

import pe.openlab.layni.entity.User

interface Registro {

    interface Model {

        fun registrar(user: User)

    }

    interface View {

        fun mostrarError(mensaje: String)
        fun mostrarConfirmacion(mensaje: String)

    }

    interface Presenter {

        fun registrar(user: User)
        fun mostrarError(mensaje: String)
        fun mostrarConfirmacion(mensaje: String)

    }

}