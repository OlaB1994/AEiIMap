package pl.polsl.aeiimap.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import pl.polsl.aeiimap.R;
import timber.log.Timber;

/**
 * Created by abienioszek on 01.08.2016.
 */
public class DialogLayout extends RelativeLayout {

    Context context;
    Animation inAnimation;
    Animation outAnimation;
    DialogLayout dialogLayout;

    public DialogLayout(Context context) {
        super(context);
        init(context);
    }

    public DialogLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DialogLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DialogLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context) {
        this.context = context;
        this.dialogLayout = this;
        initAnimations();
    }

    private void initAnimations() {
        inAnimation = AnimationUtils.loadAnimation(context, R.anim.dialog_in);
        outAnimation = AnimationUtils.loadAnimation(context, R.anim.dialog_out);
    }

    public void show() {
        inAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                dialogLayout.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        this.startAnimation(inAnimation);
    }

    public void hide(final DialogFragment dialog) {
        outAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    dialogLayout.setVisibility(GONE);
                    dialog.dismiss();
                } catch (IllegalStateException e) {
                    Timber.e(e);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        this.startAnimation(outAnimation);
    }

    public void hideAndBackToMenu(final DialogFragment dialog, final Context ctx) {
        outAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    dialogLayout.setVisibility(GONE);
                    dialog.dismiss();

                } catch (IllegalStateException | NullPointerException e) {
                    Timber.e(e);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        this.startAnimation(outAnimation);
    }
}
