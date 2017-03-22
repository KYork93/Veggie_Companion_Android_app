package example.codeclan.com.veggiecompanion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by user on 22/03/2017.
 */

public class CrueltyFreeAdapter extends ArrayAdapter {

    Context context;
    ArrayList<CrueltyFreeModel> data = new ArrayList<>();

    public CrueltyFreeAdapter(Context context, int textViewResourceId, ArrayList<CrueltyFreeModel> data){
        super(context, textViewResourceId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
