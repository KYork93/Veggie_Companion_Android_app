package example.codeclan.com.veggiecompanion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 20/03/2017.
 */

public class FavouriteDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "VeggieCompanion";
    private static final String TABLE_FAVOURITES = "favourites";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "entry_name";
    private static final String KEY_DESCRIPTION = "description";

    private static final String CREATE_TABLE_FAVOURITES = "CREATE TABLE "
            + TABLE_FAVOURITES + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " VARCHAR," + KEY_DESCRIPTION + " TEXT" + ")";

    public FavouriteDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FAVOURITES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVOURITES);

        onCreate(db);
    }

    public void addFavouriteToFavourites(FavouriteModel favourite) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, favourite.getName());
        values.put(KEY_DESCRIPTION, favourite.getDescription());

        db.insert(TABLE_FAVOURITES, null, values);

        db.close();
    }

    public FavouriteModel getFavourite(long favourite_id){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_FAVOURITES + " WHERE "
                + KEY_ID + " = " + favourite_id;

        Log.e("select query", selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        FavouriteModel favourite = new FavouriteModel();

        favourite.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
        favourite.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        favourite.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));

        return favourite;
    }

    public ArrayList<FavouriteModel> getAllFavourites() {
        ArrayList<FavouriteModel> favourites = new ArrayList<FavouriteModel>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVOURITES;

        Log.e("select all query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FavouriteModel favourite = new FavouriteModel();
                favourite.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                favourite.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                favourite.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
            } while (cursor.moveToNext());
        }
        return favourites;
    }

    public int deleteAllFavourites(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_FAVOURITES, null, null);
    }
}
