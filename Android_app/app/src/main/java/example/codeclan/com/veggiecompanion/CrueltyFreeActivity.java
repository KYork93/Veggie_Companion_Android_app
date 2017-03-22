package example.codeclan.com.veggiecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

/**
 * Created by user on 22/03/2017.
 */

public class CrueltyFreeActivity extends AppCompatActivity{

    ListView allCompanies;
    Intent intent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
            intent = new Intent(CrueltyFreeActivity.this, RestaurantMainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.favourites_menu){
            intent = new Intent(CrueltyFreeActivity.this, FavouritesActivityPage.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
