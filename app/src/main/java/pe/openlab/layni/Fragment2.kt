package pe.openlab.layni

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_2.view.*

class Fragment2 : Fragment(){

    var matematicas = false
    var letras = false
    var ingles = false
    var computacion = false

    lateinit var reserva: ReservaInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        var cursos = arrayListOf<String>()

        view.ly_matematicas.setOnClickListener {

            if (!matematicas) {

                matematicas = true
                cursos.add("Matematicas")

                view.rl_matematicas_selected.visibility = View.VISIBLE

            }else {

                cursos.remove("Matematicas")
                matematicas = false
                view.rl_matematicas_selected.visibility = View.GONE

            }

            reserva.selectCursos(cursos)

        }

        view.ly_letras.setOnClickListener {
            if (!letras) {

                letras = true
                cursos.add("Letras")

                view.rl_letras_selected.visibility = View.VISIBLE

            }else {

                letras = false
                cursos.remove("Letras")
                view.rl_letras_selected.visibility = View.GONE

            }

            reserva.selectCursos(cursos)

        }

        view.ly_ingles.setOnClickListener {
            if (!ingles) {

                ingles = true
                cursos.add("Ingles")
                view.rl_ingles_selected.visibility = View.VISIBLE

            }else {

                ingles = false
                cursos.remove("Ingles")
                view.rl_ingles_selected.visibility = View.GONE

            }

            reserva.selectCursos(cursos)

        }

        view.ly_computacion.setOnClickListener {
            if (!computacion) {

                computacion = true
                cursos.add("Computacion")
                view.rl_computacion_selected.visibility = View.VISIBLE

            }else {

                computacion = false
                cursos.remove("Computacion")
                view.rl_computacion_selected.visibility = View.GONE

            }

            reserva.selectCursos(cursos)

        }

        return view
    }

    fun setReservaInterface(reservaInterface: ReservaInterface){
        this.reserva = reservaInterface
    }

}