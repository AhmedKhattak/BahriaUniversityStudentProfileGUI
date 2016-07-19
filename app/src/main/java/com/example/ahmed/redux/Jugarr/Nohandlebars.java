package com.example.ahmed.redux.Jugarr;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by KhattaK on 7/4/2016.
 */
public class Nohandlebars extends CardView {

    public Nohandlebars(Context context) {
        super(context);
        init();
    }

    public Nohandlebars(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Nohandlebars(Context context, AttributeSet attrs, int defStyleAttr) {
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
            layoutParams.bottomMargin -= (getPaddingBottom() - getContentPaddingBottom());
            layoutParams.topMargin -= (getPaddingTop() - getContentPaddingTop());
        }

        super.setLayoutParams(params);
    }



}
