package pe.openlab.layni.entity

import java.io.Serializable

data class Reserva (
        var id: Int = -1,
        var nivel: String = "",
        var lugar: String = "",
        var tutor: String = "",
        var tutorFoto: String = "",
        var horario: String = "",
        var cursos: String = ""
) : Serializable