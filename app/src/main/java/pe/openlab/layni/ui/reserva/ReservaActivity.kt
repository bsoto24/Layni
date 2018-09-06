package pe.openlab.layni.ui.reserva

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reserva.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.confirmacion.ConfirmacionActivity


class ReservaActivity : AppCompatActivity(), ReservaInterface {

    var reserva: Reserva = Reserva()
    var step: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        pager?.adapter = ReservaAdapter(supportFragmentManager, this, reserva)
        indicator.setViewPager(pager)

        indicator.addOnStepClickListener { step -> pager.setCurrentItem(step, true) }

        btnVolver.setOnClickListener {

            if (step > 0) {

                step--
                pager.setCurrentItem(step, true)

            }
        }

        btnContinuar.setOnClickListener {

            if (step < 4) {

                step++
                pager.setCurrentItem(step, true)

            } else {
                val intent = Intent(this, ConfirmacionActivity::class.java)
                intent.putExtra("reserva", reserva)
                startActivity(intent)
                finish()
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {

    }


    override fun selectNivel(nivel: String) {
        reserva.nivel = nivel
        step++
        pager.setCurrentItem(step, true)
    }

    override fun selectLugar(lugar: String) {
        reserva.lugar = lugar
        step++
        pager.setCurrentItem(step, true)
    }

    override fun selectCursos(cursos: List<String>) {
        var tem = ""
        for (c in cursos){
            if (c == cursos.last()){
                tem += "$c"
            }else{
                tem += "$c, "
            }
        }
        reserva.cursos = tem
    }

    override fun selectTutor(tutor: String, horario: String) {
        reserva.tutor = tutor
        reserva.horario = horario
    }

}
