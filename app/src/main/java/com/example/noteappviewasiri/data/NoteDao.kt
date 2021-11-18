package com.example.noteappviewasiri.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Query("Select * from Notet")
    fun getall(): LiveData<List<Note>>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
     fun addeditNote(note: Note)

    @Delete
     fun delete(note: Note)

    @Update
   fun update (note: Note)




}