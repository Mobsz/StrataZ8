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

public class RuleFragment extends Fragment {

    public RuleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView ruleRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_rule_rec, container, false);

        String[] ruleName = new String[Rules.rule.length];
        for (int i = 0; i < ruleName.length; i++) {
            ruleName[i] = Rules.rule[i].getRuleName();
        }

        String[] ruleInfo = new String[Rules.rule.length];
        for (int i = 0; i < ruleInfo.length; i++) {
            ruleInfo[i] = Rules.rule[i].getRuleInfo();
        }

        RuleAdapter adapter = new RuleAdapter(ruleName, ruleInfo);
        ruleRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ruleRecycler.setLayoutManager(layoutManager);

        return ruleRecycler;

    }

}