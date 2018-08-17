package pe.openlab.layni

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_1.view.*

class Fragment1 : Fragment(){

    var primaria = false
    var secundaria = false

    lateinit var reserva: ReservaInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        view.lyPrimaria.setOnClickListener {
            if (!primaria) {

                reserva.selectNivel("Primaria")

                primaria = true
                secundaria = false

                view.rlPrimariaSelected.visibility = View.VISIBLE
                view.rlSecundariaSelected.visibility = View.GONE

            }else {

                primaria = false
                view.rlPrimariaSelected.visibility = View.GONE

            }
        }

        view.ly_secundaria.setOnClickListener {
            if (!secundaria) {

                reserva.selectNivel("Secundaria")

                primaria = false
                secundaria = true

                view.rlPrimariaSelected.visibility = View.GONE
                view.rlSecundariaSelected.visibility = View.VISIBLE

            }else {

                secundaria = false
                view.rlSecundariaSelected.visibility = View.GONE

            }
        }

        return view
    }


    fun setReservaInterface(reservaInterface: ReservaInterface){
        this.reserva = reservaInterface
    }



}