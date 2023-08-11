package com.example.todo.Repository

import androidx.lifecycle.LiveData
import com.example.todo.Data.Notesdao
import com.example.todo.Model.Notes

class Notesrepository(val dao : Notesdao) {

    fun getallnotes() : LiveData<List<Notes>>{
        return dao.Getnotes()
    }
    fun insertnotes(notes: Notes){
        dao.insertnotes(notes)
    }
//    fun deletenotes(id:Int){
//        dao.deletenotes(id)
//    }
    fun updatenotes(notes: Notes){
        dao.updatenotes(notes)
    }

}