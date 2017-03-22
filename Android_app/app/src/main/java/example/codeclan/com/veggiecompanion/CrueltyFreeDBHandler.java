package example.codeclan.com.veggiecompanion;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 22/03/2017.
 */

public class CrueltyFreeDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "VeggieCompanion";
    private static final String TABLE_CRUELTYFREE = "crueltyfree";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "entry_name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_FAVOURITE = "favourite";
    private static final String KEY_TYPE = "type";
    private static final String KEY_IMAGE = "image";

    private static final String CREATE_TABLE_CRUELTY_FREE = "CREATE TABLE " + TABLE_CRUELTYFREE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " VARCHAR," + KEY_DESCRIPTION
            + " TEXT," + KEY_TYPE + " VARCHAR," + KEY_FAVOURITE + " BOOLEAN," + KEY_IMAGE
            + " TEXT" + ")";

}
