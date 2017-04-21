package pl.polsl.aeiimap.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.dialogs.InfoDialogFragment;
import pl.polsl.aeiimap.model.DataParser;
import pl.polsl.aeiimap.views.LightTextView;

/**
 * Created by aleksandrabienioszek on 28.02.2017.
 */
public class GroundFloorFragment extends Fragment {

    private final int GROUND_FLOOR = 0;

    @BindView(R.id.fragment_ground_room_number)
    LightTextView textView;

    @BindView(R.id.fragment_ground_relative_layout)
    RelativeLayout relativeLayout;

    @OnClick(R.id.fragment_ground_floor_503_ib)
    public void on503() {
        InfoDialogFragment.newInstance(getContext(), GROUND_FLOOR, 1).show(getActivity().getFragmentManager(),
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
        DataParser dataParser = DataParser.getInstance();
        dataParser.init(getActivity().getApplicationContext());
        return view;
    }

}
