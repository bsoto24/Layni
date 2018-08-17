package pe.openlab.layni

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_reserva.*
import pe.openlab.layni.entity.Reserva

class ReservaActivity : AppCompatActivity(), ReservaInterface {

    var reserva: Reserva = Reserva()
    private lateinit var fragments: Array<Fragment>
    private lateinit var stepper: Array<TextView>
    private val TAGS = arrayOf("Fragment1", "Fragment2", "Fragment3", "Fragment4")
    private var fragmentposition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val f1 = Fragment1()
        f1.setReservaInterface(this)
        val f2 = Fragment2()
        f2.setReservaInterface(this)
        val f3 = Fragment3()
        f3.setReservaInterface(this)
        val f4 = Fragment4()
        f4.setReservaInterface(this)
        fragments = arrayOf(f1,f2,f3,f4)

        stepper = arrayOf(step1, step2, step3, step4)



        showFragment(fragmentposition)

        btnContinuar.setOnClickListener {
            if (fragmentposition < 3) {
                fragmentposition++

                for (i in 0..3) {
                    if (i <= fragmentposition) {
                        stepper[i].setBackgroundResource(R.drawable.circle_active)
                    } else {
                        stepper[i].setBackgroundResource(R.drawable.circle_neutro)
                    }
                }

                showFragment(fragmentposition)

                btnVolver.visibility = View.VISIBLE

                if (fragmentposition == 3) {
                    btnContinuar.setText("Reservar")
                }

            } else {
                val intent = Intent(this, ConfirmacionActivity::class.java)
                intent.putExtra("reserva", reserva)
                startActivity(intent)
                finish()
            }
        }

        btnVolver.setOnClickListener {

            if (fragmentposition > 0) {

                fragmentposition--

                for (i in 0..3) {
                    if (i <= fragmentposition) {
                        stepper[i].setBackgroundResource(R.drawable.circle_active)
                    } else {
                        stepper[i].setBackgroundResource(R.drawable.circle_neutro)
                    }
                }

                showFragment(fragmentposition)

                if (fragmentposition == 0) {
                    btnVolver.visibility = View.GONE
                }

            }

        }

    }


    fun showFragment(position: Int) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (fragmentManager.findFragmentByTag(TAGS[position]) == null) {
            fragmentTransaction.add(R.id.flContainer, fragments[position], TAGS[position])
            fragmentTransaction.addToBackStack(TAGS[position])
        } else {
            for (i in 0..3) {
                if (i == position) {
                    fragmentTransaction.show(fragments[i]).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                } else {
                    fragmentTransaction.hide(fragments[i]).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                }
            }
        }
        fragmentTransaction.commit()

    }


    override fun selectNivel(nivel: String) {
        reserva.nivel = nivel
    }

    override fun selectLugar(lugar: String) {
        reserva.lugar = lugar
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

    override fun selectTutor(tutor: String, foto: String, horario: String) {
        reserva.tutor = tutor
        reserva.tutorFoto = foto
        reserva.horario = horario
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {

    }

}