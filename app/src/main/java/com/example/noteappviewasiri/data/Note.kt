package com.example.noteappviewasiri.data

import android.content.Context
import androidx.room.*

/*
1- create data class for entity-> table
2- Define Doa = data accss object
3- create database
4- create data base instance
 */

@Entity (tableName="Notet")//Next read as table
class Note(
    @ColumnInfo (name = "NoteText")
    var noteText: String,
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name="ID")
    var id: Int=0)

/*
@Entity(tableName = "NotesTable")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteText: String)
 */







