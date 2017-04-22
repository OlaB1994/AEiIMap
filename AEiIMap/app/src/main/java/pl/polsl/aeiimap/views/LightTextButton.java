package pl.polsl.aeiimap.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by abienioszek on 22.07.2016.
 */
public class LightTextButton extends android.support.v7.widget.AppCompatButton {

    public LightTextButton(Context context, AttributeSet attrs) {
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
