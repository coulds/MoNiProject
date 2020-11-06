package com.edu.fragmentlayout.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.fragmentlayout.Activity.GouWuCheActivity;
import com.edu.fragmentlayout.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContacksFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    private View ContacksLayout;
    private ContacksFragment contacksFragment;
    private TextView textView;





    public ContacksFragment() {
        // Required empty public constructor
    }


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
        textView = (TextView)ContacksLayout.findViewById(R.id.gwc_text);
        textView.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gwc_text:
                Intent intent = new Intent(getActivity(), GouWuCheActivity.class);
                startActivity(intent);
        }
    }
}
