package activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zackhsi.imagesearch.R;

import models.Settings;


public class SettingsActivity extends ActionBarActivity {

    private Settings settings;

    private EditText etSize;
    private EditText etColor;
    private EditText etType;
    private EditText etSite;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = (Settings) getIntent().getSerializableExtra("settings");
        setupViews();
    }

    private void setupViews() {
        etSize = (EditText) findViewById(R.id.etSize);
        etColor = (EditText) findViewById(R.id.etColor);
        etType = (EditText) findViewById(R.id.etType);
        etSite = (EditText) findViewById(R.id.etSite);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        etSize.setText(settings.size);
        etColor.setText(settings.color);
        etType.setText(settings.type);
        etSite.setText(settings.site);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.size = etSize.getText().toString();
                settings.color = etColor.getText().toString();
                settings.type = etType.getText().toString();
                settings.site = etSite.getText().toString();

                Intent i = new Intent();
                i.putExtra("settings", settings);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
