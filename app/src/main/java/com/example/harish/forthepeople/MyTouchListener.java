package com.example.harish.forthepeople;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Diana on 12/7/15.
 */
public final class MyTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            //ADD DATA TO CLIPDATA?
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.VISIBLE);
            return true;
        }
        return false;
    }
}