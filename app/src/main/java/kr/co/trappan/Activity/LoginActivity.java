package kr.co.trappan.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Connector.Encrypter;
import kr.co.trappan.R;
import kr.co.trappan.Connector.HttpClient;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class LoginActivity extends AppCompatActivity {
    /**///////////////////////////////////////////////////////////////////////////
    /**////////////////////////////////Progress Dialog////////////////////////////
    /**//**/private DialogTask task;                                        /**///
    /**//**/private ProgressDialog pd;                                      /**///
    /**//**/static final String TAG = MainActivity.class.getSimpleName();   /**///
    /**//**/static int flag = 1;                                           /**///
    /**///////////////////////////////////////////////////////////////////////////
    /**///////////////////////////////////////////////////////////////////////////
    EditText email;
    EditText password;
    Button loginButton;
    RequestParams params = new RequestParams();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = (EditText) findViewById(R.id.login_id_edittext);
        password = (EditText) findViewById(R.id.login_pw_edittext);

        pd = new ProgressDialog(this);
        pd.setTitle("");
        pd.setMessage("Loading...");
        pd.setCancelable(true);
        pd.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                task.cancel(true);
            }
        });
        task = new DialogTask(pd);
        // 로그인 버튼 클릭 시
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.execute(1);

                String enpw = Encrypter.encrypt(password.getText().toString()); //비밀번호 암호화

                RequestParams params = new RequestParams();
                params.put("email", email.getText().toString().trim());
                params.put("passwd", enpw);

                HttpClient.get("login", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Log.d(TAG, "httpOK: " + response.toString());
                        flag = 0;
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다.
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                        super.onFailure(statusCode, headers, throwable, response);
                        Log.d(TAG, "httpFail: " + response.toString());
                        flag = 0;
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

    static class DialogTask extends AsyncTask<Integer, Integer, String> {
        private ProgressDialog pdt = null;
        public DialogTask(ProgressDialog pd) {
            this.pdt = pd;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            flag=1;
            pdt.show();

        }
        @Override
        protected String doInBackground(Integer... params) {
            String result = "";
            while(flag ==1){

            }
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            Log.d(TAG, "onPostExecute : " + result);
            pdt.dismiss();


        }
    }



}

