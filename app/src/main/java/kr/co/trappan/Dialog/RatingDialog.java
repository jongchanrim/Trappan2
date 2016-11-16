package kr.co.trappan.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import kr.co.trappan.R;

/**
 * Created by SeungJun on 2016. 11. 16..
 */
public class RatingDialog extends Dialog {


    private Button btn_check;
    private Button btn_false;
    private View.OnClickListener checklistener;
    private View.OnClickListener falselistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.rating_dialog);

    }

    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
    public RatingDialog(Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
    }



}
