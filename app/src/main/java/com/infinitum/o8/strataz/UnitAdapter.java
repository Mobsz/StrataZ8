package com.infinitum.o8.strataz;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.ViewHolder> {
    public TextView unitHp, unitDef, unitAtk, unitMpValue, hpValue, defValue, atkValue, unitMpText;
    public Button hpBtnMin, defBtnMin, atkBtnMin, mpBtnMin, hpBtnPlu, defBtnPlu, atkBtnPlu, mpBtnPlu;
    public Spinner unitTypeSpinner, unitLvlSpinner;
    public ImageView unitImg;
    public Switch on_offSwitch;
    public ProgressBar hpPb, defPb, atkPb;
    private List<Units> mUnits;
    private Context mContext;
    private Listener listener;
    private SQLiteDatabase db;
    private Cursor cursor;
    private SharedPreferences sharedPreferences;
    private int savedValue;
    public String savedStringValue;


    interface Listener {
        void onClick(int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public TextView unitHp, unitDef, unitAtk, unitMpValue, hpValue, defValue, atkValue, unitMpText;
        public Button hpBtnMin, defBtnMin, atkBtnMin, mpBtnMin, hpBtnPlu, defBtnPlu, atkBtnPlu, mpBtnPlu;
        public Spinner unitTypeSpinner, unitLvlSpinner;
        public ImageView unitImg;
        public Switch on_offSwitch;
        public ProgressBar hpPb, defPb, atkPb;
        private SQLiteDatabase db;
        private Cursor cursor;
        private SharedPreferences sharedPreferences;
        private int savedValue;
        public String savedStringValue;


        public ViewHolder(final CardView v) {
            super(v);
            cardView = v;

        }

    }

    public UnitAdapter(Context context, List<Units> units) {
        mUnits = units;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mUnits.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    //Saves Data in SharedPreferences
    public void saveInt(String key, int value) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public void saveString(String key, String value) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    //Loads data from SharedPreferences
    public void loadInt() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        savedValue = sharedPreferences.getInt("key", 0);
    }

    public void loadString(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        savedStringValue = sharedPreferences.getString("key", "0");
    }


    @Override
    public UnitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_resources, parent, false);


        CardView cv = (CardView) inflater.inflate(R.layout.unit_cardview, parent, false);

        ViewHolder viewHolder = new ViewHolder(cv);

        RecyclerView unitRecycler = new RecyclerView(context);

        viewHolder.setIsRecyclable(false);


        return new ViewHolder(cv);

    }


    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;
        ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
        ProgressBar defPb = cardView.findViewById(R.id.defPb);
        ProgressBar atkPb = cardView.findViewById(R.id.atkPb);
        ImageView unitImg = cardView.findViewById(R.id.unitImg);
        TextView hpValue = cardView.findViewById(R.id.hpValue);
        TextView defValue = cardView.findViewById(R.id.defValue);
        TextView atkValue = cardView.findViewById(R.id.atkValue);
        TextView unitMpValue = cardView.findViewById(R.id.unitMpValue);
        Spinner unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
