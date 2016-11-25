package kr.co.trappan.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.R;


public class StartActivity extends AppCompatActivity {

    int splashSceneNumber;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    LinearLayout splashLayout;

    Handler mHandler;

    boolean isClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        pref = getSharedPreferences("PreName", MODE_PRIVATE);
        editor = pref.edit();

        // xml 소스 참조
        splashLayout = (LinearLayout) findViewById(R.id.splashLayout);

        // 처음화면 0
        splashSceneNumber = 0;

        // 클릭 이벤트가 있었는지 확인
        isClick = true;

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (splashSceneNumber) {
                    case 0:
                        // 두번째 화면
                        splashSceneNumber = 1;
                        mHandler.sendEmptyMessage(splashSceneNumber);
                        break;

                    case 1:
                        splashSceneNumber = 2;
                        mHandler.sendEmptyMessageDelayed(splashSceneNumber, 1000);
                        break;

                    case 2:
                        // 엑티비티 종료
                        if(pref.getBoolean("autologin", false)) {

                           String id = pref.getString("id", "");
                           String pw =  pref.getString("pw", "");

                            RequestParams params = new RequestParams();
                            params.put("id", id);
                            params.put("password", pw);

                            HttpClient.post("login", params, new JsonHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                    super.onSuccess(statusCode, headers, response);

                        try {
                            if(response.get("login").equals("success")) {

                                    Intent intent = new Intent(StartActivity.this, MainActivity.class); // 다음 넘어갈 클래스 지정
                                    StartActivity.this.finish();
                                    startActivity(intent); // 다음 화면으로 넘어간다.
                            }
                            else{
                                //로그인 실패 다이얼로그
                                Intent intent = new Intent(StartActivity.this, LoginActivity.class); // 다음 넘어갈 클래스 지정
                                StartActivity.this.finish();
                                startActivity(intent); // 다음 화면으로 넘어간다.
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                                    super.onFailure(statusCode, headers, throwable, response);


                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {

                            Intent intetn1;
                            intetn1 = new Intent(StartActivity.this, LoginActivity.class);
                            startActivity(intetn1);
                            StartActivity.this.finish();
                        }
                        break;

                    case 3:
                        // 딜레이이벤트 클리기 없을경우 바로 0 이벤트로 보낸다..
                        if (isClick && splashSceneNumber == 0) {
                            splashSceneNumber = 0;
                            mHandler.sendEmptyMessage(splashSceneNumber);
                        }
                        break;
                }
            }
        };
        mHandler.sendEmptyMessageDelayed(3,1000);
    }

    public void hn_splashOnclick(View v) {

        switch (splashSceneNumber) {
            case 0:
                splashSceneNumber = 0;

                isClick = false;
                mHandler.sendEmptyMessage(splashSceneNumber);
                break;

            case 1:
                splashSceneNumber = 2;
                mHandler.sendEmptyMessage(splashSceneNumber);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_splash, menu);
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
