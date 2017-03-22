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

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "entry_name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_FAVOURITE = "favourite";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LNG = "lng";


    //restaurant create
    private static final String CREATE_TABLE_RESTAURANT = "CREATE TABLE "
            + TABLE_RESTAURANT + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " VARCHAR," + KEY_ADDRESS + " VARCHAR," + KEY_FAVOURITE + " INT,"
            + KEY_DESCRIPTION + " TEXT," + KEY_LAT + " INT," + KEY_LNG + " INT" + ")";


    public RestaurantDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RESTAURANT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT);

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

    public RestaurantModel getRestaurant(String restaurant_name){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_RESTAURANT + " WHERE "
                + KEY_NAME + " = " + restaurant_name;

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
