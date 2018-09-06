package pe.openlab.layni.ui.reservas

import pe.openlab.layni.entity.Reserva

class ReservasPresenter(val view: Reservas.View?): Reservas.Presenter {

    val model: Reservas.Model? = ReservasModel(this)

    override fun obtenerReservas(userId: Int) {
        model?.obtenerReservas(userId)
    }

    override fun mostrarReservas(reservas: MutableList<Reserva>) {
        view?.mostrarReservas(reservas)
    }

    override fun mostrarError(mensaje: String) {
        view?.mostrarError(mensaje)
    }

}