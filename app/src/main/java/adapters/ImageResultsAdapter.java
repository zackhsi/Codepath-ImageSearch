package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zackhsi.imagesearch.R;

import java.util.List;

import models.GoogleImage;

/**
 * Created by zackhsi on 2/25/15.
 */
public class ImageResultsAdapter extends ArrayAdapter<GoogleImage> {
    public ImageResultsAdapter(Context context, List<GoogleImage> images) {
        super(context, R.layout.item_image_result, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GoogleImage image = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_result, parent, false);
        }
        ImageView ivImageResult = (ImageView) convertView.findViewById(R.id.ivImageResult);
        Picasso.with(getContext()).load(image.tbUrl).into(ivImageResult);
        return convertView;
    }
}
