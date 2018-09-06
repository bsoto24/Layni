package pe.openlab.layni.entity

import java.io.Serializable

data class Reserva (
        var id: String = "",
        var nivel: String = "",
        var lugar: String = "",
        var tutor: String = "",
        var horario: String = "",
        var cursos: String = "",
        var fecha: String = "",
        var estado: String = ""
) : Serializable