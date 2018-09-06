package pe.openlab.layni.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_login.*
import pe.openlab.layni.ui.main.MainActivity
import pe.openlab.layni.R
import pe.openlab.layni.ui.registro.RegistroActivity
import pe.openlab.layni.entity.User

class LoginActivity : AppCompatActivity(), Login.View{

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 1000
    val user = User()
    val presenter: Login.Presenter = LoginPresenter(this, this)

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            user.nombres = account.displayName!!
            user.apellidos = account.familyName!!
            user.correo = account.email!!
            presenter.login(user.correo)

        } catch (e: ApiException) {
            Snackbar.make(findViewById(R.id.container), "Algo salió mal, intente más tarde", Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        btnInvitado.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btnFacebook.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btnGoogle.setOnClickListener {
            signIn()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    override fun mostrarError(mensaje: String) {
        Snackbar.make(container, mensaje, Snackbar.LENGTH_SHORT).show()
    }

    override fun usuarioNuevo() {
        val intent = Intent(this, RegistroActivity::class.java)
        intent.putExtra("user", user)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun usuarioExiste(user: User) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

}