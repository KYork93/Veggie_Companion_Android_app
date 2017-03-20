package example.codeclan.com.veggiecompanion;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RestaurantMainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    ListView restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(googleServicesAvailable()){
            Toast.makeText(this, "Connected.", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_restaurants_main);
            initMap();
        } else {
            //No google maps layout
        }

        this.addToRestaurantDB();
    }

    private void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);

        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        } else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Cannot connect to Google Play Services", Toast.LENGTH_LONG).show();
        }

        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        goToLocation(55.95029,-3.205775, 14);
    }

    private void goToLocation(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mGoogleMap.moveCamera(update);
    }


    public void addToRestaurantDB(){
        DBHandler db = new DBHandler(this);
        db.deleteAllRestaurant();

        db.addToRestaurantTable(new RestaurantModel("Paradise Palms", "41 Lothian St, Edinburgh EH1 1HB", "Tropical house themed restaurant/cocktail bar with excellent vegan options,\n" +
                "whole restaurant is vegetarian so you can be assured there's no kitchen contamination,\n" +
                "2 for 1 vegan hotdogs every Tuesday and Vegan Roasts every Sunday.", 0, 55.946272, -3.189225));

        ArrayList<RestaurantModel> allRestaurants = db.getAllRestaurants();

        for(RestaurantModel restaurant : allRestaurants){
            String log = "ID: " + restaurant.getId() + " Name: " + restaurant.getName() + " Address " + restaurant.getAddress();
            Log.d("Seeding: ", log);
        }

        restaurantList = (ListView) findViewById(R.id.restaurant_list);
        RestaurantAdapter adapter = new RestaurantAdapter(this, R.id.restaurant_name, allRestaurants);
        restaurantList.setAdapter(adapter);
    }

}
