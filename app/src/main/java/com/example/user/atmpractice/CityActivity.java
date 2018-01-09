package com.example.user.atmpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final static int REQUEST_LOGIN = 102;
    private static final String TAG = CityActivity.class.getSimpleName();
    private String[] city2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ListView city = (ListView) findViewById(R.id.city2);
        city2 = new String[]{"基隆市", "台北市", "新北市"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, city2);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Log.d(TAG, "onItemClick : " + position + "/" + city2[position]);
        Intent a = new Intent(this, AreaActivity.class);//
        a.putExtra("area", city2[position]);
        // setResult(RESULT_OK, getIntent());
        startActivityForResult(a, REQUEST_LOGIN);

    }
}