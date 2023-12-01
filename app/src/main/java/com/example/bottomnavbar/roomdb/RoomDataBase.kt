package com.example.bottomnavbar.roomdb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RoomDataBase(context:Context,factory:SQLiteDatabase.CursorFactory?):SQLiteOpenHelper(context,DATABASENAME,factory,DATABASEVERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + tablename + " ("
                + movieid + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                title + " TEXT," +
                runtime + " TEXT," +
                director + " TEXT," +
                posterUrl + " TEXT," +
                genrecolomn + " TEXT," +
                actors + " TEXT," +
                plot + " TEXT" + ")")
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + tablename)
        onCreate(db)
    }
    fun addmoviedetails(actor:String,dir:String,plo:String,posterurl:String,run:String,tit:String,genre:String){

        val values=ContentValues()

        values.put(actors,actor)
        values.put(director,dir)
        values.put(plot,plo)
        values.put(posterUrl,posterurl)
        values.put(runtime,run)
        values.put(title,tit)
        values.put(genrecolomn,genre)
        val db=this.writableDatabase

        db.insert(tablename,null,values)
        db.close()

    }
    fun getmovies():Cursor?{
        val db=this.readableDatabase
        return db.rawQuery("SELECT * FROM "+ tablename,null)
    }
    fun getmoviebasedoncategory(category:String):Cursor?{
        val db=this.readableDatabase
        return db.rawQuery("SELECT * FROM "+ tablename+" WHERE Genres LIKE \'%${category}%\' ",null)
    }
    fun cleardb():Cursor?{
        val db=this.readableDatabase
        return db.rawQuery("Delete from MovieTable",null)
    }
    fun checkmovieexist(tite:String): Boolean {
        val db=this.readableDatabase
        var flag=false
        val check=db.rawQuery("SELECT Count(ID) FROM "+ tablename+" where $title =\"${tite}\"",null)
        val first=check.moveToFirst()
        val c=check.getInt(0)
        return c>=1


    }

    companion object{
        private val DATABASENAME="MovieDatabase"
        private val DATABASEVERSION=1
        val tablename="MovieTable"
        val movieid="ID"
        val actors="Actors"
        val director="Director"
        val plot="Plot"
        val posterUrl="PosterUrl"
        val runtime="Runtime"
        val title="Title"
        val genrecolomn="Genres"

    }

}