package pl.polsl.aeiimap.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.gestures.OnPinchListener;
import pl.polsl.aeiimap.views.ZoomableRelativeLayout;

/**
 * Created by aleksandrabienioszek on 28.02.2017.
 */
public class GroundFloorFragment extends Fragment {

    @BindView(R.id.fragment_ground_floor_zoomable_rl)
    ZoomableRelativeLayout zoomableRelativeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ground_floor, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        final ScaleGestureDetector scaleGestureDetector
                = new ScaleGestureDetector(getContext(), new OnPinchListener(zoomableRelativeLayout));
        zoomableRelativeLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
}
