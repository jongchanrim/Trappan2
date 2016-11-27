package kr.co.trappan.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Connector.Encrypter;
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.R;
import kr.co.trappan.Connector.HttpClient;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class LoginActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();
    static int flag = 1;
    private CustomProgressDialog pd;
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

        pd = new CustomProgressDialog(LoginActivity.this);
        pd .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


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
                params.put("password", enpw);
                    HttpClient.post("login", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);
                            try {
                                String login = response.getString("login");
                                if (login.equals("success")) {
                                    //자동 로그인하기 위한 데이터 저장
                                    editor.putString("id", id.getText().toString());
                                    editor.putString("pw", enpw);
                                    editor.putBoolean("autologin", true);
                                    editor.commit();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("user_id", id.getText().toString());
                                    startActivity(intent); // 다음 화면으로 넘어간다.
                                    pd.dismiss();
                                } else {
                                    Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_LONG).show();
                                    pd.dismiss();
                                    //로그인 실패 다이얼로그
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                pd.dismiss();

                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                            super.onFailure(statusCode, headers, throwable, response);
                            pd.dismiss();

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

