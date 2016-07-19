package com.example.ahmed.redux.Jugarr;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Ahmed on 7/9/2016.
 */
public class NoPaddingCardView extends CardView {

    public NoPaddingCardView(Context context) {
        super(context);
        init();
    }

    public NoPaddingCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NoPaddingCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Optional: Prevent pre-L from adding inner card padding
        //setPreventCornerOverlap(false);
        // Optional: make Lollipop and above add shadow padding to match pre-L padding
        //setUseCompatPadding(true);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        // FIX shadow padding
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion < android.os.Build.VERSION_CODES.LOLLIPOP){
            if (params instanceof MarginLayoutParams) {
                MarginLayoutParams layoutParams = (MarginLayoutParams) params;
                layoutParams.bottomMargin=0;
                layoutParams.topMargin=0;
                //layoutParams.leftMargin=0;
                //layoutParams.rightMargin=0;
                layoutParams.bottomMargin -= (getPaddingBottom() - getContentPaddingBottom());
                //layoutParams.leftMargin -= (getPaddingLeft() - getContentPaddingLeft());
                //layoutParams.rightMargin -= (getPaddingRight() - getContentPaddingRight());
                layoutParams.topMargin -= (getPaddingTop() - getContentPaddingTop());
            }
        } else{

        }
        super.setLayoutParams(params);
    }
}