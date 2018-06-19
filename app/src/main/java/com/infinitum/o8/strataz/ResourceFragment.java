package com.infinitum.o8.strataz;

import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResourceFragment extends Fragment {

    public ResourceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView resourceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_resources_rec, container, false);

        String[] resourceName = new String[Resources.resource.length];
        for (int i = 0; i < resourceName.length; i++) {
            resourceName[i] = Resources.resource[i].getName();
        }

        int[] resourceImg = new int[Resources.resource.length];
        for (int i = 0; i < resourceImg.length; i++) {
            resourceImg[i] = Resources.resource[i].getImageResourceId();
        }

        ResourceAdapter adapter = new ResourceAdapter(resourceName, resourceImg);
        resourceRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        resourceRecycler.setLayoutManager(layoutManager);


        adapter.setListener(new ResourceAdapter.Listener() {
            public void onClick(int position) {

            }


        });

        return resourceRecycler;

    }

}