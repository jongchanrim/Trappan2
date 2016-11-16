package kr.co.trappan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Connector.Encrypter;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-10-05.
 */
public class SignupActivity extends AppCompatActivity {

    private EditText id;
    private EditText email;
    private EditText passwd;
    private EditText passConfText;
    private EditText name;
    private TextView textView;
    private Button signupbtn;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //email confirm
        id = (EditText) findViewById(R.id.input_id);
        email = (EditText) findViewById(R.id.input_email);
        passwd = (EditText) findViewById(R.id.input_passwd);
        name = (EditText) findViewById(R.id.input_name);

        passConfText = (EditText) findViewById(R.id.confirm_passwd);
        textView = (TextView) findViewById(R.id.TextVIew_PwdProblem);
        textView.setVisibility(View.GONE);
        signupbtn = (Button) findViewById(R.id.new_member_button);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        //intent

        passConfText.addTextChangedListener(passwordWatcher);


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    final String pass1 = passwd.getText().toString();
                    String enpw = Encrypter.encrypt(pass1.toString()); //비밀번호 암호화
                    RequestParams params = new RequestParams();
                    params.put("id", id.getText().toString().trim());
                    params.put("email", email.getText().toString().trim());
                    params.put("passwd", passwd.getText().toString().trim());
                    params.put("name", name.getText().toString().trim());
                    HttpClient.post("signup", params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            if (responseBody.toString().equals("success")) {
                                Intent intetn1;
                                intetn1 = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intetn1);
                                finish();
                            } else {
                                //아이디 중복 다이얼로그
                            }
                        }
                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                        }
                    });
                }
                else{
                    //동의 체크 다이얼로그
                }
            }

        });
    }



    private final TextWatcher passwordWatcher  =  new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged (Editable s){
            if(passwd.getText().toString().equals(passConfText.getText().toString())){
                textView.setText("Password correct");
            } else textView.setText("Password Do not Matched");
            // textView.setVisibility(View.GONE);
        }
    };
}
