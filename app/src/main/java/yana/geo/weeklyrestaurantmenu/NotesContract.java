package yana.geo.weeklyrestaurantmenu;

import android.provider.BaseColumns;

public class NotesContract {
    public static final class NotesEntry implements BaseColumns{
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_DAY_MEAL = "day_meal";
        public static final String COLUMN_MEAL_TITLE = "meal_title";
        public static final String COLUMN_DAY_OF_WEEK = "day_of_week";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_TYPE_OF_MEAL = "type_of_meal";

        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";
        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_DAY_MEAL +
                " " + TYPE_TEXT + ", " + COLUMN_MEAL_TITLE + " " + TYPE_TEXT + ", " + COLUMN_DAY_OF_WEEK +
                " " + TYPE_TEXT + ", " + COLUMN_DESCRIPTION + " " + TYPE_TEXT + ", " + COLUMN_TYPE_OF_MEAL +
                " " + TYPE_INTEGER + ")";

        public  static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
