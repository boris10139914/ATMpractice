package com.example.user.atmpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class UserInfoActivity extends AppCompatActivity {

    private EditText ednickname;
    private EditText edphone;
    private Spinner spages;
    private String ages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ednickname = (EditText)findViewById(R.id.ed_nickname);
        edphone = (EditText)findViewById(R.id.ed_phone);
        spages = (Spinner)findViewById(R.id.sp_ages);
        ArrayAdapter spagesAdapter = ArrayAdapter.createFromResource(this, R.array.ages, android.R.layout.simple_list_item_1);
        spages.setAdapter(spagesAdapter);
        spages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = spages.getSelectedItem().toString();
                /*if ("16-25".equals(text)) {
                    String a1 = getSharedPreferences("ATM", MODE_PRIVATE)
                            .getString("AGES", "");
                    ages = text;
                    String a2[] = {ages};
                    ArrayAdapter a2adapter = new ArrayAdapter(UserInfoActivity.this, android.R.layout.simple_list_item_1, a2);
                    spages.setAdapter(a2adapter);
                }
                if ("26-35".equals(text)) {
                    String a1 = getSharedPreferences("ATM", MODE_PRIVATE)
                            .getString("AGES", "");
                    ages = text;
                    String a2[] = {ages};
                    ArrayAdapter a2adapter = new ArrayAdapter(UserInfoActivity.this, android.R.layout.simple_list_item_1, a2);
                    spages.setAdapter(a2adapter);
                }
                if ("36-45".equals(text)) {
                    String a1 = getSharedPreferences("ATM", MODE_PRIVATE)
                            .getString("AGES", "");
                    ages = text;
                    String a2[] = {ages};
                    ArrayAdapter a2adapter = new ArrayAdapter(UserInfoActivity.this, android.R.layout.simple_list_item_1, a2);
                    spages.setAdapter(a2adapter);
                }
                if ("46-55".equals(text)) {
                    String a1 = getSharedPreferences("ATM", MODE_PRIVATE)
                            .getString("AGES", "");
                    ages = text;
                    String a2[] = {ages};
                    ArrayAdapter a2adapter = new ArrayAdapter(UserInfoActivity.this, android.R.layout.simple_list_item_1, a2);
                    spages.setAdapter(a2adapter);

                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        String nickname = getSharedPreferences("ATM", MODE_PRIVATE)
                .getString("NICKNAME", "");
        String phone = getSharedPreferences("ATM", MODE_PRIVATE)
                .getString("PHONE", "");
        ednickname.setText(nickname);
        edphone.setText(phone);
    }

    public void ok(View view) {
        String age = ages;
        String name = ednickname.getText().toString();
        String phone = edphone.getText().toString();
        getIntent().putExtra("USERINFO_AGES", age);
        getIntent().putExtra("USERINFO_NAME", name);
        getIntent().putExtra("USERINFO_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();

    }

    public void adress(View view) {
        Intent cityintent = new Intent(this, CityActivity.class);
        startActivity(cityintent);
    }

}


