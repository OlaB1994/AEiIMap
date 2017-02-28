package pl.polsl.aeiimap.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.views.DialogLayout;

/**
 * Created by abienioszek on 28.07.2016.
 */
public class InfoDialogFragment extends DialogFragment {

    Context ctx;

    @BindView(R.id.dialog_fragment_info_layout)
    DialogLayout layout;

    public static InfoDialogFragment newInstance(Context ctx) {
        InfoDialogFragment dialog = new InfoDialogFragment();
        dialog.ctx = ctx;
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