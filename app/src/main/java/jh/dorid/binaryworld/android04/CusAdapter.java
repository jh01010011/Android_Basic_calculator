package jh.dorid.binaryworld.android04;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by blueb on 3/10/2017.
 */

public class CusAdapter extends ArrayAdapter<Word> {

    public CusAdapter(Activity context, ArrayList<Word> history){
        super(context,0,history);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word word=getItem(position);

        TextView txt1=(TextView) listItemView.findViewById(R.id.hist_txt1);
        txt1.setText(word.getS1());


        TextView txt2=(TextView) listItemView.findViewById(R.id.hist_txt2);
        txt2.setText(word.getS2());

        return listItemView;
    }
}
