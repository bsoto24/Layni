package pe.openlab.layni

interface ReservaInterface {

    fun selectNivel(nivel: String)

    fun selectLugar(lugar: String)

    fun selectCursos(cursos: List<String>)

    fun selectTutor(tutor: String, foto: String, horario:String)

}