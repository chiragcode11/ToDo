package com.example.todo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todo.Database.NotesDatabase
import com.example.todo.Model.Notes
import com.example.todo.Repository.Notesrepository

class NotesViewModel(application: Application)  :AndroidViewModel(application) {

    lateinit var repository : Notesrepository

    init {
        val dao = NotesDatabase.getdatabaseinstance(application).notesdao()
        repository = Notesrepository(dao)
    }


    fun addnotes(notes: Notes){
        repository.insertnotes(notes)
    }
    fun getnotes():LiveData<List<Notes>> = repository.getallnotes()

//    fun deletenotes(id:Int){
//        repository.deletenotes(id)
//    }

    fun updatenotes(notes: Notes){
        repository.updatenotes(notes)
    }
}