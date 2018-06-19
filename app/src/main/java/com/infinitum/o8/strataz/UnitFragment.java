package com.infinitum.o8.strataz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UnitFragment extends Fragment {

    ArrayList<Units> units;
    private SQLiteDatabase db;
    private Cursor cursor;

    public UnitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView unitRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_unit_rec, container, false);
//reference for unitID, needs to be replaced by db
        units = Units.createUnitList(0);

        UnitAdapter adapter = new UnitAdapter(getActivity(), units);
        unitRecycler.setAdapter(adapter);
        unitRecycler.setItemViewCacheSize(10);

        int num = 2;
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        unitRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Set Listener on Adapter to pass id
        adapter.setListener(new UnitAdapter.Listener() {
            @Override
            public void onClick(int position) {

            }
        });



        adapter.setListener(new UnitAdapter.Listener() {
            public void onClick(int position) {

            }


        });

        return unitRecycler;

    }
}
        /*
        //return inflater.inflate(R.layout.fragment_unit, container, false);
        final View view = inflater.inflate(R.layout.fragment_unit, container, false);
//Get a view of milUnitView in fragment_unit layout to possibly automate the code for choosing widgets and what they interact with
        try {
            View milUnit = view.getRootView().findViewById(R.id.milUnitView);
            Toast.makeText(getContext(), "Worked!", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }

        TextView unitHp = view.findViewById(R.id.unitHp1);
        TextView unitDef = view.findViewById(R.id.unitDef1);
        TextView unitAtk = view.findViewById(R.id.unitAtk1);
        TextView unitMp = view.findViewById(R.id.unitMp1);
        TextView hpValue = view.findViewById(R.id.hpValue);
        TextView defValue = view.findViewById(R.id.defValue);
        TextView atkValue = view.findViewById(R.id.atkValue);
        TextView mpValue = view.findViewById(R.id.mpValue);

        Button hpBtnMin = view.findViewById(R.id.hpBtnMin1);
        Button defBtnMin = view.findViewById(R.id.defBtnMin1);
        Button atkBtnMin = view.findViewById(R.id.atkBtnMin);
        Button mpBtnMin = view.findViewById(R.id.mpBtnMin);
        Button hpBtnPlu = view.findViewById(R.id.hpBtnPlu1);
        Button defBtnPlu = view.findViewById(R.id.defBtnPlu);
        Button atkBtnPlu = view.findViewById(R.id.atkBtnPlu);
        Button mpBtnPlu = view.findViewById(R.id.mpBtnPlu);

        Spinner unitTypeSpinner = view.findViewById(R.id.unitTypeSpinner);
        Spinner unitLvlSpinner = view.findViewById(R.id.unitLvlSpinner);

        ImageView unitImg = view.findViewById(R.id.unitImg1);

        Switch on_offSwitch = view.findViewById(R.id.on_offSwitch1);

        ProgressBar hpPb = view.findViewById(R.id.hpPb);
        ProgressBar hpPb1 = view.findViewById(R.id.hpPb1);
        ProgressBar defPb = view.findViewById(R.id.defPb);
        ProgressBar atkPb = view.findViewById(R.id.atkPb);
        ProgressBar mpPb = view.findViewById(R.id.mpPb);


//UnitTypeSpinner Selector - Linked to UnitTypeOnClick()
        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String unit = ((TextView) view).getText().toString();
                try {
                            unitTypeOnClick(unit, 1);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Error Selecting", Toast.LENGTH_SHORT).show();
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

//Spinner onClick

            public void unitTypeOnClick(String unit, int viewid){
                    ProgressBar hpPb = view.findViewById(R.id.hpPb);
                    ProgressBar defPb = view.findViewById(R.id.defPb);
                    ProgressBar atkPb = view.findViewById(R.id.atkPb);
                    ProgressBar mpPb = view.findViewById(R.id.mpPb);
                    ImageView unitImg = view.findViewById(R.id.unitImg1);
                    TextView hpValue = view.findViewById(R.id.hpValue);
                    TextView defValue = view.findViewById(R.id.defValue);
                    TextView atkValue = view.findViewById(R.id.atkValue);
                    TextView mpValue = view.findViewById(R.id.mpValue);

                    //Trying to get the view id from SelectItem position to change which reference to edit (hpPb1 in 2nd table)
                    /*switch(viewid){
                        case 1:
                            ProgressBar hpPb1 = view.findViewById(R.id.hpPb1);
                            ProgressBar defPb1 = view.findViewById(R.id.defPb1);
                            ProgressBar atkPb1 = view.findViewById(R.id.atkPb1);
                            ProgressBar mpPb1 = view.findViewById(R.id.mpPb1);
                            ImageView unitImg1 = view.findViewById(R.id.unitImg1);
                            TextView hpValue1 = view.findViewById(R.id.hpValue1);
                            TextView defValue1 = view.findViewById(R.id.defValue1);
                            TextView atkValue1 = view.findViewById(R.id.atkValue1);
                            TextView mpValue1 = view.findViewById(R.id.mpValue1);

                    }

                //Unit Switch - Still need to add Imgs
                switch(unit) {
                    case "Warrior":
                    hpPb.setMax(20);
                    hpPb.setProgress(20);
                    defPb.setMax(20);
                    defPb.setProgress(20);
                    atkPb.setMax(20);
                    atkPb.setProgress(20);
                    mpPb.setMax(3);
                    mpPb.setProgress(3);
                    hpValue.setText("20/20");
                    defValue.setText("20/20");
                    atkValue.setText("20/20");
                    mpValue.setText("3");
                    break;

                    case "Archer":
                        hpPb.setMax(30);
                        hpPb.setProgress(30);
                        defPb.setMax(10);
                        defPb.setProgress(10);
                        atkPb.setMax(10);
                        atkPb.setProgress(10);
                        mpPb.setMax(4);
                        mpPb.setProgress(34);
                        hpValue.setText("30/30");
                        defValue.setText("10/10");
                        atkValue.setText("10/10");
                        mpValue.setText("4");
                }
            }


            //Button OnClicks
            public void onClickHpMin(View View) {


            }

            public void onClickHpPlu(View view) {

            }

            public void onClickDefMin(View view) {

            }

            public void onClickDefPlu(View view) {

            }

            public void onClickAtkMin(View view) {

            }

            public void onClickAtkPlu(View view) {

            }

            public void onClickMpMin(View view) {

            }

            public void onClickMpPlu(View view) {
            }
        });
        //End of setOnItemClickListener


        return view;
        }
}
*/