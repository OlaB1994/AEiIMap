package pl.polsl.aeiimap.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.model.DataParser;
import pl.polsl.aeiimap.model.Room;
import pl.polsl.aeiimap.views.DialogLayout;
import pl.polsl.aeiimap.views.LightTextView;

/**
 * Created by abienioszek on 28.07.2016.
 */
public class InfoDialogFragment extends DialogFragment {

    private Context ctx;
    private int floor;
    private String room;

    @BindView(R.id.dialog_fragment_info_layout)
    DialogLayout layout;

    @BindView(R.id.dialog_fragment_room_information)
    LightTextView descriptionTv;
    @BindView(R.id.dialog_fragment_info_title_tv)
    TextView titleTv;
    @BindView(R.id.dialog_fragment_info_owner_tv)
    TextView ownerTv;
    @BindView(R.id.dialog_fragment_info_ok_btn)
    Button okBtn;

    public static InfoDialogFragment newInstance(Context ctx, int floor, int room) {
        InfoDialogFragment dialog = new InfoDialogFragment();
        dialog.ctx = ctx;
        dialog.floor = floor;
        dialog.room = room+"";
        dialog.setStyle(STYLE_NO_FRAME, 0);
        return dialog;
    }

    public static InfoDialogFragment newInstance(Context ctx, int floor, String room) {
        InfoDialogFragment dialog = new InfoDialogFragment();
        dialog.ctx = ctx;
        dialog.floor = floor;
        dialog.room = room;
        dialog.setStyle(STYLE_NO_FRAME, 0);
        return dialog;
    }

    @OnClick(R.id.dialog_fragment_info_ok_btn)
    public void onOK() {
        onDismiss(getDialog());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_ok,
                container, false);
        ButterKnife.bind(this, view);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);
        setupView();
        layout.show();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    private void setupView() {
        DataParser dataParser = DataParser.getInstance();
        Room data =dataParser.getMap().getFloors()[floor].getRoomById(room);
        descriptionTv.setText(data.getDescription());
        titleTv.setText(data.getName() + " - " + data.getId());
        ownerTv.setText(data.getOwner());
        okBtn.setBackground(ContextCompat.getDrawable(ctx, getDrawableId(data.getType())));
    }

    private int getDrawableId(int type) {
        switch (type){
            case 1:
                return R.drawable.selector_button_blue;
            case 2:
                return R.drawable.selector_button_green;
            case 3:
                return R.drawable.selector_button_orange;
            case 4:
                return R.drawable.selector_button_yellow;
            case 5:
                return R.drawable.selector_button_pink;
            case 6:
                return R.drawable.selector_button_turquoise;
        }
        return R.drawable.selector_button_purple;
    }

    @Override
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        layout.hide(this);
    }
}
