package com.example.todo.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.Data.Notesdao
import com.example.todo.Model.Notes

@Database(entities = [Notes::class], version = 1,  exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesdao() : Notesdao

    companion object{
        @Volatile
        var INSTANCE : NotesDatabase? = null

        fun getdatabaseinstance(context: Context):NotesDatabase{
            val tempinstance = INSTANCE
            if(tempinstance!=null){
                return tempinstance
            }
            synchronized(this){
                val roomdatabaseinstace = Room.databaseBuilder(context, NotesDatabase::class.java,"Notes").allowMainThreadQueries().build()
                INSTANCE = roomdatabaseinstace
                return roomdatabaseinstace
            }
        }
    }

}