package pe.openlab.layni.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pe.openlab.layni.entity.Reserva
import pe.openlab.layni.entity.User

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DatabaseHandler.DB_NAME, null, DatabaseHandler.DB_VERSION) {


    private val CREATE_TABLE_USER: String = "CREATE TABLE $TABLE_NAME_USER (" +
            USER_ID + " INTEGER PRIMARY KEY," +
            USER_NOMBRES + " TEXT," +
            USER_APELLIDOS + " TEXT," +
            USER_TELEFONO + " TEXT," +
            USER_CORREO + " TEXT," +
            USER_DIRECCION + " TEXT);"

    private val CREATE_TABLE_RESERVA: String = "CREATE TABLE $TABLE_NAME_RESERVA (" +
            RESERVA_ID + " INTEGER PRIMARY KEY," +
            RESERVA_NIVEL + " TEXT," +
            RESERVA_LUGAR + " TEXT," +
            RESERVA_TUTOR + " TEXT," +
            RESERVA_TUTOR_FOTO + " TEXT," +
            RESERVA_HORARIO + " TEXT," +
            RESERVA_CURSOS + " TEXT);"

    private val DROP_TABLE_USER: String = "DROP TABLE IF EXISTS $TABLE_NAME_USER"
    private val DROP_TABLE_RESERVA: String = "DROP TABLE IF EXISTS $TABLE_NAME_RESERVA"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_USER)
        db?.execSQL(CREATE_TABLE_RESERVA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_USER)
        db?.execSQL(DROP_TABLE_RESERVA)
        onCreate(db)
    }

    companion object {

        private val DB_VERSION = 1
        private val DB_NAME = "MyTasks"

        private val TABLE_NAME_USER = "User"
        private val USER_ID = "id"
        private val USER_NOMBRES = "nombres"
        private val USER_APELLIDOS = "apellidos"
        private val USER_TELEFONO = "telefono"
        private val USER_CORREO = "correo"
        private val USER_DIRECCION = "direccion"


        private val TABLE_NAME_RESERVA = "Reserva"
        private val RESERVA_ID = "id"
        private val RESERVA_NIVEL = "nivel"
        private val RESERVA_LUGAR = "lugar"
        private val RESERVA_TUTOR = "tutor"
        private val RESERVA_TUTOR_FOTO = "tutor_foto"
        private val RESERVA_HORARIO = "horario"
        private val RESERVA_CURSOS = "cursos"

    }


    fun insertUser(user: User): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(USER_NOMBRES, user.nombres)
        values.put(USER_APELLIDOS, user.apellidos)
        values.put(USER_TELEFONO, user.telefono)
        values.put(USER_CORREO, user.correo)
        values.put(USER_DIRECCION, user.direccion)

        val success = db.insert(TABLE_NAME_USER, null, values)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

    fun getUser(): User {
        val user = User()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME_USER"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            cursor.moveToFirst()
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    user.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(USER_ID)))
                    user.nombres = cursor.getString(cursor.getColumnIndex(USER_NOMBRES))
                    user.apellidos = cursor.getString(cursor.getColumnIndex(USER_APELLIDOS))
                    user.telefono = cursor.getString(cursor.getColumnIndex(USER_TELEFONO))
                    user.correo = cursor.getString(cursor.getColumnIndex(USER_CORREO))
                    user.direccion = cursor.getString(cursor.getColumnIndex(USER_DIRECCION))
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return user
    }

    fun dropUser(id: Int): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME_USER, USER_ID + "=?", arrayOf(id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun insertReserva(reserva: Reserva): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(RESERVA_NIVEL, reserva.nivel)
        values.put(RESERVA_LUGAR, reserva.lugar)
        values.put(RESERVA_TUTOR, reserva.tutor)
        values.put(RESERVA_TUTOR_FOTO, reserva.tutorFoto)
        values.put(RESERVA_HORARIO, reserva.horario)
        values.put(RESERVA_CURSOS, reserva.cursos)

        val success = db.insert(TABLE_NAME_RESERVA, null, values)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

    fun getReservas(): List<Reserva> {
        val reservas = arrayListOf<Reserva>()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME_RESERVA ORDER BY $RESERVA_ID DESC"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            cursor.moveToFirst()
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    var reserva = Reserva()
                    reserva.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(RESERVA_ID)))
                    reserva.nivel = cursor.getString(cursor.getColumnIndex(RESERVA_NIVEL))
                    reserva.lugar = cursor.getString(cursor.getColumnIndex(RESERVA_LUGAR))
                    reserva.tutor = cursor.getString(cursor.getColumnIndex(RESERVA_TUTOR))
                    reserva.tutorFoto = cursor.getString(cursor.getColumnIndex(RESERVA_TUTOR_FOTO))
                    reserva.horario = cursor.getString(cursor.getColumnIndex(RESERVA_HORARIO))
                    reserva.cursos = cursor.getString(cursor.getColumnIndex(RESERVA_CURSOS))
                    reservas.add(reserva)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return reservas
    }

}