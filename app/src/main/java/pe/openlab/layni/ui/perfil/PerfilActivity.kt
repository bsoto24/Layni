package pe.openlab.layni.ui.perfil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_perfil.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.User

class PerfilActivity : AppCompatActivity(), Perfil.View {

    val presenter: Perfil.Presenter? = PerfilPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        presenter?.obtenerPerfil()

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun mostrarPerfil(user: User) {

        tvNombres.text = user.nombres
        tvApellidos.text = user.apellidos
        tvCorreo.text = user.correo
        tvTelefono.text = user.telefono

    }

    override fun mostrarError(mensaje: String) {

        Snackbar.make(ly_container, mensaje, Snackbar.LENGTH_SHORT).show()

    }

}
