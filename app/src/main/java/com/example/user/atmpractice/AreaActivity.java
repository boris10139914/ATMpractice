package com.example.user.atmpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // private String[] areas;
    private ListView areas;
    private String[] area1;
    private String[] area2;
    private String[] area3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        areas = (ListView) findViewById(R.id.areas);
        Intent data = getIntent();
        String position = data.getStringExtra("area");

        if (position.equals("基隆市")){
            //  ArrayAdapter adapter = ArrayAdapter.createFromResource(this , R.array.area1, android.R.layout.simple_list_item_1);
            //  areas.setAdapter(adapter);
            area1 = new String[]{"中正區", "暖暖區", "八堵區"};
            ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, area1);
            areas.setAdapter(adapter);
        }else if(position.equals("台北市")){
            //   ArrayAdapter adapter = ArrayAdapter.createFromResource(this , R.array.area2, android.R.layout.simple_list_item_1);
            //   areas.setAdapter(adapter);
            area2 = new String[]{"信義區", "大安區", "士林區"};
            ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, area2);
            areas.setAdapter(adapter);
        }else if(position.equals("新北市")) {
            // ArrayAdapter adapter = ArrayAdapter.createFromResource(this , R.array.area3, android.R.layout.simple_list_item_1);
            // areas.setAdapter(adapter);
            area3 = new String[]{"永和區", "板橋區", "新莊區"};
            ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, area3);
            areas.setAdapter(adapter);
        }
        areas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        getIntent().putExtra("AREA",area1[position]);
        getIntent().putExtra("AREA",area2[position]);
        getIntent().putExtra("AREA",area3[position]);
    }
}

