package example.codeclan.com.veggiecompanion;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 17/03/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "VeggieCompanion";

    private static final String TABLE_RESTAURANT = "restaurants";
    private static final String TABLE_CRUELTYFREE = "cruelty_frees";
    private static final String TABLE_RESOURCES = "resources";
    private static final String TABLE_FAVOURITES = "favourites";

    //Shared
    private static final String KEY_ID = "id";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_NAME = "entry_name";
    private static final String KEY_FAVOURITE = "favourite";
    private static final String KEY_TYPE = "type";

    //Individual table columns
    //restaurant table
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LNG = "lng";

    //cruelty free table
    private static final String KEY_IMAGE = "image";

    //resources table
    private static final String KEY_SOURCE = "source";

    //Table create statements
    //restaurant create
    private static final String CREATE_TABLE_RESTAURANT = "CREATE TABLE "
            + TABLE_RESTAURANT + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_ADDRESS + " TEXT," + KEY_FAVOURITE + " BOOLEAN,"
            + KEY_DESCRIPTION + " TEXT," + KEY_LAT + " INT," + KEY_LNG + " INT" + ")";

    //cruelty free create
    private static final String CREATE_TABLE_CRUELTY_FREE = "CREATE TABLE " + TABLE_CRUELTYFREE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_TYPE + " TEXT," + KEY_FAVOURITE + " BOOLEAN," + KEY_IMAGE
            + " TEXT" + ")";
}
