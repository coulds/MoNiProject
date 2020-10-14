package com.edu.fragmentlayout;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContacksFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private gotoFragment gotofragment;
    private Button btn;
    private ContacksFragment contacksFragment;




    public ContacksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ContacksLayout = inflater.inflate(R.layout.fragment_contacks, container, false);
        //                android.support.v4.app.Fragment fragment = new android.support.v4.app.Fragment();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                ft.replace(R.id.fragment_layout,new IntentFragment(),null);
//                ft.addToBackStack(null);
//                ft.commit();


//        btn = (Button)ContacksLayout.findViewById(R.id.button);
//        btn.setOnClickListener(this);
       return ContacksLayout;

    }

    @Override
    public void onClick(View view) {

    }
//    public void setgotofragment(gotoFragment gotofragment){
//       this.gotofragment = gotofragment;
//    }
//
//    public gotoFragment getGotofragment() {
//        return gotofragment;
//    }


//    @Override
//    public void onClick(View view) {
//        contacksFragment.go
//    }


}
