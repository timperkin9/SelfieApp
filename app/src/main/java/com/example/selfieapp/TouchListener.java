package com.example.selfieapp;

//import android.support.v4.view.GestureDetectorCompat;
import androidx.core.view.GestureDetectorCompat;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
//https://stackoverflow.com/questions/13095494/how-to-detect-swipe-direction-between-left-right-and-up-down


public class TouchListener implements View.OnTouchListener {
    MainActivity mainActivity;
    GestureDetectorCompat gestureDetectorCompat;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    public TouchListener(MainActivity ma) {
        this.mainActivity = ma;
        gestureDetectorCompat = new GestureDetectorCompat(this.mainActivity, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gestureDetectorCompat.onTouchEvent(motionEvent);
        int maskedAction = motionEvent.getActionMasked();
        switch (maskedAction) {
            case MotionEvent.ACTION_POINTER_DOWN:
                for (int i = 0, size = motionEvent.getPointerCount(); i < size; i++) {
                    int id = motionEvent.getPointerId(i);

                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;

/*
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                for(int i= 0, size = motionEvent.getPointerCount(); i< size; i++){
                    int id = motionEvent.getPointerId(i);
                    mainActivity.addPath(id, motionEvent.getX(i), motionEvent.getY(i));
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for(int i= 0, size = motionEvent.getPointerCount(); i< size; i++){
                    int id = motionEvent.getPointerId(i);
                    mainActivity.updatePath(id, motionEvent.getX(i), motionEvent.getY(i));
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                for(int i= 0, size = motionEvent.getPointerCount(); i< size; i++){
                    int id = motionEvent.getPointerId(i);
                    mainActivity.removePath(id);
                }
                break;
        }

 */

        }
        return true;
    }


    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            Log.i("test", "Here");
            try {
                if (Math.abs(e1.getX() - e2.getX()) > SWIPE_MAX_OFF_PATH){
                    return false;
                }
                // right to left swipe
                if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    mainActivity.onDownSwipe();
                }
                // left to right swipe
                else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    mainActivity.onUpSwipe();
                }
            } catch (Exception e) {

            }
            return false;
        }
    }
}