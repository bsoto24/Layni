package pe.openlab.layni.entity

import java.io.Serializable

data class User(
        var id: Int = -1,
        var nombres: String = "",
        var apellidos: String = "",
        var telefono: String = "",
        var correo: String = "",
        var direccion: String = ""
) : Serializable