package com.example.user.atmpractice;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText eduserid;
    private EditText edpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String userid = getSharedPreferences("ATM", MODE_PRIVATE)
                .getString("USERID", "");
        eduserid = (EditText)findViewById(R.id.ed_userid);
        edpassword = (EditText)findViewById(R.id.ed_password);
        eduserid.setText(userid);
    }

    public void login(View view) {
        String usid = eduserid.getText().toString();
        String passwd = edpassword.getText().toString();
        if ("boris10139914".equals(usid) && "boris5566".equals(passwd)) {
            Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
            getIntent().putExtra("LOGIN_USERID", usid);
            getIntent().putExtra("LOGIN_PASSWORD", passwd);
            setResult(RESULT_OK, getIntent());
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("登入失敗" + "")//要加空白字串 不然會執行崩潰
                    .show();
        }

    }

}

