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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_4, container, false)

        view.cv_tutor1.setOnClickListener {
            if (!tutor1) {

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

}