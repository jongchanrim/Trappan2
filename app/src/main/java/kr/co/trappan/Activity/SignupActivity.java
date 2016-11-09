package kr.co.trappan.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-10-05.
 */
public class SignupActivity extends AppCompatActivity {

    /**///////////////////////////////////////////////////////////////////////////
    /**////////////////////////////////Progress Dialog////////////////////////////
    /**//**/private LoginActivity.DialogTask task;                                        /**///
    /**//**/private ProgressDialog pd;                                      /**///
    /**//**/static final String TAG = MainActivity.class.getSimpleName();   /**///
    /**//**/static int flag = 1;                                           /**///
    /**///////////////////////////////////////////////////////////////////////////
    /**///////////////////////////////////////////////////////////////////////////

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
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
