package pl.polsl.aeiimap.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.dialogs.InfoDialogFragment;
import pl.polsl.aeiimap.gestures.OnPinchListener;
import pl.polsl.aeiimap.model.DataParser;
import pl.polsl.aeiimap.views.LightTextView;
import pl.polsl.aeiimap.views.ZoomableRelativeLayout;

/**
 * Created by aleksandrabienioszek on 28.02.2017.
 */
public class GroundFloorFragment extends Fragment {

    @BindView(R.id.fragment_ground_floor_zoomable_rl)
    ZoomableRelativeLayout zoomableRelativeLayout;

    @BindView(R.id.fragment_ground_room_number)
    LightTextView textView;

    @BindView(R.id.fragment_ground_relative_layout)
    RelativeLayout relativeLayout;

    @OnClick(R.id.fragment_ground_floor_503_ib)
    public void on503(){
    InfoDialogFragment.newInstance(getContext()).show(getActivity().getFragmentManager(),
            InfoDialogFragment.class.getName());
    }

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

        // TODO dzięki temu mozna przesuwać ekranem ale przestał działać przez to zoom :(
        zoomableRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:

                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });


        //TODO testy DataParsera działa i wyswietla dane z jsona takze chyba jest okej :) za pierwszym razem trzeba strzlić init z contextem potem już nie.
        DataParser dataParser = DataParser.getInstance();
        dataParser.init(getActivity().getApplicationContext());
        textView.setText(dataParser.getMap().getFloors()[0].getRooms().get(8).getName());

    }

}
