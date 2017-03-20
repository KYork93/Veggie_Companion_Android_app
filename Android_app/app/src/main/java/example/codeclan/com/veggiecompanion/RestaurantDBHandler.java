package example.codeclan.com.veggiecompanion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 17/03/2017.
 */

public class RestaurantDBHandler extends SQLiteOpenHelper {

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
            + TABLE_RESTAURANT + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " VARCHAR," + KEY_ADDRESS + " VARCHAR," + KEY_FAVOURITE + " BOOLEAN,"
            + KEY_DESCRIPTION + " TEXT," + KEY_LAT + " INT," + KEY_LNG + " INT" + ")";

    //cruelty free create
    private static final String CREATE_TABLE_CRUELTY_FREE = "CREATE TABLE " + TABLE_CRUELTYFREE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " VARCHAR," + KEY_DESCRIPTION
            + " TEXT," + KEY_TYPE + " VARCHAR," + KEY_FAVOURITE + " BOOLEAN," + KEY_IMAGE
            + " TEXT" + ")";

    //resources create
    private static final String CREATE_TABLE_RESOURCES = "CREATE TABLE "
            + TABLE_RESOURCES + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " VARCHAR," + KEY_SOURCE + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_FAVOURITE
            + " BOOLEAN," + KEY_TYPE + " VARCHAR" + ")";

    //favourites create
    private static final String CREATE_TABLE_FAVOURITES = "CREATE TABLE "
            + TABLE_FAVOURITES + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " VARCHAR," + KEY_DESCRIPTION + " TEXT" + ")";


    public RestaurantDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RESTAURANT);
        db.execSQL(CREATE_TABLE_CRUELTY_FREE);
        db.execSQL(CREATE_TABLE_RESOURCES);
        db.execSQL(CREATE_TABLE_FAVOURITES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CRUELTYFREE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESOURCES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVOURITES);

        onCreate(db);
    }

    public void addToRestaurantTable(RestaurantModel restaurant){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, restaurant.getName());
        values.put(KEY_ADDRESS, restaurant.getAddress());
        values.put(KEY_DESCRIPTION, restaurant.getDescription());
        values.put(KEY_FAVOURITE, restaurant.isFavourite());
        values.put(KEY_LAT, restaurant.getLat());
        values.put(KEY_LNG, restaurant.getLng());

        db.insert(TABLE_RESTAURANT, null, values);

        db.close();
    }

    public void closeDB(){
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null && db.isOpen()){
            db.close();
        }
    }


    public RestaurantModel getRestaurant(long restaurant_id){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_RESTAURANT + " WHERE "
                + KEY_ID + " = " + restaurant_id;

        Log.e("select query", selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        RestaurantModel restaurant = new RestaurantModel();

        restaurant.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
        restaurant.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        restaurant.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
        restaurant.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
        restaurant.setFavourite(cursor.getInt(cursor.getColumnIndex(KEY_FAVOURITE)));
        restaurant.setLat(cursor.getInt(cursor.getColumnIndex(KEY_LAT)));
        restaurant.setLng(cursor.getInt(cursor.getColumnIndex(KEY_LNG)));

        return restaurant;
    }

    public ArrayList<RestaurantModel> getAllRestaurants(){
        ArrayList<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();
        String selectQuery = "SELECT * FROM " + TABLE_RESTAURANT;

        Log.e("select all query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                RestaurantModel restaurant = new RestaurantModel();
                restaurant.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                restaurant.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                restaurant.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                restaurant.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
                restaurant.setFavourite(cursor.getInt(cursor.getColumnIndex(KEY_FAVOURITE)));
                restaurant.setLat(cursor.getInt(cursor.getColumnIndex(KEY_LAT)));
                restaurant.setLng(cursor.getInt(cursor.getColumnIndex(KEY_LNG)));

                restaurants.add(restaurant);
            } while(cursor.moveToNext());
        }

        return restaurants;
    }

    public int deleteAllRestaurant(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_RESTAURANT, null, null);
    }

}
