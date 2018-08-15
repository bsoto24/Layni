package pe.openlab.layni

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val fragments = arrayOf(Fragment1(), Fragment2(), Fragment3(), Fragment4())
    private lateinit var stepper: Array<TextView>
    private val TAGS = arrayOf("Fragment1", "Fragment2", "Fragment3", "Fragment4")
    private var fragmentposition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        stepper = arrayOf(step1, step2, step3, step4)

        showFragment(fragmentposition)

        btnContinuar.setOnClickListener {
            if (fragmentposition<3){
                fragmentposition++

                for (i in 0..3) {
                    if (i == fragmentposition){
                        stepper[i].setBackgroundResource(R.drawable.circle_active)

                    }else{
                        stepper[i].setBackgroundResource(R.drawable.circle_neutro)

                    }
                }

                showFragment(fragmentposition)
                if (fragmentposition == 3){
                    btnContinuar.setText("Reservar")
                }
            }else{
                startActivity(Intent(this, ConfirmacionActivity::class.java))
                finish()
            }
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            finish()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_reservas -> {
                var intent = Intent(this, ReservasActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_perfil -> {
                var intent = Intent(this, PerfilActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_acerca -> {

            }
            R.id.nav_salir -> {

                signOut()
                var intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    fun showFragment(position: Int) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (fragmentManager.findFragmentByTag(TAGS[position]) == null) {
            fragmentTransaction.add(R.id.flContainer, fragments[position], TAGS[position])
            fragmentTransaction.addToBackStack(TAGS[position])
        } else {
            for (i in 0..3) {
                if (i == position) {
                    fragmentTransaction.show(fragments[i]).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                } else {
                    fragmentTransaction.hide(fragments[i]).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                }
            }
        }
        fragmentTransaction.commit()

    }

    private fun signOut() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        mGoogleSignInClient.signOut()
    }

}
