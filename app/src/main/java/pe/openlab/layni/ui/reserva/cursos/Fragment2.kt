package pe.openlab.layni.ui.reserva.cursos

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_2.view.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.reserva.ReservaInterface

class Fragment2 : Fragment() {

    var matematicas = false
    var letras = false
    var ingles = false
    var computacion = false
    val cursos = arrayListOf<String>()

    lateinit var reservaInterface: ReservaInterface

    companion object {

        fun newInstance(reserva: Reserva) = Fragment2().apply { arguments = Bundle().apply { putSerializable("reserva", reserva) } }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        val reserva: Reserva = arguments?.getSerializable("reserva") as Reserva
        if (reserva.cursos.contains("Matematicas")) view.rl_matematicas_selected.visibility = View.VISIBLE
        if (reserva.cursos.contains("Letras")) view.rl_letras_selected.visibility = View.VISIBLE
        if (reserva.cursos.contains("Ingles")) view.rl_ingles_selected.visibility = View.VISIBLE
        if (reserva.cursos.contains("Computacion")) view.rl_computacion_selected.visibility = View.VISIBLE

        view.ly_matematicas.setOnClickListener {

            if (!matematicas) {

                matematicas = true
                cursos.add("Matematicas")

                view.rl_matematicas_selected.visibility = View.VISIBLE

            } else {

                cursos.remove("Matematicas")
                matematicas = false
                view.rl_matematicas_selected.visibility = View.GONE

            }

            reservaInterface.selectCursos(cursos)

        }

        view.ly_letras.setOnClickListener {
            if (!letras) {

                letras = true
                cursos.add("Letras")

                view.rl_letras_selected.visibility = View.VISIBLE

            } else {

                letras = false
                cursos.remove("Letras")
                view.rl_letras_selected.visibility = View.GONE

            }

            reservaInterface.selectCursos(cursos)

        }

        view.ly_ingles.setOnClickListener {
            if (!ingles) {

                ingles = true
                cursos.add("Ingles")
                view.rl_ingles_selected.visibility = View.VISIBLE

            } else {

                ingles = false
                cursos.remove("Ingles")
                view.rl_ingles_selected.visibility = View.GONE

            }

            reservaInterface.selectCursos(cursos)

        }

        view.ly_computacion.setOnClickListener {
            if (!computacion) {

                computacion = true
                cursos.add("Computacion")
                view.rl_computacion_selected.visibility = View.VISIBLE

            } else {

                computacion = false
                cursos.remove("Computacion")
                view.rl_computacion_selected.visibility = View.GONE

            }

            reservaInterface.selectCursos(cursos)

        }

        return view
    }


    fun setReservaInterface(reservaInterface: ReservaInterface): Fragment {
        this.reservaInterface = reservaInterface
        return this
    }

}