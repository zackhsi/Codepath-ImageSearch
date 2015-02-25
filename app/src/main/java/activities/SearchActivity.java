package activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.zackhsi.imagesearch.R;

import java.util.ArrayList;

import adapters.ImageResultsAdapter;
import models.GoogleImage;
import models.ImageResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import services.ImageService;


public class SearchActivity extends ActionBarActivity {
    EditText etQuery;
    Button btnSearch;
    GridView gvResults;
    ImageService api;
    ArrayList<GoogleImage> images;
    ImageResultsAdapter aImageResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initMemberVars();
        setupViews();
        setupApi();
        setupHandlers();
    }

    private void initMemberVars() {
        images = new ArrayList<>();
        aImageResults = new ImageResultsAdapter(this, images);
    }

    private void setupViews() {
        etQuery = (EditText) findViewById(R.id.etQuery);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        gvResults = (GridView) findViewById(R.id.gvResults);
        gvResults.setAdapter(aImageResults);
    }

    private void setupApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://ajax.googleapis.com/ajax/services/search")
                .build();

        api = restAdapter.create(ImageService.class);
    }

    private void setupHandlers() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api.getImages("1.0", etQuery.getText().toString(), new Callback<ImageResponse>() {
                    @Override
                    public void success(ImageResponse imageResponse, Response response) {
                        images.addAll(imageResponse.responseData.results);
                        aImageResults.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.i("DEBUG", "failure");
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
