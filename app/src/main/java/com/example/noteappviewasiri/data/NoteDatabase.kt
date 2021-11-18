package com.example.noteappviewasiri.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// when we need to add new column or table in database must be update version = 1 and so on.
@Database(entities = [Note::class],version =1,exportSchema = false)
/* note:
Database class must be abstract class
Data access object must be interface
 */

abstract class NoteDatabase: RoomDatabase() {

    // How we want access to database
    companion object {
        @Volatile  // writes to this field are immediately visible to other threads
        var instance: NoteDatabase? = null;

        // we use singleton instance to grantee no multiple connection with database
        fun getInstance(cont: Context): NoteDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(cont).also { instance = it }
            }
        }

        fun buildDatabase(cont: Context): NoteDatabase {
            return Room.databaseBuilder(cont, NoteDatabase::class.java, "NoteDB").build()
        }
    }

    abstract fun noteDao(): NoteDao
}

