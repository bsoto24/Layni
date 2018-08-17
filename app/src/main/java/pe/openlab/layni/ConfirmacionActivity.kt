package pe.openlab.layni

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_confirmacion.*
import pe.openlab.layni.database.DatabaseHandler
import pe.openlab.layni.entity.Reserva

class ConfirmacionActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val db = DatabaseHandler(this)
        val reserva: Reserva = intent.extras.getSerializable("reserva") as Reserva

        tvNivel.text = reserva.nivel
        tvLugar.text = reserva.lugar
        tvCursos.text = reserva.cursos
        tvTutor.text = reserva.tutor
        tvHorario.text = reserva.horario

        btnListo.setOnClickListener {

            val result = db.insertReserva(reserva)

            if (!result){
                Toast.makeText(this, "Algo salió mal, intente más tarde", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }

    }

}