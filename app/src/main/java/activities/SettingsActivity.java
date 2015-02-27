package activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.zackhsi.imagesearch.R;

import models.Settings;


public class SettingsActivity extends ActionBarActivity {

    private Settings settings;

    private Spinner sSize;
    private Spinner sColor;
    private Spinner sType;
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
        sSize = (Spinner) findViewById(R.id.sSize);
        sColor = (Spinner) findViewById(R.id.sColor);
        sType = (Spinner) findViewById(R.id.sType);
        etSite = (EditText) findViewById(R.id.etSite);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        setSpinnerToValue(sSize, settings.size);
        setSpinnerToValue(sColor, settings.color);
        setSpinnerToValue(sType, settings.type);
        etSite.setText(settings.site);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.size = sSize.getSelectedItemPosition() > 0 ? sSize.getSelectedItem().toString() : null;
                settings.color = sColor.getSelectedItemPosition() > 0 ? sColor.getSelectedItem().toString() : null;
                settings.type = sType.getSelectedItemPosition() > 0 ? sType.getSelectedItem().toString() : null;
                settings.site = etSite.getText().toString();

                Intent i = new Intent();
                i.putExtra("settings", settings);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

    private void setSpinnerToValue(Spinner spinner, String value) {
        int index = 0;
        SpinnerAdapter adapter = spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).equals(value)) {
                index = i;
                break; // terminate loop
            }
        }
        spinner.setSelection(index);
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
