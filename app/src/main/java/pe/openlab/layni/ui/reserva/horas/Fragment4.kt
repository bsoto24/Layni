package pe.openlab.layni.ui.reserva.horas

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_4.*
import kotlinx.android.synthetic.main.fragment_4.view.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.reserva.ReservaInterface


class Fragment4 : Fragment(){

    var local = false
    var domicilio = false

    lateinit var reservaInterface: ReservaInterface

    companion object {

        fun newInstance(reserva: Reserva) = Fragment4().apply { arguments = Bundle().apply { putSerializable("reserva", reserva) } }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_4, container, false)

        view.tv_hora_1.setOnClickListener {
            tv_hora_1.setBackgroundResource(R.drawable.circle_active)
            tv_hora_2.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_3.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_4.setBackgroundResource(R.drawable.circle_neutro)
        }

        view.tv_hora_2.setOnClickListener {
            tv_hora_1.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_2.setBackgroundResource(R.drawable.circle_active)
            tv_hora_3.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_4.setBackgroundResource(R.drawable.circle_neutro)
        }

        view.tv_hora_3.setOnClickListener {
            tv_hora_1.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_2.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_3.setBackgroundResource(R.drawable.circle_active)
            tv_hora_4.setBackgroundResource(R.drawable.circle_neutro)
        }

        view.tv_hora_4.setOnClickListener {
            tv_hora_1.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_2.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_3.setBackgroundResource(R.drawable.circle_neutro)
            tv_hora_4.setBackgroundResource(R.drawable.circle_active)
        }

        return view
    }



    fun setReservaInterface(reservaInterface: ReservaInterface): Fragment{
        this.reservaInterface = reservaInterface
        return this
    }

}