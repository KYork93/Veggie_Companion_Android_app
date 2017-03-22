package example.codeclan.com.veggiecompanion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

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
            + " TEXT," + KEY_TYPE + " VARCHAR," + KEY_FAVOURITE + " INT," + KEY_IMAGE
            + " TEXT" + ")";

    public CrueltyFreeDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CRUELTY_FREE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CRUELTYFREE);

        db.close();
    }

    public ArrayList<CrueltyFreeModel> getAllCrueltyFree(){

        ArrayList<CrueltyFreeModel> companies = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_CRUELTYFREE;

        Log.e("select all query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                CrueltyFreeModel company = new CrueltyFreeModel();
                company.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                company.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                company.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
                company.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
                company.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGE)));
                company.setFavourite(cursor.getString(cursor.getColumnIndex(KEY_FAVOURITE)));
            }
        }

    }
}
