package pe.openlab.layni.ui.reserva.nivel

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_1.view.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.reserva.ReservaInterface

class Fragment1 : Fragment() {

    var primaria = false
    var secundaria = false

    lateinit var reservaInterface: ReservaInterface

    companion object {

        fun newInstance(reserva: Reserva) = Fragment1().apply { arguments = Bundle().apply { putSerializable("reserva", reserva) } }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val reserva: Reserva = arguments?.getSerializable("reserva") as Reserva

        when (reserva.nivel) {
            "Primaria" -> view.rlPrimariaSelected.visibility = View.VISIBLE

            "Secundaria" -> view.rlSecundariaSelected.visibility = View.VISIBLE


        }

        view.lyPrimaria.setOnClickListener {
            if (!primaria) {

                reservaInterface.selectNivel("Primaria")

                primaria = true
                secundaria = false

                view.rlPrimariaSelected.visibility = View.VISIBLE
                view.rlSecundariaSelected.visibility = View.GONE

            } else {

                primaria = false
                view.rlPrimariaSelected.visibility = View.GONE

            }
        }

        view.ly_secundaria.setOnClickListener {
            if (!secundaria) {

                reservaInterface.selectNivel("Secundaria")

                primaria = false
                secundaria = true

                view.rlPrimariaSelected.visibility = View.GONE
                view.rlSecundariaSelected.visibility = View.VISIBLE

            } else {

                secundaria = false
                view.rlSecundariaSelected.visibility = View.GONE

            }
        }

        return view
    }


    fun setReservaInterface(reservaInterface: ReservaInterface): Fragment {
        this.reservaInterface = reservaInterface
        return this
    }

}