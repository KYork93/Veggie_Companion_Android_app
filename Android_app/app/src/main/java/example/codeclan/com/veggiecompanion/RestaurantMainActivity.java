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
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RestaurantMainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    ListView restaurantList;
    RestaurantModel ppalms = new RestaurantModel("Paradise Palms", "41 Lothian St, Edinburgh EH1 1HB", "Tropical house themed restaurant/cocktail bar with excellent vegan options,\n" +
            "whole restaurant is vegetarian so you can be assured there's no kitchen contamination,\n" +
            "2 for 1 vegan hotdogs every Tuesday and Vegan Roasts every Sunday.", 0, 55.946272, -3.189225);
    RestaurantModel hendersons = new RestaurantModel("Henderson of Edinburgh", "94 Hanover St, EH2 1DR", "multiple locations all over Edinburgh and a Deli Shop,\n" +
                                                "organic and vegetarian with a lot of vegan options, dishes made from seasonal fare.", 0, 55.954245, -3.1981975999999577);

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

        this.appendRestaurantsToView();
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
        goToLocation(55.95029, -3.205775, 14);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(ppalms.getLat(), ppalms.getLng())));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(hendersons.getLat(), hendersons.getLng())));

    }

    private void goToLocation(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mGoogleMap.moveCamera(update);
    }


    public void addToRestaurantDB(){
        DBHandler db = new DBHandler(this);
        db.deleteAllRestaurant();

        db.addToRestaurantTable(ppalms);
        db.addToRestaurantTable(hendersons);
        db.addToRestaurantTable(new RestaurantModel("David Bann Restaurant", "56-58 St Mary's St, EH1 1SX", "If you fancy a proper meal out this is where to go.\n" +
                "David Bann's vegetarian restaurant is described as having creative and eclectic dishes.", 0, 55.949539, -3.183425));
        db.addToRestaurantTable(new RestaurantModel("Zizzi's", "42-45 Queensferry St, EH2 4RA", "Zizzi's is a national Italian chain restaurant paving the way with their vegan options.\n" +
                "Somewhere you can go and there is an option for every that isn't just salad but inventive\n" +
                "and exciting dishes.", 0, 55.950563, -3.208798));
        db.addToRestaurantTable(new RestaurantModel("Kalpna", "2-3 St Patrick Square, EH8 9EZ", "A family run vegetarian Indian restaurant sourcing their ingredients locally.\n" +
                "They have a passion for vegetarian and vegan lifestyle... Plus you can order to take out!", 0, 55.943451, -3.183052));
        db.addToRestaurantTable(new RestaurantModel("Novapizza Vegetarian KItchen", "42 Howe Street, EH3 6TH", "A favourite with students, and who doesn't love pizza?  This pizza place\n" +
                "caters to the vegetarian and stocks vegan cheese!  It also has great gluten free options\n" +
                "So Coeliacs can get on the Italian deliciousness.", 0, 55.956671, -3.202501));

    }

    public void appendRestaurantsToView(){
        addToRestaurantDB();

        DBHandler db = new DBHandler(this);

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