//Stop RecyclerView from Recycling
        holder.isRecyclable();
        holder.setIsRecyclable(false);

        String currentHp = String.valueOf(hpPb.getProgress());
        String maxHp = String.valueOf(hpPb.getMax());

        int unitType;

        switch (position) {
            //position = card
            case 0:
                //not going off position; change to work on which unittype is selected
                    //if (position == 0) {

                        try {
                            loadInt();
                            loadString();

                            unitMpValue = cardView.findViewById(R.id.unitMpValue);
                            unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
                            int mpValue = sharedPreferences.getInt("unitMpValue", 0);
                            int hpPbMax = sharedPreferences.getInt("hpPbMax", 0);
                            int hpPbProg = sharedPreferences.getInt("hpPbProg", 0);
                            int defPbMax = sharedPreferences.getInt("defPbMax", 0);
                            int defPbProg = sharedPreferences.getInt("defPbProg", 0);
                            int atkPbMax = sharedPreferences.getInt("atkPbMax", 0);
                            int atkPbProg = sharedPreferences.getInt("atkPbProg", 0);
                            unitType = sharedPreferences.getInt("unitType", 0);
                            String hpValueTV = sharedPreferences.getString("hpValue", "0/0");
                            String defValueTV = sharedPreferences.getString("defValue", "0/0");
                            String atkValueTV = sharedPreferences.getString("atkValue", "0");

                            //unitTypeSpinner.setSelection(2);
                            unitMpValue.setText(String.valueOf(mpValue));
                            hpPb.setProgress(hpPbProg);
                            hpPb.setMax(hpPbMax);
                            defPb.setMax(defPbMax);
                            defPb.setProgress(defPbProg);
                            atkPb.setMax(atkPbMax);
                            atkPb.setProgress(atkPbProg);
                            hpValue.setText(hpValueTV);
                            defValue.setText(defValueTV);
                            atkValue.setText(atkValueTV);
                            unitTypeSpinner.setSelection(unitType);

                            Snackbar.make(cardView, "Load Worked! " + unitType, Snackbar.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Snackbar.make(cardView, "Load Didn't Work!", Snackbar.LENGTH_SHORT).show();
                        }

                    //} if curly brace
                break;
        }

        /*
        try {
            if (savedValue == sharedPreferences.getInt("hpPb", 20)) {
                unitMpValue.setText(savedValue);
                Snackbar.make(cardView, "Shared Worked!", Snackbar.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Snackbar.make(cardView, "Shared Didn't Work!", Snackbar.LENGTH_SHORT).show();
        }
        */


//cardView OnClickListener to delegate clicks by position
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);
                        }
                    }
                });

                Button hpBtnMin = cardView.findViewById(R.id.hpBtnMin);
