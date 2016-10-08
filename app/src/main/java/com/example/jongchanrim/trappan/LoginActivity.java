package com.example.jongchanrim.trappan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by thfad_000 on 2016-10-04.
 */
public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // 로그인 버튼 클릭 시
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        LoginActivity.this, MainActivity.class); // 다음 넘어갈 클래스 지정

                startActivity(intent); // 다음 화면으로 넘어간다.
            }
        });

        // 회원가입 버튼 클릭 시
        Button signupButton = (Button) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                Intent intent = new Intent(
                        LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }

        });

        //회원가입 버튼 클릭 시
    }
}
