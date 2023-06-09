package com.joses.uts.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static final class NoteColumns implements BaseColumns {
        public static final String TABLE_NAME = "note";

        public static final String TOURNAMENT = "tournament";

        public static final String DESCRIPTION = "description";

        public static final String DATE = "date";

        public static final String PLATFORM = "platform";
    }
}
