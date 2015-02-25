package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import models.GoogleImage;

/**
 * Created by zackhsi on 2/25/15.
 */
public class ImageResultsAdapter extends ArrayAdapter<GoogleImage> {
    public ImageResultsAdapter(Context context, List<GoogleImage> images) {
        super(context, android.R.layout.simple_list_item_1, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
