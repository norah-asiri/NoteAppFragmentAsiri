package com.example.noteappviewasiri.adapter
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteappviewasiri.Editor
import com.example.noteappviewasiri.Main
import com.example.noteappviewasiri.NoteViewModel
import com.example.noteappviewasiri.R
import com.example.noteappviewasiri.data.Note
import kotlinx.android.synthetic.main.fragment_editor.*
import kotlinx.android.synthetic.main.note_row.view.*
import kotlinx.coroutines.newSingleThreadContext

class NoteAdapter(val cont: Main): RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {
    private var items: List<Note> = listOf()
    val mvm by lazy { ViewModelProvider(cont).get(NoteViewModel::class.java) }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            LayoutInflater.from(parent.context).inflate(R.layout.note_row, parent, false)
            return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.note_row, parent, false)
            )
        }


        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            /*
            if (position % 2 == 0) {
                    llNoteHolder.setBackgroundColor(Color.rgb(213, 189, 218))
                } else {
                    llNoteHolder.setBackgroundColor(Color.rgb(244, 218, 248))
                }
             */
            val item = items[position]
            holder.itemView.apply {
                tvNote.text = item.noteText.toString()
                ibEditNote.setOnClickListener {
                    with(cont.sharedPreferences.edit()) {
                        putString("NoteId", item.id.toString())
                        apply()
                    }
                    Navigation.findNavController(this).navigate(R.id.action_main_to_editor)
                }
                    ibDeleteNote.setOnClickListener {
                            cont.mvm.deleteNote(item)

                    }

            }

        }
        override fun getItemCount() = items.size


        fun update(notes: List<Note>) {
            println("UPDATING DATA")
            this.items = notes
            notifyDataSetChanged()
        }
    }
