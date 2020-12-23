package com.edu.fragmentlayout.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edu.fragmentlayout.Activity.GouWuCheActivity;
import com.edu.fragmentlayout.R;
import com.edu.fragmentlayout.dialog.Myexitdialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContacksFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    private LinearLayout linearLayout_gwc,linearLayout_exit;
    private View ContacksLayout;
    private ContacksFragment contacksFragment;
    private TextView textView,textView1,TextView2,t1;
    private Myexitdialog myexitdialog;





    public ContacksFragment() {
        // Required empty public constructor
    }

//设置页面的fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ContacksLayout = inflater.inflate(R.layout.fragment_contacks, container, false);
        initViwe();
       return ContacksLayout;

    }

    private void initViwe() {
//        recyclerView = (RecyclerView)ContacksLayout.findViewById(R.id.gwc_recycleview);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(manager);
//        dataBeanList.addAll(AppApplication.getDataBeanList());
//        gouWuCheAdapter = new GouWuCheAdapter(getActivity(),dataBeanList);
//        recyclerView.setAdapter(gouWuCheAdapter);
        linearLayout_exit = (LinearLayout)ContacksLayout.findViewById(R.id.Linelayout_exit);
        linearLayout_gwc = (LinearLayout)ContacksLayout.findViewById(R.id.Linelayout_gwc);
//        t1 = ContacksLayout.findViewById(R.id.message1);
//        t1.setMovementMethod(new ScrollingMovementMethod());
        TextView2 = ContacksLayout.findViewById(R.id.yhj1);
        textView = (TextView)ContacksLayout.findViewById(R.id.gwc_text);
        textView1 = (TextView)ContacksLayout.findViewById(R.id.message1);
        socller();


        linearLayout_gwc.setOnClickListener(this);
        linearLayout_exit.setOnClickListener(this);


    }
    //滚动焦点
    private void socller(){
        if(textView1.length()>textView1.getWidth()){
            textView1.setSelected(true);
        }else {
            textView1.setSelected(false);
        }
//        if (textView.length()>textView.getWidth()){
//            textView.setSelected(true);
//        }else {
//            textView.setSelected(false);
//        }
//
//        if (TextView2.length()>TextView2.getWidth()){
//            TextView2.setSelected(true);
//        }else {
//            TextView2.setSelected(false);
//        }



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Linelayout_gwc:
                Intent intent = new Intent(getActivity(), GouWuCheActivity.class);
                startActivity(intent);
                break;
            case R.id.Linelayout_exit:
                myexitdialog = new Myexitdialog();
                myexitdialog.show(getFragmentManager(),"show");
        }
    }
}
