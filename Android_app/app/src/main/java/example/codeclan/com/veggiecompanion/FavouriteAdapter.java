package example.codeclan.com.veggiecompanion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 21/03/2017.
 */

public class FavouriteAdapter extends ArrayAdapter {

    Context context;
    ArrayList<String> data = new ArrayList<>();

    public FavouriteAdapter(Context context, int textViewResourceId, ArrayList<String> data) {
        super(context, textViewResourceId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.favourite_entry, parent, false);

        TextView view = (TextView)convertView.findViewById(R.id.favourite_name);

        String favourite = data.get(position);
        view.setText(favourite);

        Button removeButton = (Button) convertView.findViewById(R.id.remove_favourite);

        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Removed from Favourites", Toast.LENGTH_SHORT).show();
            }
        });

        convertView.setTag(view);

        return convertView;
    }


}
