package pe.openlab.layni.ui.reservas

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_reserva_lite.view.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva

class ReservasAdapter constructor(private var context: Context) : RecyclerView.Adapter<ReservasAdapter.ViewHolder>(){

    var reservas = mutableListOf<Reserva>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_reserva_lite, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(reservas[position])

    override fun getItemCount(): Int = reservas.size

    fun addReservas(reservas: MutableList<Reserva>){
        this.reservas = reservas
    }

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(reserva: Reserva) {

            itemView.tvNivel.text = reserva.nivel
            itemView.tvLugar.text = reserva.lugar
            itemView.tvCursos.text = reserva.cursos
            itemView.tvFecha.text = reserva.fecha
            itemView.tvEstado.text = reserva.estado
            when (reserva.estado){
                "Por confirmar" -> itemView.tvEstado.setBackgroundResource(R.drawable.corner_amarillo)
                "Confirmado" -> itemView.tvEstado.setBackgroundResource(R.drawable.corner_verde)
                "Cancelado" -> itemView.tvEstado.setBackgroundResource(R.drawable.corner_rojo)
            }

        }
    }
}