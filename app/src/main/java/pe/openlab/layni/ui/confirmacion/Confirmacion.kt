package pe.openlab.layni.ui.confirmacion

import pe.openlab.layni.entity.Reserva

interface Confirmacion {

    interface Model {

        fun reservar(reserva: Reserva)

    }

    interface View {

        fun mostrarError(mensaje: String)
        fun mostrarConfirmacion(mensaje: String)

    }

    interface Presenter {

        fun reservar(reserva: Reserva)
        fun mostrarError(mensaje: String)
        fun mostrarConfirmacion(mensaje: String)


    }

}