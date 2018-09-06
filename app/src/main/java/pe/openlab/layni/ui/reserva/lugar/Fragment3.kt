package pe.openlab.layni.ui.reserva.lugar

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_3.view.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.reserva.ReservaInterface

class Fragment3 : Fragment() {

    var local = false
    var domicilio = false

    lateinit var reservaInterface: ReservaInterface

    companion object {

        fun newInstance(reserva: Reserva) = Fragment3().apply { arguments = Bundle().apply { putSerializable("reserva", reserva) } }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        val reserva: Reserva = arguments?.getSerializable("reserva") as Reserva
        when (reserva.lugar) {
            "Local" -> view.rl_local_selected.visibility = View.VISIBLE
            "Domicilio" -> view.rl_domicilio_selected.visibility = View.VISIBLE

        }

        view.ly_local.setOnClickListener {
            if (!local) {

                reservaInterface.selectLugar("Local")

                local = true
                domicilio = false

                view.rl_local_selected.visibility = View.VISIBLE
                view.rl_domicilio_selected.visibility = View.GONE

            } else {

                local = false
                view.rl_local_selected.visibility = View.GONE

            }
        }

        view.ly_domicilio.setOnClickListener {
            if (!domicilio) {

                reservaInterface.selectLugar("Domicilio")

                local = false
                domicilio = true

                view.rl_local_selected.visibility = View.GONE
                view.rl_domicilio_selected.visibility = View.VISIBLE

            } else {

                domicilio = false
                view.rl_domicilio_selected.visibility = View.GONE

            }
        }

        return view
    }


    fun setReservaInterface(reservaInterface: ReservaInterface): Fragment {
        this.reservaInterface = reservaInterface
        return this
    }

}