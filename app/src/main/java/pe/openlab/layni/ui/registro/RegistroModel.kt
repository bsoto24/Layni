package pe.openlab.layni.ui.registro

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import pe.openlab.layni.entity.User
import pe.openlab.layni.repository.local.database.DatabaseHandler
import java.util.HashMap

class RegistroModel(private val presenter: Registro.Presenter?, val context: Context) : Registro.Model {

    override fun registrar(user: User) {

        val database = FirebaseFirestore.getInstance()

        val us = HashMap<String, Any>()
        us.put("nombres", user.nombres)
        us.put("apellidos", user.apellidos)
        us.put("correo", user.correo)
        us.put("telefono", user.telefono)
        us.put("direccion", user.direccion)

        database.collection("usuarios")
                .add(us)
                .addOnSuccessListener {
                    DatabaseHandler(context).insertUser(user)
                    presenter?.mostrarConfirmacion("Usuario creado con exito") }
                .addOnFailureListener { e -> presenter?.mostrarError(e.toString()) }

    }

}