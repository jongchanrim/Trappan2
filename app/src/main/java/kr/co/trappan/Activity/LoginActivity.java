package kr.co.trappan.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Connector.Encrypter;
import kr.co.trappan.R;
import kr.co.trappan.Connector.HttpClient;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class LoginActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();
    static int flag = 1;
    ProgressDialog pd;
    EditText id;
    EditText password;
    Button loginButton;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String enpw;
    RequestParams params = new RequestParams();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pd = new ProgressDialog(LoginActivity.this);
        id = (EditText) findViewById(R.id.login_id_edittext);
        password = (EditText) findViewById(R.id.login_pw_edittext);

        pref = getSharedPreferences("PreName", MODE_PRIVATE);
        editor = pref.edit();



        // 로그인 버튼 클릭 시
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                enpw = Encrypter.encrypt(password.getText().toString()); //비밀번호 암호화
                RequestParams params = new RequestParams();
                params.put("id", id.getText().toString().trim());
                params.put("pw", enpw);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                HttpClient.post("test", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Log.d(TAG, "httpOK: " + response.toString());
//                        try {
//                            if(response.get("login").equals("success")) {
                                //자동 로그인하기 위한 데이터 저장
                                editor.putString("id", id.getText().toString());
                                editor.putString("pw", enpw);
                                editor.putBoolean("autologin", true);
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class); // 다음 넘어갈 클래스 지정
                                pd.dismiss();
                                startActivity(intent); // 다음 화면으로 넘어간다.
//                            }
//                            else{
//                                //로그인 실패 다이얼로그
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                        super.onFailure(statusCode, headers, throwable, response);
                        Log.d(TAG, "httpFail: " + response.toString());

                    }
                });
            }
        });
        // 회원가입 버튼 클릭 시
        TextView signupButton = (TextView) findViewById(R.id.login_link_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(
                        LoginActivity.this, SignupActivity.class);
                        startActivity(intent);


                //회원가입 버튼 클릭 시
            }
        });
    }


}

