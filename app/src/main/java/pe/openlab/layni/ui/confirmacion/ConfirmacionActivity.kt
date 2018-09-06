package pe.openlab.layni.ui.confirmacion

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_confirmacion.*
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.main.MainActivity
import pe.openlab.layni.R


class ConfirmacionActivity: AppCompatActivity(), Confirmacion.View {

    val presenter: Confirmacion.Presenter? = ConfirmacionPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val reserva: Reserva = intent.extras.getSerializable("reserva") as Reserva

        tvNivel.text = reserva.nivel
        tvLugar.text = reserva.lugar
        tvCursos.text = reserva.cursos
        tvTutor.text = reserva.tutor
        tvHorario.text = reserva.horario

        btnListo.setOnClickListener {

            presenter?.reservar(reserva)

        }

    }


    override fun mostrarError(mensaje: String) {

        Snackbar.make(ly_container, mensaje, Snackbar.LENGTH_SHORT).show()

    }

    override fun mostrarConfirmacion(mensaje: String) {

        Snackbar.make(ly_container, mensaje, Snackbar.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}