package example.codeclan.com.veggiecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by user on 20/03/2017.
 */

public class FavouritesActivityPage extends AppCompatActivity{

    TextView textView;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = (TextView)findViewById(R.id.favourite_item);
        textView.setText("awright");
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
