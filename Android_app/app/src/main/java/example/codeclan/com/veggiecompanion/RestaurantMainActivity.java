package example.codeclan.com.veggiecompanion;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class RestaurantMainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    ListView restaurantList;
    Intent intent;
    Button nearMe;

    RestaurantModel ppalms = new RestaurantModel("Paradise Palms", "41 Lothian St, Edinburgh EH1 1HB", "Tropical house themed restaurant/cocktail bar with excellent vegan options,\n" +
                                                "whole restaurant is vegetarian so you can be assured there's no kitchen contamination,\n" +
                                                  "2 for 1 vegan hotdogs every Tuesday and Vegan Roasts every Sunday.", 0, 55.946272, -3.189225);
    RestaurantModel hendersons = new RestaurantModel("Henderson of Edinburgh", "94 Hanover St, EH2 1DR", "multiple locations all over Edinburgh and a Deli Shop,\n" +
                                                "organic and vegetarian with a lot of vegan options, dishes made from seasonal fare.", 0, 55.954245, -3.1981975999999577);
    RestaurantModel banns = new RestaurantModel("David Bann Restaurant", "56-58 St Mary's St, EH1 1SX", "If you fancy a proper meal out this is where to go.\n" +
                                                "David Bann's vegetarian restaurant is described as having creative and eclectic dishes.", 0, 55.949539, -3.183425);
    RestaurantModel zizzi = new RestaurantModel("Zizzi's", "42-45 Queensferry St, EH2 4RA", "Zizzi's is a national Italian chain restaurant paving the way with their vegan options.\n" +
                                                   "Somewhere you can go and there is an option for every that isn't just salad but inventive\n" +
                                                   "and exciting dishes.", 0, 55.950563, -3.208798);
    RestaurantModel kalpna = new RestaurantModel("Kalpna", "2-3 St Patrick Square, EH8 9EZ", "A family run vegetarian Indian restaurant sourcing their ingredients locally.\n" +
                                                "They have a passion for vegetarian and vegan lifestyle... Plus you can order to take out!", 0, 55.943451, -3.183052);
    RestaurantModel nova = new RestaurantModel("Novapizza Vegetarian KItchen", "42 Howe Street, EH3 6TH", "A favourite with students, and who doesn't love pizza?  This pizza place\n" +
                                                 "caters to the vegetarian and stocks vegan cheese!  It also has great gluten free options\n" +
                                                 "So Coeliacs can get on the Italian deliciousness.", 0, 55.956671, -3.202501);


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

        nearMe = (Button) findViewById(R.id.near_me_button);

        Log.d(getClass().toString(), "onCreate made");
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
        goToLocation(55.9505461978, -3.1907325704, 14);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(nova.getLat(), nova.getLng())).title(nova.getName()).snippet(nova.getAddress()));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(kalpna.getLat(), kalpna.getLng())).title(kalpna.getName()).snippet(kalpna.getAddress()));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(zizzi.getLat(), zizzi.getLng())).title(zizzi.getName()).snippet(zizzi.getAddress()));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(banns.getLat(), banns.getLng())).title(banns.getName()).snippet(banns.getAddress()));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(ppalms.getLat(), ppalms.getLng())).title(ppalms.getName()).snippet(ppalms.getAddress()));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(hendersons.getLat(), hendersons.getLng())).title(hendersons.getName()).snippet(hendersons.getAddress()));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.9505717, -3.1799576)).title("Henderson of Edinburgh, Holyrood").snippet("4 Gentle's Entry, Edinburgh, EH8 8AU"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.946661, -3.200093)).title("Zizzi's").snippet("Edinburgh Quay, Fountainbridge, Edinburgh EH3 9RU"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.946661, -3.200093)).title("Zizzi's").snippet("1 Roxburgh Ct, Edinburgh EH1 1PG"));
    }

    private void goToLocation(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mGoogleMap.moveCamera(update);
    }


    public void addToRestaurantDB(){
        RestaurantDBHandler db = new RestaurantDBHandler(this);
        db.deleteAllRestaurant();

        db.addToRestaurantTable(ppalms);
        db.addToRestaurantTable(hendersons);
        db.addToRestaurantTable(banns);
        db.addToRestaurantTable(zizzi);
        db.addToRestaurantTable(kalpna);
        db.addToRestaurantTable(nova);
    }

    public void appendRestaurantsToView(){
        addToRestaurantDB();
        RestaurantDBHandler db = new RestaurantDBHandler(this);

        ArrayList<RestaurantModel> allRestaurants = db.getAllRestaurants();

        for(RestaurantModel restaurant : allRestaurants){
            String log = "ID: " + restaurant.getId() + " Name: " + restaurant.getName() + " Address " + restaurant.getAddress();
            Log.d("Seeding: ", log);
        }

        restaurantList = (ListView) findViewById(R.id.restaurant_list);
        RestaurantAdapter adapter = new RestaurantAdapter(this, R.id.restaurant_name, allRestaurants);
        restaurantList.setAdapter(adapter);
    }

    public void onCheckedBox(){
        CheckBox favouriteCheck = (CheckBox) findViewById(R.id.rest_favourite);

        if(favouriteCheck.isChecked()){

        }
    }

    public void nearMeButtonPressed(View button){
        Log.d(getClass().toString(), "near me button pressed");

        mGoogleMap.setMyLocationEnabled(true);
        LatLng newLocation = new LatLng(location.getLatitude)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.favourites_menu){
            intent = new Intent(RestaurantMainActivity.this, FavouritesActivityPage.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
