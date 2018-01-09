package com.example.user.atmpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_LOGIN = 4;
    boolean logan = false;
    private final static int REQUEST_USERINFO = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView abc =(ListView)findViewById(R.id.aabbcc);
        String[] ABC ={"AA","BB","CC"};
        ArrayAdapter abcarrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,ABC);
        abc.setAdapter(abcarrayAdapter);
        if (!logan) {
            Intent intentlogin = new Intent(this, LoginActivity.class);//括號記得要去哪，oncreat的this前面不用點東西
            startActivityForResult(intentlogin, REQUEST_LOGIN);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentuserinfo = new Intent(MainActivity.this, UserInfoActivity.class);//MainActivity.this記得
                startActivityForResult(intentuserinfo, REQUEST_USERINFO);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//ctrl+O選擇複寫方法
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_LOGIN:
                if (resultCode == RESULT_OK) {
                    String usid = data.getStringExtra("LOGIN_USERID");
                    String pw = data.getStringExtra("LOGIN_PASSWORD");
                    Toast.makeText(this, "Login userid:  " + usid, Toast.LENGTH_SHORT).show();
                    // Log.d("RESULT", usid + "/" + pw);
                    getSharedPreferences("ATM", MODE_PRIVATE)
                            .edit()
                            .putString("USERID", usid)
                            .apply();
                } else {
                    finish();
                }break;
            case REQUEST_USERINFO:
                if(resultCode==RESULT_OK){
                    String nickname =data.getStringExtra("USERINFO_NAME");
                    String phone =data.getStringExtra("USERINFO_PHONE");
                    String age = data.getStringExtra("USERINFO_AGES");
                    //Toast.makeText(this,"暱稱:"+nickname,Toast.LENGTH_SHORT).show();
                    //Toast.makeText(this,"電話:"+phone,Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(this)
                            .setTitle("請確認")
                            .setMessage("您的暱稱:"+nickname+"\n"+"您的電話"+phone+"\n"+"您的年齡"+age)
                            .show();
                    getSharedPreferences("ATM",MODE_PRIVATE)
                            .edit()
                            .putString("AGES",age)
                            .putString("PHONE",phone)
                            .putString("NICKNAME",nickname)
                            .apply();
                }else{
                    finish();
                }break;
        }}//break要加  暫存有差



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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




