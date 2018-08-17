package pe.openlab.layni

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_4.view.*

class Fragment4 : Fragment(){


    var tutor1 = false
    var tutor2 = false
    var horas = 0

    lateinit var reserva: ReservaInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_4, container, false)

        view.cv_tutor1.setOnClickListener {
            if (!tutor1) {

                reserva.selectTutor("Bryam Soto", "https://scontent.flim1-1.fna.fbcdn.net/v/t31.0-8/22047696_1814911961867220_856383736325046580_o.jpg?_nc_cat=0&oh=d8ab558f9936c2e68e034b36bd5bee23&oe=5C04C71A", "3 pm - 4 pm")

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

                reserva.selectTutor("Gerardo Sanchez", "https://scontent.flim1-1.fna.fbcdn.net/v/t1.0-9/38159482_2074797809199459_2745038427803090944_n.jpg?_nc_cat=0&oh=138236b4cdf90d92f4085045e16f31e0&oe=5C0AA695", "2 pm - 3 pm")

                tutor1 = false
                tutor2 = true

                view.img_tutor1_selected.visibility = View.GONE
                view.img_tutor2_selected.visibility = View.VISIBLE

            }else {

                tutor2 = false
                view.img_tutor2_selected.visibility = View.GONE

            }
        }


        view.btn_menos.setOnClickListener {
            if (horas>0){
                horas--
                view.tv_horas.text = "$horas"
            }
        }

        view.btn_mas.setOnClickListener{
            if (horas<5){
                horas++
                view.tv_horas.text = "$horas"
            }
        }

        return view
    }



    fun setReservaInterface(reservaInterface: ReservaInterface){
        this.reserva = reservaInterface
    }

}