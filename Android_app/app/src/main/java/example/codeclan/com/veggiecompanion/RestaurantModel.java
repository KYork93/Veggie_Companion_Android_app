package example.codeclan.com.veggiecompanion;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.UserHandle;

/**
 * Created by user on 17/03/2017.
 */

public class RestaurantModel extends Context {

    public String name;
    public String address;
    public String description;
    public boolean favourite;
    public double lat;
    public double lng;

    public RestaurantModel(String name, String address, String description, boolean favourite, double lat, double lng) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.favourite = favourite;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public void getExternalCacheDir(){

    }

    public void sendBroadcastAsUser(Intent intent , UserHandle user){}
    public void  getApplicationContext(){}

}
