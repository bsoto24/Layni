package pe.openlab.layni.splash

import android.content.Context

interface Splash{

    interface Model{

        fun verificarAutenticacion(context: Context)

    }

    interface View{

        fun usuarioAutenticado()
        fun usuarioNoAutenticado()

    }

    interface Presenter{

        fun verificarAutenticacion(context: Context)
        fun usuarioAutenticado()
        fun usuarioNoAutenticado()

    }

}