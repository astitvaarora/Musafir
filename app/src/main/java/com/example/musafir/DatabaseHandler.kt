package com.example.musafir

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME="MUSAFIR_INFORMATION"
val TABLE_NAME = "USERS"
val COL_NAME = "name"
val COL_EMAIL= "email"
val COL_PHONENUMBER = "phoneNumber"
val V_ID = "Verification_id"
val NO_OF_CHILDREN = "no_of_children"
val NO_OF_ADULT = "no_of_adult"
val NO_OF_FOREIGNER = "no_of_foreigner"
val DATE = "date"
val PID = "pid"


class DatabaseHandler(var context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE "+ TABLE_NAME+" ("+
                V_ID +" VARCHAR(15) PRIMARY KEY," +
                PID +" VARCHAR(55),"+
                COL_NAME +" VARCHAR(100),"+
                COL_EMAIL +" VARCHAR(100),"+
                COL_PHONENUMBER +" VARCHAR(100),"+
                NO_OF_CHILDREN +" NUMBER,"+
                NO_OF_ADULT +" NUMBER,"+
                NO_OF_FOREIGNER +" NUMBER,"+
                DATE +" VARCHAR)";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insertData(user : UserData){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(V_ID,user.v_id)
        cv.put(COL_NAME,user.name)
        cv.put(COL_EMAIL,user.email)
        cv.put(COL_PHONENUMBER,user.phone_number)
        cv.put(NO_OF_ADULT,user.no_of_adult)
        cv.put(NO_OF_CHILDREN,user.no_of_children)
        cv.put(NO_OF_FOREIGNER,user.no_of_foreigner)
        cv.put(PID,user.pId)
        cv.put(DATE,user.date)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong()){
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
        }
    }
}