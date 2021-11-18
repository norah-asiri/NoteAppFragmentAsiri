package com.example.noteappviewasiri

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteappviewasiri.adapter.NoteAdapter
import com.example.noteappviewasiri.data.Note
import org.w3c.dom.Node

class Editor : Fragment() {
    private lateinit var tvNoteTextUpdate: TextView
    private lateinit var etNoteText: EditText
    private lateinit var addBtn: Button
    private lateinit var rvAdapter: NoteAdapter
    private  var upNote : Note = Note("")

//    private lateinit var ourRv: RecyclerView
    val mvm by lazy { ViewModelProvider(this).get(NoteViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v= inflater.inflate(R.layout.fragment_editor, container, false)
        setHasOptionsMenu(true)
        init(v)

        val sharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)


        addBtn.setOnClickListener{

            if(etNoteText.text.isNotEmpty()){
                val noteId = sharedPreferences.getString("NoteId", "").toString()
                mvm.update( etNoteText.text.toString(),noteId.toInt())
                with(sharedPreferences.edit()) {
                    putString("NoteId", etNoteText.text.toString())
                    apply()
                }
            }else{
                    Toast.makeText(requireContext(),"fields can't be empty", Toast.LENGTH_SHORT).show()



                //tvNoteTextUpdate.text = etNoteText.text.toString()
              //  upNote.noteText=etNoteText.text.toString()
              //  mvm.update(upNote)
                Navigation.findNavController(requireView()).navigate(R.id.action_editor_to_main)
            }
        }

        return v
    }
    fun init(v: View) {
        // taskTitle = v.findViewById(R.id.taskTitle)
        //taskDescription = v.findViewById(R.id.taskDescription)
        etNoteText=v.findViewById(R.id.etNote)
        tvNoteTextUpdate=v.findViewById(R.id.tvEditor)
        addBtn = v.findViewById(R.id.updateSave)
            Toast.makeText(requireContext(),"updated DDDDD", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(updateNote: Note) = Editor().apply {
            upNote=updateNote
        }
    }

}