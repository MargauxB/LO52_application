package com.example.margaux.test03blocnote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by margaux on 21/12/2016.
 */
public class Slider extends LinearLayout {
    public Slider(Context context){
        super(context);
    };

    public Slider(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    public Slider(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }
    public Slider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context,attrs,defStyleAttr,defStyleRes);
    }


    public boolean toogle(){
        return true;
    };
}
