package pe.openlab.layni

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_reserva.view.*
import pe.openlab.layni.entity.Reserva

class ReservasAdapter constructor(private var complejos: List<Reserva>, private var context: Context) : RecyclerView.Adapter<ReservasAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_reserva, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(complejos[position])

    override fun getItemCount(): Int = complejos.size

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(reserva: Reserva) {

            itemView.tvNivel.text = reserva.nivel
            itemView.tvLugar.text = reserva.lugar
            itemView.tvTutor.text = reserva.tutor
            itemView.tvCursos.text = reserva.cursos
            itemView.tvHorario.text = reserva.horario
            itemView.imgTutor.loadUrl(reserva.tutorFoto)

        }

        private fun ImageView.loadUrl(photo: String) =
                Picasso.get()
                        .load(photo)
                        .into(this)

    }
}