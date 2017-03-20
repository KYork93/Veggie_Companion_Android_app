package example.codeclan.com.veggiecompanion;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user on 20/03/2017.
 */

public class FavouritesActivityPage extends AppCompatActivity{

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = (TextView)findViewById(R.id.favourite_item);
    }
}
