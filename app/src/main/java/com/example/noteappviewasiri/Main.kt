package com.example.noteappviewasiri

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteappviewasiri.adapter.NoteAdapter
import com.example.noteappviewasiri.data.Note

class Main : Fragment() {
    private lateinit var etNote: EditText
    private lateinit var rvAdapter: NoteAdapter
    private lateinit var ourRv: RecyclerView
    lateinit var sharedPreferences: SharedPreferences
    val mvm by lazy { ViewModelProvider(this).get(NoteViewModel::class.java)}



    private lateinit var btnSave: Button
    lateinit var notes: List<Note>
    lateinit var mainViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_main, container, false)

        // We use 'requireActivity()' to access MainActivity here
        sharedPreferences = requireActivity().getSharedPreferences(
        getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        setHasOptionsMenu(true)
        init(v)



        return v
    }
    fun init(v: View) {

        mainViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        btnSave = v.findViewById(R.id.Save)
        notes = listOf()
        etNote = v.findViewById(R.id.etNote)
        ourRv = v.findViewById(R.id.recyclerView)
        rvAdapter = NoteAdapter(this)
        ourRv.adapter = rvAdapter
        ourRv.layoutManager = LinearLayoutManager(requireContext())

        mvm.getNotes().observe(viewLifecycleOwner, {
            rvAdapter.update(it)
            Toast.makeText(requireContext(), "updated", Toast.LENGTH_SHORT).show()
        })

        btnSave.setOnClickListener {
            mainViewModel.addedit(Note(etNote.text.toString()))

        }


            }



    //////////// dialog //////////////

    fun raiseDialog (task : Note) {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val showTask = TextView(requireContext())
        showTask.text = task.noteText
        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, _ ->
                dialog.cancel()
            })
        // .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
        //   dialog.cancel()
        //})
        val alert = dialogBuilder.create()
        alert.setTitle(task.noteText)
        alert.setView(showTask)
        alert.show()
    }

}


