package pe.openlab.layni.ui.reservas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_reservas.*
import pe.openlab.layni.R
import pe.openlab.layni.entity.Reserva
import android.view.animation.AnimationUtils
import android.support.v7.widget.RecyclerView

class ReservasActivity : AppCompatActivity(), Reservas.View {

    private var adapter: ReservasAdapter = ReservasAdapter(this)
    private var presenter: Reservas.Presenter = ReservasPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservas)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        rvReservas.adapter = adapter
        rvReservas.layoutManager = LinearLayoutManager(this)

        presenter.obtenerReservas(123)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun mostrarReservas(reservas: MutableList<Reserva>) {

        adapter.addReservas(reservas)
        runLayoutAnimation(rvReservas)

    }

    override fun mostrarError(mensaje: String) {
        Snackbar.make(ly_container, mensaje, Snackbar.LENGTH_SHORT)
    }

    private fun runLayoutAnimation(recyclerView: RecyclerView) {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)

        recyclerView.layoutAnimation = controller
        recyclerView.adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

}
