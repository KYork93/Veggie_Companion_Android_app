package example.codeclan.com.veggiecompanion;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.company_entry, parent, false);

        TextView id = (TextView) convertView.findViewById(R.id.company_id);
        ImageView image = (ImageView) convertView.findViewById(R.id.company_image);
        TextView name = (TextView) convertView.findViewById(R.id.company_name);
        TextView type = (TextView) convertView.findViewById(R.id.company_type);
        TextView description = (TextView) convertView.findViewById(R.id.company_description);

        CrueltyFreeModel company = data.get(position);
        id.setText(String.valueOf(company.getId()));
        image.setImageResource(company.getImage());
        name.setText(String.valueOf(company.getName()));
        type.setText(String.valueOf(company.getType()));
        description.setText(String.valueOf(company.getDescription()));

        return convertView;
    }
}
