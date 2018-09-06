package pe.openlab.layni.ui.reserva

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.ui.reserva.cursos.Fragment2
import pe.openlab.layni.ui.reserva.tutor.Fragment5
import pe.openlab.layni.ui.reserva.horas.Fragment4
import pe.openlab.layni.ui.reserva.lugar.Fragment3
import pe.openlab.layni.ui.reserva.nivel.Fragment1

class ReservaAdapter(fm: FragmentManager, var reservaInterface: ReservaInterface, val reserva: Reserva): FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Fragment1.newInstance(reserva).setReservaInterface(reservaInterface)
            1 -> Fragment2.newInstance(reserva).setReservaInterface(reservaInterface)
            2 -> Fragment3.newInstance(reserva).setReservaInterface(reservaInterface)
            3 -> Fragment4.newInstance(reserva).setReservaInterface(reservaInterface)
            4 -> Fragment5.newInstance(reserva).setReservaInterface(reservaInterface)
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Page $position"
    }

}