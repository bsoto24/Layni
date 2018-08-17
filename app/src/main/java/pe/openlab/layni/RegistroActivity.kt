package pe.openlab.layni

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*
import pe.openlab.layni.database.DatabaseHandler
import pe.openlab.layni.entity.User
import pe.openlab.layni.session.SessionManager

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val db = DatabaseHandler(this)

        val user: User = intent.extras.getSerializable("user") as User

        edtNombres.setText(user.nombres)
        edtApellidos.setText(user.apellidos)
        edtCorreo.setText(user.correo)

        btnGuardar.setOnClickListener {

            val u = User()
            u.nombres = edtNombres.text.toString()
            u.apellidos = edtApellidos.text.toString()
            u.correo = edtCorreo.text.toString()
            u.telefono = edtTelefono.text.toString()
            u.direccion = edtDireccion.text.toString()
            val result = db.insertUser(u)

            if (result){
                SessionManager.isLogged = true
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }else{
                Toast.makeText(this, "Algo salió mal, intente más tarde", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }

        }

    }
}
