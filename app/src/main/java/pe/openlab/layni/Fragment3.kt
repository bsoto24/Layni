package pe.openlab.layni

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_3.view.*

class Fragment3 : Fragment(){

    var local = false
    var domicilio = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_3, container, false)

        view.ly_local.setOnClickListener {
            if (!local) {

                local = true
                domicilio = false

                view.rl_local_selected.visibility = View.VISIBLE
                view.rl_domicilio_selected.visibility = View.GONE

            }else {

                local = false
                view.rl_local_selected.visibility = View.GONE

            }
        }

        view.ly_domicilio.setOnClickListener {
            if (!domicilio) {

                local = false
                domicilio = true

                view.rl_local_selected.visibility = View.GONE
                view.rl_domicilio_selected.visibility = View.VISIBLE

            }else {

                domicilio = false
                view.rl_domicilio_selected.visibility = View.GONE

            }
        }

        return view
    }

}