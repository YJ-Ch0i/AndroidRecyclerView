package com.example.meloncrawling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meloncrawling.SQLite.DbOpenHelper;

public class MainActivity extends AppCompatActivity {

    public final String uId = "goo";
    public final String uPass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbOpenHelper dbOpenHelper = new DbOpenHelper(getApplicationContext(), "melonCrawling", null, 1);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                EditText id = findViewById(R.id.userId);
                EditText pass = findViewById(R.id.password);

                if(checkUser(id, pass) == true){
                    String userId = id.getText().toString();
                    String userPass = pass.getText().toString();

                    loginProcess(userId, userPass);
                }
            }
        });
    }

    /**
     * 로그인 프로세스
     * @param sendUserId    유저 아이디
     * @param sendUserPass  유저 패스워드
     */
    public void loginProcess(String sendUserId, String sendUserPass){
        Intent intent = new Intent(this, RecyclerActivity.class);

        startActivity(intent);
    }

    /**
     * 로그인 시 유효성검사
     * @param sId
     * @param sPass
     * @return
     */
    public boolean checkUser(EditText sId, EditText sPass){
        String message =  "";
        String id = sId.getText().toString();
        String pass = sPass.getText().toString();

        if(id.equals(uId) && pass.equals(uPass)){
            return true;
        }
        //비번 다를때
        else if(id.equals(uId) && !pass.equals(uPass)){
            message =  "비밀번호가 다릅니다";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            sId.setText("");
            sPass.setText("");
            sPass.requestFocus();

            return false;
        }
        else if(id.equals("") || pass.equals("")){
            message = "아이디혹은 비밀번호를 입력 해 주세요.";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            sId.requestFocus();

            return false;
        }
        //다 다를때
        else {
            message = "아이디 혹은 비밀번호가 다릅니다.";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            sId.setText("");
            sPass.setText("");
            sId.requestFocus();

            return false;
        }
    }
}
