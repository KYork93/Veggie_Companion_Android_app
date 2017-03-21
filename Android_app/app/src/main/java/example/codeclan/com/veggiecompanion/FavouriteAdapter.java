package example.codeclan.com.veggiecompanion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 21/03/2017.
 */

public class FavouriteAdapter extends ArrayAdapter {

    Context context;
    ArrayList<FavouriteModel> data = new ArrayList<>();

    public FavouriteAdapter(Context context, int textViewResourceId, ArrayList<FavouriteModel> data) {
        super(context, textViewResourceId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(R.layout.favourite_entry, parent, false);

        TextView view = (TextView)row.findViewById(R.id.favourite_name);
        TextView favDesc = (TextView)row.findViewById(R.id.favourite_description);

        FavouriteModel favourite = data.get(position);
        view.setText(String.valueOf(favourite.getName()));
        favDesc.setText(favourite.getDescription());

        return row;
    }


}
