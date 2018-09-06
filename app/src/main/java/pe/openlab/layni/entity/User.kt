package pe.openlab.layni.entity

import java.io.Serializable

data class User(
        var id: String = "",
        var nombres: String = "",
        var apellidos: String = "",
        var telefono: String = "",
        var correo: String = "",
        var direccion: String = ""
) : Serializable