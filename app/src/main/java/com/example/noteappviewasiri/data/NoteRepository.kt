package com.example.noteappviewasiri.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository {
    var db: NoteDao
    var getNotes: LiveData<List<Note>>

    constructor(cont: Application) {
        db = NoteDatabase.getInstance(cont).noteDao()
        getNotes = db.getall()

    }

    fun addedit(note: Note) {
        insTask(db).execute(note)

    }


    fun deleteNote(note: Note) {
        delNote(db).execute(note)

    }

    fun update(note: String, ID : Int) {
       var Node = Note(note,ID)
        updateNote(db).execute(Node)

    }

    fun getAll(): LiveData<List<Note>> {
        return getNotes
    }


    //classes below are methods to update the database in the background
    class insTask(var db: NoteDao) : AsyncTask<Note, Void, String>() {
        override fun doInBackground(vararg p0: Note?): String {
            db.addeditNote(p0[0]!!)
            return ""
        }
    }

    class delNote(var db: NoteDao) : AsyncTask<Note, Void, String>() {
        override fun doInBackground(vararg p0: Note?): String {
            db.delete(p0[0]!!)

            return ""
        }
    }
    class updateNote(var db: NoteDao) : AsyncTask<Note, Void, String>() {
        override fun doInBackground(vararg p0: Note?): String {
            db.update(p0[0]!!)
            return ""
        }
    }
}


