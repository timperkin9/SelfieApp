package com.example.selfieapp;

//import android.support.v4.view.GestureDetectorCompat;
import androidx.core.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class TouchListener implements View.OnTouchListener {
    MainActivity mainActivity;
    GestureDetectorCompat gestureDetectorCompat;

    public TouchListener(MainActivity ma) {
        this.mainActivity = ma;
        gestureDetectorCompat = new GestureDetectorCompat(this.mainActivity, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gestureDetectorCompat.onTouchEvent(motionEvent);
        int maskedAction = motionEvent.getActionMasked();
        switch(maskedAction){
            case MotionEvent.ACTION_POINTER_DOWN:
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
        return true;
    }


    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            mainActivity.onDoubleTap();
            return super.onDoubleTap(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            mainActivity.onLongPress();
            super.onLongPress(e);
        }
    }
}