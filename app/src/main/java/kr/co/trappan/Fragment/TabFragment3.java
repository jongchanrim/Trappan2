package kr.co.trappan.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kr.co.trappan.R;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment3 extends Fragment {

    private Thread splashThread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tabfragment3, container, false);

    }
}