package com.example.todo.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Entity("Notes")
@Parcelize
class Notes (

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,


    var title : String,
    var subtitle : String,
    var notes : String,
    var date : String,
    var priority : String,


    ) : Parcelable