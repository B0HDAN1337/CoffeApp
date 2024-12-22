package com.example.coffeeadpp
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

  class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME , null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "coffeeApp.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private  const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME( 
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, 
                $COLUMN_NAME TEXT, 
                $COLUMN_EMAIL TEXT, 
                $COLUMN_PASSWORD TEXT
            )
            """
        db.execSQL(createTableQuery)
    }

      override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
          // Handle database schema upgrades
          db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
          onCreate(db)
      }

    fun registerUser(name: String, email: String, password: String) : Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_PASSWORD, password)
        return db.insert(TABLE_NAME, null, values)
    }

    fun loginUser(email: String, password: String) : Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))
        val isLoggedIn = cursor.moveToFirst()
        cursor.close()
        return isLoggedIn
    }
      override fun close() {
          this.writableDatabase.close()
          this.readableDatabase.close()
          super.close()
      }

  }