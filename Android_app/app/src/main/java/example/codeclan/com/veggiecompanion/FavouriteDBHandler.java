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

public class FavouriteDBHandler extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "VeggieCompanion";
    private static final String TABLE_FAVOURITES = "favourites";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "entry_name";
    private static final String KEY_DESCRIPTION = "description";

    private static final String CREATE_TABLE_FAVOURITES = "CREATE TABLE "
            + TABLE_FAVOURITES + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " VARCHAR," + KEY_DESCRIPTION + " TEXT" + ")";

    public FavouriteDBHandler(Context context){
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

    public void addFavouriteToFavourites(FavouriteModel favourite){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, favourite.getName());
        values.put(KEY_DESCRIPTION, favourite.getDescription());

        db.insert(TABLE_FAVOURITES, null, values);

        db.close();
    }

    public ArrayList<FavouriteModel> getAllFavourites(){
        ArrayList<FavouriteModel> favourite = new ArrayList<FavouriteModel>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVOURITES;

        Log.e("select all query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                FavouriteModel favourites = new FavouriteModel();
                favourites.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                favourites.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                favourites.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
            } while(cursor.moveToNext());
    }
}
