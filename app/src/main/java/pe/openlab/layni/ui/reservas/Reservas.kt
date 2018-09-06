package pe.openlab.layni.ui.reservas

import pe.openlab.layni.entity.Reserva

interface Reservas{

    interface Presenter {

        fun obtenerReservas(userId: Int)
        fun mostrarReservas(reservas: MutableList<Reserva>)
        fun mostrarError(mensaje: String)

    }

    interface Model {

        fun obtenerReservas(userId: Int)

    }

    interface View {

        fun mostrarReservas(reservas: MutableList<Reserva>)
        fun mostrarError(mensaje: String)

    }

}
