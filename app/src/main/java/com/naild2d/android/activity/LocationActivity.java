package com.naild2d.android.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.naild2d.android.R;
import com.naild2d.android.service.LocationService;


public class LocationActivity extends NailD2DActivity {

    private String selectedCity = null;
    private String[] cityArray = null;
    private Spinner spinnerCity = null;
    private AutoCompleteTextView txtAddress = null;
    private LocationService locationService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_activty);

        locationService = new LocationService(this);
        cityArray = getResources().getStringArray(R.array.city_array);

        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
        txtAddress = (AutoCompleteTextView) findViewById(R.id.txtAddress);

        configSpinnerCity();
        configTxtAddress();
    }

    private void configSpinnerCity() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, cityArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);
        spinnerCity.setSelection(0);
        selectedCity = cityArray[0];


        spinnerCity.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selectedCity = cityArray[arg2];
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                //
            }
        });
    }

    private void configTxtAddress() {
        txtAddress.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AddressAutoCompleteTask task = new AddressAutoCompleteTask();
                task.execute(s.toString());
            }
        });
    }

    private void fillTxtAddressCompleteList(String[] address) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, address);
        txtAddress.setAdapter(adapter);
        txtAddress.setThreshold(1);
    }

    public void save(View view) {

    }

    class AddressAutoCompleteTask extends AsyncTask<String, Integer, String[]> {

        @Override
        protected String[] doInBackground(String... params) {
            return new String[]{"123"};
        }

        @Override
        protected void onPostExecute(String[] address) {
            LocationActivity.this.fillTxtAddressCompleteList(address);
        }
    }
}
