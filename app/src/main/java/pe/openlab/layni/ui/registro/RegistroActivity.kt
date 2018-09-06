package pe.openlab.layni.ui.registro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.User
import pe.openlab.layni.repository.local.session.SessionManager
import pe.openlab.layni.ui.login.LoginActivity
import pe.openlab.layni.ui.main.MainActivity

class RegistroActivity : AppCompatActivity(), Registro.View {

    private val presenter: Registro.Presenter? = RegistroPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val u: User = intent.extras.getSerializable("user") as User

        edtNombres.setText(u.nombres)
        edtApellidos.setText(u.apellidos)
        edtCorreo.setText(u.correo)

        btnGuardar.setOnClickListener {

            u.nombres = edtNombres.text.toString()
            u.apellidos = edtApellidos.text.toString()
            u.correo = edtCorreo.text.toString()
            u.telefono = edtTelefono.text.toString()
            u.direccion = edtDireccion.text.toString()

            presenter?.registrar(u)

        }

    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(this, "Algo salió mal, intente más tarde", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun mostrarConfirmacion(mensaje: String) {
        SessionManager.isLogged = true
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}

