package pe.openlab.layni.ui.reservas

import pe.openlab.layni.entity.Reserva
import com.google.firebase.firestore.FirebaseFirestore

class ReservasModel(var presenter: Reservas.Presenter): Reservas.Model{

    override fun obtenerReservas(userId: Int) {

        val db = FirebaseFirestore.getInstance()
        val reservas = mutableListOf<Reserva>()

        db.collection("Reserva")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {

                            reservas.add(Reserva(
                                    document.id,
                                    document.data["nivel"].toString(),
                                    document.data["lugar"].toString(),
                                    document.data["tutor"].toString(),
                                    document.data["horario"].toString(),
                                    document.data["cursos"].toString(),
                                    document.data["timestamp"].toString(),
                                    document.data["estado"].toString()
                            ))

                        }
                        presenter.mostrarReservas(reservas)
                    } else {
                        presenter.mostrarError(task.exception.toString())
                    }
                }
    }

}