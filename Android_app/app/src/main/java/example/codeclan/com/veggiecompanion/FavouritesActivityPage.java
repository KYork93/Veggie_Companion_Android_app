package example.codeclan.com.veggiecompanion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/03/2017.
 */

public class FavouritesActivityPage extends AppCompatActivity{

    Intent intent;
    ListView favouriteList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.showFavouriteRestaurants();
    }

    public void showFavouriteRestaurants(){
        SharedPreferences sharedPref = getSharedPreferences("restaurantInfo", Context.MODE_PRIVATE);

        ArrayList<String> sharedList = new ArrayList<>();

        int prefSize = sharedPref.getInt("SIZE", 0);
        int count = prefSize;

        for(int i = 0; i < count; i++){
            sharedList.add(sharedPref.getString("restName", ""));
        }

        favouriteList = (ListView) findViewById(R.id.favourite_item);
        FavouriteAdapter adapter = new FavouriteAdapter(this, R.id.favourite_name, sharedList);
        favouriteList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.home){
            intent = new Intent(FavouritesActivityPage.this, RestaurantMainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
