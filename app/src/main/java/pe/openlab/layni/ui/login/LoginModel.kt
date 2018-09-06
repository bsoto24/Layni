package pe.openlab.layni.ui.login

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import pe.openlab.layni.entity.User
import pe.openlab.layni.repository.local.database.DatabaseHandler

class LoginModel(val presenter: Login.Presenter, val context: Context): Login.Model {

    override fun login(email: String) {

        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("usuarios")
        userRef.whereEqualTo("correo", email).get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        if (task.result.size() > 0) {
                            val user = User(
                                    task.result.documents[0].id,
                                    task.result.documents[0].data?.get("nivel").toString(),
                                    task.result.documents[0].data?.get("lugar").toString(),
                                    task.result.documents[0].data?.get("tutor").toString(),
                                    task.result.documents[0].data?.get("horario").toString(),
                                    task.result.documents[0].data?.get("cursos").toString()
                            )
                            Log.e("Usuario", user.nombres)
                            presenter.usuarioExiste(user)
                            DatabaseHandler(context).insertUser(user)

                        } else{
                            presenter.usuarioNuevo()
                        }
                    } else {
                        presenter.mostrarError(task.exception.toString())
                    }
                }
    }

}