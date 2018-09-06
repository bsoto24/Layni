package pe.openlab.layni.ui.reserva.tutor

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_5.view.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.reserva.ReservaInterface

class Fragment5 : Fragment(){


    var tutor1 = false
    var tutor2 = false

    lateinit var reservaInterface: ReservaInterface

    companion object {

        fun newInstance(reserva: Reserva) = Fragment5().apply { arguments = Bundle().apply { putSerializable("reserva", reserva) } }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_5, container, false)

        view.cv_tutor1.setOnClickListener {
            if (!tutor1) {

                reservaInterface.selectTutor("Bryam Soto", "3 pm - 4 pm")

                tutor1 = true
                tutor2 = false

                view.img_tutor1_selected.visibility = View.VISIBLE
                view.img_tutor2_selected.visibility = View.GONE

            }else {

                tutor1 = false
                view.img_tutor1_selected.visibility = View.GONE

            }
        }

        view.cv_tutor2.setOnClickListener {
            if (!tutor2) {

                reservaInterface.selectTutor("Gerardo Sanchez", "2 pm - 3 pm")

                tutor1 = false
                tutor2 = true

                view.img_tutor1_selected.visibility = View.GONE
                view.img_tutor2_selected.visibility = View.VISIBLE

            }else {

                tutor2 = false
                view.img_tutor2_selected.visibility = View.GONE

            }
        }

        return view
    }



    fun setReservaInterface(reservaInterface: ReservaInterface): Fragment{
        this.reservaInterface = reservaInterface
        return this
    }

}