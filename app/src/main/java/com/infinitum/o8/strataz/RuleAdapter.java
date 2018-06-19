package com.infinitum.o8.strataz;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.ViewHolder> {


    private List<Rules> mRules;
    private Listener listener;
    private Context mContext;
    private String[] name, info;
    private TextView ruleName, ruleInfo;


    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView ruleNameText, ruleInfoText;


        public ViewHolder(final CardView v) {
            super(v);
            cardView = v;
            ruleNameText = itemView.findViewById(R.id.ruleNameView);
            ruleInfoText = itemView.findViewById(R.id.ruleInfoView);
        }

    }

    public RuleAdapter(String [] name, String[] info){
        this.name = name;
        this.info = info;
    }

    private Context getContext(){
        return mContext;
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public void setListener(RuleAdapter.Listener listener) {
        this.listener = listener;
    }


    @Override
    public RuleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_rule, parent, false);
        return new RuleAdapter.ViewHolder(cv);



    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;

        TextView ruleName = cardView.findViewById(R.id.ruleNameView);
        ruleName.setText(name[position]);

        TextView ruleInfo = cardView.findViewById(R.id.ruleInfoView);
        ruleInfo.setText(info[position]);

    }

}