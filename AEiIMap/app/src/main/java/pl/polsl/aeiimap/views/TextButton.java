package pl.polsl.aeiimap.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by abienioszek on 22.07.2016.
 */
public class TextButton extends Button {

    public TextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setDrawingCacheEnabled(false);
    }

    private void init(Context context) {
        setTypeface(TypeFace.get(context, "fonts/DimboRegular.ttf"));
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
    }

}
