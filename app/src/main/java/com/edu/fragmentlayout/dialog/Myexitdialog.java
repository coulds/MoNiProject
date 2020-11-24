package com.edu.fragmentlayout.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.edu.fragmentlayout.R;

public class Myexitdialog extends DialogFragment implements View.OnClickListener {
    private ImageView btnconfirm;
    private ImageView btncancle;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);//解决弹窗不全屏
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置背景为透明
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//去除标题
        View view = inflater.inflate(R.layout.exitlayout,container);

        btnconfirm = (ImageView)view.findViewById(R.id.dialog_btn_confirm);
        btncancle = (ImageView)view.findViewById(R.id.dialog_btn_cancle);
        btncancle.setOnClickListener(this);
        btnconfirm.setOnClickListener(this);

        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        dialog.getWindow().setLayout((int) (ViewGroup.LayoutParams.WRAP_CONTENT), ViewGroup.LayoutParams.WRAP_CONTENT);
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        getDialog().getWindow().setLayout(displayMetrics.widthPixels, getDialog().getWindow().getAttributes().height);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialog_btn_confirm:
                getActivity().finish();
                break;
            case R.id.dialog_btn_cancle:
                dismiss();
                break;
                default:
                    break;
        }

    }
}
