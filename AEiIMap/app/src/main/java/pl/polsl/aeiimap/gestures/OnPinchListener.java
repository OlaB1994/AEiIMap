package pl.polsl.aeiimap.gestures;

import android.view.ScaleGestureDetector;

import pl.polsl.aeiimap.views.ZoomableLinearLayout;

/**
 * Created by aleksandrabienioszek on 28.02.2017.
 */

public class OnPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    private final ZoomableLinearLayout zoomableRelativeLayout;
    float startingSpan;
    float endSpan;
    float startFocusX;
    float startFocusY;

    public OnPinchListener(ZoomableLinearLayout relativeLayout){
        this.zoomableRelativeLayout = relativeLayout;
    }

    public boolean onScaleBegin(ScaleGestureDetector detector) {
        startingSpan = detector.getCurrentSpan();
        startFocusX = detector.getFocusX();
        startFocusY = detector.getFocusY();
        return true;
    }



}
