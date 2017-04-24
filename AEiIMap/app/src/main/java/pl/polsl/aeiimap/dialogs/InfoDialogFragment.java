package pl.polsl.aeiimap.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.polsl.aeiimap.R;
import pl.polsl.aeiimap.model.DataParser;
import pl.polsl.aeiimap.model.Room;
import pl.polsl.aeiimap.views.DialogLayout;

/**
 * Created by abienioszek on 28.07.2016.
 */
public class InfoDialogFragment extends DialogFragment {

    private static final long PHOTO_CHANGE_DELAY_TIME = 5000;
    @BindView(R.id.dialog_fragment_info_layout)
    DialogLayout layout;
    @BindView(R.id.dialog_fragment_room_information)
    TextView descriptionTv;
    @BindView(R.id.dialog_fragment_info_title_tv)
    TextView titleTv;
    @BindView(R.id.dialog_fragment_info_owner_tv)
    TextView ownerTv;
    @BindView(R.id.dialog_fragment_info_ok_btn)
    Button okBtn;
    @BindView(R.id.dialog_fragment_iv)
    ImageView pictureIv;
    private Context ctx;
    private int floor;
    private String room;
    private int counter = 0;
    private int counterMax;
    private ArrayList<String> paths;

    public static InfoDialogFragment newInstance(Context ctx, int floor, int room) {
        InfoDialogFragment dialog = new InfoDialogFragment();
        dialog.ctx = ctx;
        dialog.floor = floor;
        dialog.room = room + "";
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
        Room data = dataParser.getMap().getFloors()[floor].getRoomById(room);
        descriptionTv.setText(data.getDescription());
        titleTv.setText(data.getName());
        ownerTv.setText(data.getOwner());
        okBtn.setBackground(ContextCompat.getDrawable(ctx, getDrawableId(data.getType())));
        paths = data.getImagePath();
        if (paths != null)
            counterMax = paths.size();
        if (counterMax > 0)
            handlePhotos();
    }


    private void handlePhotos() {
        updatePhoto();
        repeatTask();
    }

    private void repeatTask() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                updatePhoto();
                repeatTask();
            }
        }, PHOTO_CHANGE_DELAY_TIME);
    }

    private void updatePhoto() {
        loadPhoto(paths.get(counter));
        counter++;
        if (counter == counterMax)
            counter = 0;
    }

    private void loadPhoto(String path) {
        try {
            pictureIv.setImageBitmap(getBitmapFromAssets(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bitmap getBitmapFromAssets(String fileName) throws IOException {
        try {
            InputStream f = ctx.getAssets().open("map/" + fileName + ".jpg");
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(f, null, o);

            // The new size we want to scale to
            final int REQUIRED_SIZE = 300;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(f, null, o2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getDrawableId(int type) {
        switch (type) {
            case DataParser.TYP_AULA:
                return R.drawable.selector_button_blue;
            case DataParser.TYP_LABORATORIUM:
                return R.drawable.selector_button_green;
            case DataParser.TYP_SALA_CWICZEN:
                return R.drawable.selector_button_orange;
            case DataParser.TYP_TOALETA:
                return R.drawable.selector_button_yellow;
            case DataParser.TYP_POMIESZCZENIA_PRACOWNIKOW:
                return R.drawable.selector_button_pink;
            case DataParser.TYP_POMIESZCZENIA_UZYTKOWE:
                return R.drawable.selector_button_turquoise;
            case DataParser.TYP_UNDEFINED:
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
    public void onDismiss(DialogInterface dialog) {
        layout.hide(this);
    }
}
