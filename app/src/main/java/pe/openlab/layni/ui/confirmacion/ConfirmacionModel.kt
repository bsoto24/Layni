package pe.openlab.layni.ui.confirmacion

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import pe.openlab.layni.entity.Reserva
import java.util.HashMap

class ConfirmacionModel(val presenter: Confirmacion.Presenter): Confirmacion.Model {

    override fun reservar(reserva: Reserva) {

        val database = FirebaseFirestore.getInstance()

        val res = HashMap<String, Any>()
        res["cursos"] = reserva.cursos
        res["horario"] = reserva.horario
        res["lugar"] = reserva.lugar
        res["nivel"] = reserva.nivel
        res["tutor"] = reserva.tutor
        res["estado"] = "Por confirmar"
        res["timestamp"] = FieldValue.serverTimestamp()

        database.collection("Reserva")
                .add(res)
                .addOnSuccessListener { presenter.mostrarConfirmacion("Su reserva se realizo con exito") }
                .addOnFailureListener { e -> presenter.mostrarError(e.toString()) }

    }

}