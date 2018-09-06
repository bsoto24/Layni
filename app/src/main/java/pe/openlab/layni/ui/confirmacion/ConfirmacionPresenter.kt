package pe.openlab.layni.ui.confirmacion

import pe.openlab.layni.entity.Reserva

class ConfirmacionPresenter(val view: Confirmacion.View?): Confirmacion.Presenter{

    val model: Confirmacion.Model? = ConfirmacionModel(this)

    override fun reservar(reserva: Reserva) {

        model?.reservar(reserva)

    }

    override fun mostrarError(mensaje: String) {

        view?.mostrarError(mensaje)


    }

    override fun mostrarConfirmacion(mensaje: String) {

        view?.mostrarConfirmacion(mensaje)


    }

}