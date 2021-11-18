package com.example.noteappviewasiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation

//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
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
        edNote = findViewById(R.id.etNote)
        rvNotes = findViewById(R.id.recyclerView)
        btnSave = findViewById(R.id.Save)



        btnSave.setOnClickListener {
            postNote()

        }
        updateRV()
    }

    // update RV to show new notes
    private fun updateRV(){

        CoroutineScope(Dispatchers.IO).launch {
            var f = NoteDatabase.getInstance(applicationContext).NoteDao().load()
            // tv.text = f.get(0).location
            rvNotes.adapter = NoteAdapter(applicationContext as MainActivity,f)
            rvNotes.layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    // get list of notes
    private fun load(): List<Note>{
        return NoteDatabase.getInstance(applicationContext).NoteDao().load() }

    // add note
    private fun postNote(){
        val note= edNote.text.toString()
        val s = Note(0,note)
        CoroutineScope(Dispatchers.IO).launch {
            NoteDatabase.getInstance(applicationContext).NoteDao().insert(s)
        }
        Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
            .show();

        updateRV()
    }


    // edit Note
    private fun editNote(noteID: Int, noteText: String){
        NoteDatabase.getInstance(applicationContext).NoteDao().update(Note(noteID, noteText))
        updateRV()
    }

    // delete Note
    private fun del(noteID: Int){
        NoteDatabase.getInstance(applicationContext).NoteDao().update(Note(noteID, ""))
        updateRV()
    }

    //confirmation alert
    fun deleteNote(noteID: Int){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    _, _ -> del(noteID)
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Are you sure?")
        alert.show()
    }

    fun raiseDialog(id: Int){
        val dialogBuilder = AlertDialog.Builder(this)
        val updatedNote = EditText(this)
        updatedNote.hint = "Enter new text"
        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("Save", DialogInterface.OnClickListener {
                    _, _ -> editNote(id, updatedNote.text.toString())
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Update Note")
        alert.setView(updatedNote)
        alert.show()
    }
}

 */
