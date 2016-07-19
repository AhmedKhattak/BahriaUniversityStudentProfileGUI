package com.example.ahmed.redux.Jugarr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Ahmed on 7/9/2016.
 */
public class JugarFrameLayout extends FrameLayout {

    public JugarFrameLayout(Context context) {
        super(context);
        init();
    }

    public JugarFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public JugarFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Optional: Prevent pre-L from adding inner card padding
        //setPreventCornerOverlap(false);
        // Optional: make Lollipop and above add shadow padding to match pre-L padding
        // setUseCompatPadding(true);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        // FIX shadow padding
        if (params instanceof MarginLayoutParams) {
            MarginLayoutParams layoutParams = (MarginLayoutParams) params;
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin= 0;
            layoutParams.bottomMargin -= (getPaddingBottom());
            layoutParams.topMargin -= (getPaddingTop());
        }
        super.setLayoutParams(params);
    }
}
