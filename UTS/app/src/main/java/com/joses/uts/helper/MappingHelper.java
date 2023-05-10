package com.joses.uts.helper;

import android.database.Cursor;

import com.joses.uts.db.DatabaseContract;
import com.joses.uts.model.Note;

import java.util.ArrayList;

public class MappingHelper {

    public static ArrayList<Note> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Note> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String tournament = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TOURNAMENT));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));
            String platform = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.PLATFORM));
            notesList.add(new Note(id, tournament, description, date, platform));
        }
        return notesList;
    }
}
