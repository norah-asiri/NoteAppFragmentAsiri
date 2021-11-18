package com.example.noteappviewasiri

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteappviewasiri.data.Note
import com.example.noteappviewasiri.data.NoteRepository

class NoteViewModel (application: Application): AndroidViewModel(application) {
    var repository= NoteRepository(application)
    private var list=repository.getAll()

    fun addedit(note: Note){
        repository.addedit(note)
        }

    fun update(note: String, ID : Int){
        repository.update(note, ID)
        }


    fun getNotes(): LiveData<List<Note>>{
        return list
    }


     fun deleteNote(note: Note){
            repository.deleteNote(note)
        }
    }
