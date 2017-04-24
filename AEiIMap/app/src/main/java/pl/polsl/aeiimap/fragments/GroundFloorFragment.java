package pl.polsl.aeiimap.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.dialogs.InfoDialogFragment;
import pl.polsl.aeiimap.views.ZoomableRelativeLayout;

/**
 * Created by aleksandrabienioszek on 28.02.2017.
 */
public class GroundFloorFragment extends Fragment {

    private final int GROUND_FLOOR = 0;

    @BindView(R.id.fragment_ground_floor_main_ll)
    ZoomableRelativeLayout zoomableRelativeLayout;

    @OnClick(R.id.fragment_ground_floor_1)
    public void on1() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_2)
    public void on2() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 2).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_3)
    public void on3() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 3).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_4)
    public void on4() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 4).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_5)
    public void on5() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 5).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_6)
    public void on6() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 6).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_7)
    public void on7() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 7).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_8)
    public void on8() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 8).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_9)
    public void on9() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 9).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_10)
    public void on10() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 10).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_12)
    public void on12() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 12).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_13)
    public void on13() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 13).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_14)
    public void on14() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 14).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_15)
    public void on15() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 15).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_16)
    public void on16() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 16).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_16a)
    public void on16a() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, "16a").show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_16b)
    public void on16b() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, "16b").show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_19)
    public void on19() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 19).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_20)
    public void on20() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 20).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_21)
    public void on21() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 21).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_22)
    public void on22() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 22).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_23)
    public void on23() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 23).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_24)
    public void on24() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 24).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_25)
    public void on25() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 26).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }


    @OnClick(R.id.fragment_ground_floor_26)
    public void on26() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 25).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }


    @OnClick(R.id.fragment_ground_floor_bufet)
    public void onBufet() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1009).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_skrypty)
    public void onSkrypty() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1012).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_drukarnia)
    public void onDrukarnia() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1011).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_szatnia)
    public void onSzatnia() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1010).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }


    @OnClick(R.id.fragment_ground_floor_aula_a)
    public void onAulaA() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1001).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_aula_b)
    public void onAulaB() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1002).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @OnClick(R.id.fragment_ground_floor_aula_c)
    public void onAulaC() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1003).show(getActivity().getFragmentManager(),
                InfoDialogFragment.class.getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_ground_floor, container, false);
        ButterKnife.bind(this, view);
        //initView();
        zoomableRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                zoomableRelativeLayout.init(getContext());
                return false;
            }
        });
        return view;
    }

}
