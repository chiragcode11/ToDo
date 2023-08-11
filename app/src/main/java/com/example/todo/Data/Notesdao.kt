package com.example.todo.Data

import androidx.core.view.accessibility.AccessibilityViewCommand.SetSelectionArguments
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todo.Model.Notes


@Dao
interface Notesdao {

    @Query(value = " SELECT * FROM Notes ")
    fun Getnotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertnotes(notes:Notes)

//    @Query ("DELETE FROM Notes WHERE id=:id")
//    fun deletenotes(id  : Int)

    @Update
    fun updatenotes (notes: Notes)

}