//hp minus btn on click listener
                hpBtnMin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
                            TextView hpValue = cardView.findViewById(R.id.hpValue);
                            String currentHp = String.valueOf(hpPb.getProgress());
                            int hpInt;
                            Snackbar.make(cardView, "Hp Set!", Snackbar.LENGTH_SHORT);
                            hpInt = Integer.valueOf(currentHp);
                            hpInt--;
                            currentHp = String.valueOf(hpInt);
                            hpPb.setProgress(Integer.getInteger(currentHp));
                            hpValue.setText(currentHp);

                        }catch(Exception e){

                        }


                    }
                });

                unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
                        ProgressBar defPb = cardView.findViewById(R.id.defPb);
                        ProgressBar atkPb = cardView.findViewById(R.id.atkPb);
                        ImageView unitImg = cardView.findViewById(R.id.unitImg);
                        TextView hpValue = cardView.findViewById(R.id.hpValue);
                        TextView defValue = cardView.findViewById(R.id.defValue);
                        TextView atkValue = cardView.findViewById(R.id.atkValue);
                        TextView unitMpValue = cardView.findViewById(R.id.unitMpValue);
                        Spinner unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);


                        //Trying to get the view id from SelectItem position to change which reference to edit (hpPb1 in 2nd table)

                        //Unit Switch - Still need to add Imgs
                        switch (unitTypeSpinner.getSelectedItemPosition()) {
                            //Default Unit
                        case 0:
                            /* Throws off the sharedpreferences variables by defaulting to 0 on all variables - Put as default
                            for switch case, loads default first, then the sharedpreferences variables, possibly because on
                            selecting an item for the switch, it's already at 0 - I thought it triggered after selection

                            saveInt("unitType", 0);
                            saveInt("unitMpValue", 0);
                            saveInt("hpPbMax", 0);
                            saveInt("hpPbProg", 0);
                            saveInt("defPbMax", 0);
                            saveInt("defPbProg", 0);
                            saveInt("atkPbMax", 0);
                            saveInt("atkPbProg", 0);
                            saveInt("unitLvl", 0);
                            saveString("hpValue", "0/0");
                            saveString("defValue", "0/0");
                            saveString("atkValue", "0/0");
                            */
                            hpPb.setMax(0);
                            hpPb.setProgress(0);
                            defPb.setMax(0);
                            defPb.setProgress(0);
                            atkPb.setMax(0);
                            atkPb.setProgress(0);
                            hpValue.setText("");
                            defValue.setText("");
                            atkValue.setText("");
                            unitMpValue.setText("");
                            Snackbar.make(cardView, "Unit Deleted!", Snackbar.LENGTH_SHORT);
                            break;

                            //Warrior
                            case 1:
                                try {
                                    saveInt("unitType", 1);
                                    saveInt("unitMpValue", 3);
                                    saveInt("hpPbMax", 20);
                                    saveInt("hpPbProg", 20);
                                    saveInt("defPbMax", 20);
                                    saveInt("defPbProg", 20);
                                    saveInt("atkPbMax", 20);
                                    saveInt("atkPbProg", 20);
                                    saveInt("unitLvl", 0);
                                    saveString("hpValue", "20 / 20");
                                    saveString("defValue", "20 / 20");
                                    saveString("atkValue", "20 / 20");

                                    String hpValueTV = sharedPreferences.getString("hpValue", "");
                                    String defValueTV = sharedPreferences.getString("defValue", "");
                                    String atkValueTV = sharedPreferences.getString("atkValue", "");
                                    String currentHp = String.valueOf(hpPb.getProgress());
                                    String maxHp = String.valueOf(hpPb.getMax());
                                    String currentDef = String.valueOf(defPb.getProgress());
                                    String maxDef = String.valueOf(defPb.getMax());
                                    String currentAtk = String.valueOf(atkPb.getProgress());
                                    String maxAtk = String.valueOf(atkPb.getMax());

                                    unitTypeSpinner.setSelection(1);
                                    hpPb.setMax(20);
                                    hpPb.setProgress(20);
                                    defPb.setMax(20);
                                    defPb.setProgress(20);
                                    atkPb.setMax(20);
                                    atkPb.setProgress(20);
                                    hpValue.setText(hpValueTV);
                                    defValue.setText(defValueTV);
                                    atkValue.setText(atkValueTV);
                                    unitMpValue.setText("3");
                                    Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();





                                    loadInt();
                                    loadString();

                                    hpValue.setText(hpValueTV);




                                } catch (Exception e) {
                                    Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                break;
                            //Archer
                            case 2:

                                hpPb.setMax(30);
                                hpPb.setProgress(30);
                                defPb.setMax(10);
                                defPb.setProgress(10);
                                atkPb.setMax(10);
                                atkPb.setProgress(10);
                                hpValue.setText("30/30");
                                defValue.setText("10/10");
                                atkValue.setText("10/10");
                                unitMpValue.setText("4");
                                unitTypeSpinner.setSelection(2);

                                try {
                                    String hpValueTV = sharedPreferences.getString("hpValue", "");
                                    String defValueTV = sharedPreferences.getString("defValue", "");
                                    String atkValueTV = sharedPreferences.getString("atkValue", "");
                                    String currentHp = String.valueOf(hpPb.getProgress());
                                    String maxHp = String.valueOf(hpPb.getMax());
                                    String currentDef = String.valueOf(defPb.getProgress());
                                    String maxDef = String.valueOf(defPb.getMax());
                                    String currentAtk = String.valueOf(atkPb.getProgress());
                                    String maxAtk = String.valueOf(atkPb.getMax());

                                    saveInt("unitType", 2);
                                    saveInt("unitMpValue", 4);
                                    saveInt("hpPbProg", 30);
                                    saveInt("hpPbMax", 30);
                                    saveInt("defPbMax", 10);
                                    saveInt("defPbProg", 10);
                                    saveInt("atkPbMax", 10);
                                    saveInt("atkPbProg", 10);
                                    saveInt("unitLvl", 0);
                                    saveString("hpValue", currentHp + " / " + maxHp);
                                    saveString("defValue", currentDef + " / " + maxDef);
                                    saveString("atkValue", currentAtk + " / " + maxAtk);


                                    //Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                break;
                            //Horseman
                            case 3:
                                hpPb.setMax(20);
                                hpPb.setProgress(20);
                                defPb.setMax(10);
                                defPb.setProgress(10);
                                atkPb.setMax(30);
                                atkPb.setProgress(30);
                                hpValue.setText("20/20");
                                defValue.setText("10/10");
                                atkValue.setText("30/30");
                                unitMpValue.setText("6");
                                unitTypeSpinner.setSelection(3);
                                try {
                                    String currentHp = String.valueOf(hpPb.getProgress());
                                    String maxHp = String.valueOf(hpPb.getMax());
                                    saveInt("unitType", 3);
                                    saveInt("unitMpValue", 6);
                                    saveInt("hpPbProg", 20);
                                    saveInt("hpPbMax", 20);
                                    saveInt("defPbMax", 10);
                                    saveInt("defPbProg", 10);
                                    saveInt("atkPbMax", 30);
                                    saveInt("atkPbProg", 30);
                                    saveInt("unitLvl", 0);
                                    saveString("hpValue", currentHp + " / " + maxHp);
                                    saveString("defValue", "10/10");
                                    saveString("atkValue", "30");
                                    //Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                break;
                            //Spy
                            case 4:
                                hpPb.setMax(0);
                                hpPb.setProgress(0);
                                defPb.setMax(0);
                                defPb.setProgress(0);
                                atkPb.setMax(0);
                                atkPb.setProgress(0);
                                hpValue.setText("");
                                defValue.setText("");
                                atkValue.setText("");
                                unitMpValue.setText("");
                                break;
                            //Ram
                            case 5:
                                hpPb.setMax(30);
                                hpPb.setProgress(30);
                                defPb.setMax(20);
                                defPb.setProgress(20);
                                atkPb.setMax(50);
                                atkPb.setProgress(50);
                                hpValue.setText("30/30");
                                defValue.setText("20/20");
                                atkValue.setText("50/50");
                                unitMpValue.setText("2");
                                break;
                            default:
                                saveInt("unitType", 0);
                                saveInt("unitMpValue", 0);
                                saveInt("hpPbMax", 0);
                                saveInt("hpPbProg", 0);
                                saveInt("defPbMax", 0);
                                saveInt("defPbProg", 0);
                                saveInt("atkPbMax", 0);
                                saveInt("atkPbProg", 0);
                                saveInt("unitLvl", 0);
                                saveString("hpValue", "0/0");
                                saveString("defValue", "0/0");
                                saveString("atkValue", "0/0");
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        }

//Spinner onClick


    }




//SQLite DB
                /*SQLiteOpenHelper StrataZDataBaseHelper = new StrataZDataBaseHelper(getContext());
                try
                {
                    SQLiteDatabase db = StrataZDataBaseHelper.getReadableDatabase();
                    Cursor cursor = db.query ("DRINK",
                            new String[] {"HPVALUE"},
                            "_id = ?",
                            new String[] {Integer.toString(unitId)},
                            null, null, null);

                    if (cursor.moveToFirst()) {

                        String hpText = cursor.getString(0);


                        hpValue.setText(hpText);
                    }

                    //cursor.close();
                    //db.close();


                    //hpValue = cardView.findViewById(R.id.hpValue);
                    //hpValue.setText(Integer.toString(position));
                    //Snackbar.make(cardView, "DB worked!", Snackbar.LENGTH_SHORT).show();

                }catch(SQLiteException e){
                    Snackbar.make(cardView, "DB didn't work!", Snackbar.LENGTH_SHORT).show();
                }

                */

/*
        //SQLite DB
        SQLiteOpenHelper StrataZDataBaseHelper = new StrataZDataBaseHelper(getContext());
        try
        {

            hpValue = cardView.findViewById(R.id.hpValue);
            hpValue.setText(Integer.toString(position));


            db = StrataZDataBaseHelper.getWritableDatabase();
            db.execSQL();

            //Snackbar.make(cardView, "DB worked!", Snackbar.LENGTH_SHORT).show();

        }catch(SQLiteException e){
            Snackbar.make(cardView, "DB didn't work!", Snackbar.LENGTH_SHORT).show();

        }*/