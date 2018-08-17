package pe.openlab.layni

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil.*
import pe.openlab.layni.database.DatabaseHandler
import pe.openlab.layni.entity.User
import pe.openlab.layni.session.SessionManager

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (SessionManager.isLogged){

            val db = DatabaseHandler(this)
            val user: User = db.getUser()

            tvNombres.text = user.nombres
            tvApellidos.text = user.apellidos
            tvCorreo.text = user.correo
            tvTelefono.text = user.telefono
            tvDireccion.text = user.direccion

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}
