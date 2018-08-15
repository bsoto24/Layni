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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_2, container, false)

        view.ly_matematicas.setOnClickListener {
            if (!matematicas) {

                matematicas = true

                view.rl_matematicas_selected.visibility = View.VISIBLE

            }else {

                matematicas = false
                view.rl_matematicas_selected.visibility = View.GONE

            }
        }

        view.ly_letras.setOnClickListener {
            if (!letras) {

                letras = true

                view.rl_letras_selected.visibility = View.VISIBLE

            }else {

                letras = false
                view.rl_letras_selected.visibility = View.GONE

            }
        }

        view.ly_ingles.setOnClickListener {
            if (!ingles) {

                ingles = true

                view.rl_ingles_selected.visibility = View.VISIBLE

            }else {

                ingles = false
                view.rl_ingles_selected.visibility = View.GONE

            }
        }

        view.ly_computacion.setOnClickListener {
            if (!computacion) {

                computacion = true

                view.rl_computacion_selected.visibility = View.VISIBLE

            }else {

                computacion = false
                view.rl_computacion_selected.visibility = View.GONE

            }
        }

        return view
    }

}