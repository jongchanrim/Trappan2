package kr.co.trappan.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import kr.co.trappan.R;
import kr.co.trappan.Connector.HttpClient;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class LoginActivity extends AppCompatActivity {

    RequestParams params = new RequestParams();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // 로그인 버튼 클릭 시
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpClient.post("login", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        JSONObject obj = response;
                        try {
                            String login = obj.getString("Test");
                            if(login.equals("Test")){
                                //암호화 들어가야됨
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class); // 다음 넘어갈 클래스 지정
                                startActivity(intent); // 다음 화면으로 넘어간다.
                            }
                            else if(login.equals("fail")){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
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

