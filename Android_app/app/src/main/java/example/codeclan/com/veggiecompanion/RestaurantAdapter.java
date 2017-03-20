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
    int layoutResourceId;
    ArrayList<RestaurantModel> data = null;


    public RestaurantAdapter(Context context, int layoutResourceId, ArrayList<RestaurantModel> data){
        super(context, layoutResourceId, data);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        RestaurantHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RestaurantHolder();
            holder.allOfIt = (TextView) row.findViewById(R.id.allOfIt);

            row.setTag(holder);
        } else {
            holder = (RestaurantHolder)row.getTag();
        }

        RestaurantModel restaurant = data.get(position);
        holder.allOfIt.setText(restaurant.name);

        return row;
    }


    static class RestaurantHolder {
        TextView allOfIt;
    }
}
