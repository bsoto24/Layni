package pe.openlab.layni

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_reservas.*
import pe.openlab.layni.database.DatabaseHandler
import pe.openlab.layni.entity.Reserva

class ReservasActivity : AppCompatActivity() {

    lateinit var reservas: List<Reserva>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservas)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val db = DatabaseHandler(this)

        reservas = db.getReservas()

        rvReservas.adapter = ReservasAdapter(reservas, this)
        rvReservas.layoutManager = LinearLayoutManager(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}
