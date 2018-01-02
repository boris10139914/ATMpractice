package com.example.user.atmpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.attr.data;

public class AreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ListView area = (ListView) findViewById(R.id.area);
//        ArrayAdapter adapter1 = new ArrayAdapter(AreaActivity.this,
//                android.R.layout.simple_list_item_1, data);
//        area.setAdapter(adapter1);
    }
}
