package example.codeclan.com.veggiecompanion;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
// * Created by user on 20/03/2017.
// */
//
public class RestaurantAdapter extends ArrayAdapter {

    Context context;
    ArrayList<RestaurantModel> data = new ArrayList<>();


    public RestaurantAdapter(Context context, int textViewResourceId, ArrayList<RestaurantModel> data){
        super(context, textViewResourceId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(R.layout.restaurant_entry, parent, false);

        TextView view = (TextView)row.findViewById(R.id.allOfIt);

        RestaurantModel restaurant = data.get(position);
        view.setText(String.valueOf(restaurant.getName()));

        return row;
    }

}
