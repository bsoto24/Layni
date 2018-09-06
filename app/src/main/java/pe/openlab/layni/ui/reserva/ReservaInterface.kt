package pe.openlab.layni.ui.reserva

interface ReservaInterface {

    fun selectNivel(nivel: String)

    fun selectLugar(lugar: String)

    fun selectCursos(cursos: List<String>)

    fun selectTutor(tutor: String, horario:String)

}