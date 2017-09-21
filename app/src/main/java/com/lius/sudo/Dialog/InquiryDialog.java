package com.lius.sudo.Dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lius.sudo.R;
import com.lius.sudo.utilities.Util;

/**
 * Created by UsielLau on 2017/9/21 0021 9:37.
 */

public class InquiryDialog extends ColorDialogBase {

    private Context context;

    private String positiveBtnText;
    private String negativeBtnText;


    private OnClickDialogBtnListener positiveBtnListener;
    private OnClickDialogBtnListener negativeBtnListener;


    public InquiryDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    void setLogoIv(ImageView logoIv) {
        logoIv.setImageResource(R.drawable.ic_help);
    }

    @Override
    void addButtons(LinearLayout btnGroupLayout) {
        Button positiveBtn=getDefaultButton();
        positiveBtn.setText(positiveBtnText);
        positiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(positiveBtnListener!=null){
                    positiveBtnListener.onClick();
                }
            }
        });

        Button negativeBtn=getDefaultButton();
        negativeBtn.setText(negativeBtnText);
        negativeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(negativeBtnListener!=null){
                    negativeBtnListener.onClick();
                }
            }
        });

        btnGroupLayout.addView(positiveBtn);
        btnGroupLayout.addView(negativeBtn);


    }

    public void setPositiveBtnText(String positiveBtnText) {
        this.positiveBtnText = positiveBtnText;
    }

    public void setNegativeBtnText(String negativeBtnText) {
        this.negativeBtnText = negativeBtnText;
    }

    public void setPositiveBtnListener(OnClickDialogBtnListener positiveBtnListener) {
        this.positiveBtnListener = positiveBtnListener;
    }

    public void setNegativeBtnListener(OnClickDialogBtnListener negativeBtnListener) {
        this.negativeBtnListener = negativeBtnListener;
    }

    @Override
    int getDialogColor() {
        return context.getResources().getColor(R.color.colorAccent);
    }
}
