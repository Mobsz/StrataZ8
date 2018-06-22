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
import android.widget.Toast;

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
    public int unitLvl;


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
        public int unitLvl;


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

        Spinner unitLvlSpinner = parent.findViewById(R.id.unitLvlSpinner);

        try {
                if(sharedPreferences.getInt("unitLvlKey", 0)!=0)
            //unitLvl = sharedPreferences.getInt("unitLvlKey", 0);
            //unitLvlSpinner.setSelection(sharedPreferences.getInt("unitLvlKey", 0));
            Toast.makeText(getContext(), "Unit Adapter" + unitLvl, Toast.LENGTH_SHORT).show();
        }catch(Exception e){

        }

        return new ViewHolder(cv);

    }


    public void onBindViewHolder(final ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
        ProgressBar defPb = cardView.findViewById(R.id.defPb);
        ProgressBar atkPb = cardView.findViewById(R.id.atkPb);
        ImageView unitImg = cardView.findViewById(R.id.unitImg);
        TextView hpValue = cardView.findViewById(R.id.hpValue);
        TextView defValue = cardView.findViewById(R.id.defValue);
        TextView atkValue = cardView.findViewById(R.id.atkValue);
        TextView unitMpValue = cardView.findViewById(R.id.unitMpValue);
        Spinner unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
        Spinner unitLvlSpinner = cardView.findViewById(R.id.unitLvlSpinner);
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

                            Toast.makeText(getContext(), "savedValue " + savedValue, Toast.LENGTH_SHORT).show();

                            //unitLvl = sharedPreferences.getInt("unitLvlKey", 0);
                            //saveInt("unitLvlKey", unitLvl);
                            Toast.makeText(getContext(), "onBind " + unitLvl, Toast.LENGTH_SHORT).show();
                            unitMpValue = cardView.findViewById(R.id.unitMpValue);
                            unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
                            unitLvlSpinner = cardView.findViewById(R.id.unitLvlSpinner);
                            int mpValue = sharedPreferences.getInt("unitMpValue", 0);
                            int hpPbMax = sharedPreferences.getInt("hpPbMax", 0);
                            int hpPbProg = sharedPreferences.getInt("hpPbProg", 0);
                            int defPbMax = sharedPreferences.getInt("defPbMax", 0);
                            int defPbProg = sharedPreferences.getInt("defPbProg", 0);
                            int atkPbMax = sharedPreferences.getInt("atkPbMax", 0);
                            int atkPbProg = sharedPreferences.getInt("atkPbProg", 0);
                            //unitLvl = sharedPreferences.getInt("unitLvl", 0);
                            unitType = sharedPreferences.getInt("unitType", 0);
                            String hpValueTV = sharedPreferences.getString("hpValue", "0/0");
                            String defValueTV = sharedPreferences.getString("defValue", "0/0");
                            String atkValueTV = sharedPreferences.getString("atkValue", "0");

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
                            unitLvlSpinner.setSelection(unitLvl);
                            //saveInt("unitLvlKey", unitLvl);
                            Toast.makeText(getContext(), "Lvl Spinner Set" + unitLvl, Toast.LENGTH_SHORT).show();

                            //Snackbar.make(cardView, "Load Worked! " + unitType, Snackbar.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Snackbar.make(cardView, "Load Didn't Work!", Snackbar.LENGTH_SHORT).show();
                        }

                    //} if curly brace
                break;
        }

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
                        CardView cardView = holder.cardView;
                            Snackbar.make(cardView, "Hp Set!", Snackbar.LENGTH_SHORT);
                            /*
                            ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
                            TextView hpValue = cardView.findViewById(R.id.hpValue);
                            int currentHp = hpPb.getProgress();
                            currentHp--;
                            hpValue.setText(currentHp);
*/



                    }
                });

                // unitLvl keeps resetting to 0 during onViewHolder for some reason
                unitLvlSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        CardView cardView = holder.cardView;
                        ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
                        ProgressBar defPb = cardView.findViewById(R.id.defPb);
                        ProgressBar atkPb = cardView.findViewById(R.id.atkPb);
                        ImageView unitImg = cardView.findViewById(R.id.unitImg);
                        TextView hpValue = cardView.findViewById(R.id.hpValue);
                        TextView defValue = cardView.findViewById(R.id.defValue);
                        TextView atkValue = cardView.findViewById(R.id.atkValue);
                        TextView unitMpValue = cardView.findViewById(R.id.unitMpValue);
                        Spinner unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
                        Spinner unitLvlSpinner = cardView.findViewById(R.id.unitLvlSpinner);
                        loadString();
                        loadInt();
                        unitLvl = position;
                        //Kurfluffled workaround to keep feeding the data - Self forced persistence - Keeps loading elsewhere,
                        //so look for that!
                        if (position != 0) {
                            try {
                                saveInt("unitLvlKey", position);
                                Toast.makeText(getContext(), "Item Level Selected " + unitLvl, Toast.LENGTH_SHORT).show();
//Switch on position for adding boosts based on Lvl, doesn't seem to do anything...
                                switch (position){
                                    case 1:
                                       // String x = hpValue.toString();
                                        //int xx = Integer.getInteger(x + 50);
                                        //x = String.valueOf(xx);
                                       // Toast.makeText(getContext(), "X = " + x, Toast.LENGTH_SHORT).show();
                                        hpValue.setText("Hello!");

                                        break;
                                }
                            } catch (Exception e) {

                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        CardView cardView = holder.cardView;
                        ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
                        ProgressBar defPb = cardView.findViewById(R.id.defPb);
                        ProgressBar atkPb = cardView.findViewById(R.id.atkPb);
                        ImageView unitImg = cardView.findViewById(R.id.unitImg);
                        TextView hpValue = cardView.findViewById(R.id.hpValue);
                        TextView defValue = cardView.findViewById(R.id.defValue);
                        TextView atkValue = cardView.findViewById(R.id.atkValue);
                        TextView unitMpValue = cardView.findViewById(R.id.unitMpValue);
                        Spinner unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
                        Spinner unitLvlSpinner = cardView.findViewById(R.id.unitLvlSpinner);

                        Snackbar.make(cardView, "Unit Deleted!", Snackbar.LENGTH_SHORT);



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
                            //Snackbar.make(cardView, "Unit Deleted!", Snackbar.LENGTH_SHORT);
                            break;

                            //Warrior
                            case 1:
                                try {
                                    saveInt("unitType", 1);
                                    //cant get unitLvl value to work on unitLvlSpinner's selected item - Can force it to a lvl,
                                    //no reason I can see for it not working
                                    //saveInt("unitLvl", 1);
                                    saveInt("unitMpValue", 3);
                                    saveInt("hpPbMax", 20);
                                    saveInt("hpPbProg", 20);
                                    saveInt("defPbMax", 20);
                                    saveInt("defPbProg", 20);
                                    saveInt("atkPbMax", 20);
                                    saveInt("atkPbProg", 20);
                                    saveString("hpValue", "20 / 20");
                                    saveString("defValue", "20 / 20");
                                    saveString("atkValue", "20 / 20");



                                    String hpValueTV = sharedPreferences.getString("hpValue", "");
                                    String defValueTV = sharedPreferences.getString("defValue", "");
                                    String atkValueTV = sharedPreferences.getString("atkValue", "");
                                    int hpPbMax = sharedPreferences.getInt("hpPbMax", 0);
                                    int hpPbProg = sharedPreferences.getInt("hpPbProg", 0);
                                    int defPbMax = sharedPreferences.getInt("defPbMax", 0);
                                    int defPbProg = sharedPreferences.getInt("defPbProg", 0);
                                    int atkPbMax = sharedPreferences.getInt("atkPbMax", 0);
                                    int atkPbProg = sharedPreferences.getInt("atkPbProg", 0);
                                    int unitType = sharedPreferences.getInt("unitType", 0);
                                    //int unitLvl = sharedPreferences.getInt("unitLvlKey", 0);
                                    int unitMp = sharedPreferences.getInt("unitMpValue", 0);

                                    unitLvl = (sharedPreferences.getInt("unitLvlKey", 0));
                                    unitTypeSpinner.setSelection(unitType);
                                    unitLvlSpinner.setSelection(unitLvl);
                                    Toast.makeText(getContext(), "Unit Level " + unitLvl + "Selected!", Toast.LENGTH_SHORT).show();
                                    hpPb.setMax(hpPbMax);
                                    hpPb.setProgress(hpPbProg);
                                    defPb.setMax(defPbMax);
                                    defPb.setProgress(defPbProg);
                                    atkPb.setMax(atkPbMax);
                                    atkPb.setProgress(atkPbProg);
                                    hpValue.setText(hpValueTV);
                                    defValue.setText(defValueTV);
                                    atkValue.setText(atkValueTV);
                                    unitMpValue.setText(String.valueOf(unitMp));

                                    Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();

                                } catch (Exception e) {
                                    Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                break;
                            //Archer
                            case 2:

                                try {
                                    saveInt("unitType", 2);
                                    saveInt("unitMpValue", 4);
                                    saveInt("hpPbMax", 30);
                                    saveInt("hpPbProg", 30);
                                    saveInt("defPbMax", 10);
                                    saveInt("defPbProg", 10);
                                    saveInt("atkPbMax", 10);
                                    saveInt("atkPbProg", 10);
                                    //saveInt("unitLvl", 0);
                                    saveString("hpValue", "30 / 30");
                                    saveString("defValue", "10 / 10");
                                    saveString("atkValue", "10 / 10");

                                    String hpValueTV = sharedPreferences.getString("hpValue", "");
                                    String defValueTV = sharedPreferences.getString("defValue", "");
                                    String atkValueTV = sharedPreferences.getString("atkValue", "");
                                    int hpPbMax = sharedPreferences.getInt("hpPbMax", 0);
                                    int hpPbProg = sharedPreferences.getInt("hpPbProg", 0);
                                    int defPbMax = sharedPreferences.getInt("defPbMax", 0);
                                    int defPbProg = sharedPreferences.getInt("defPbProg", 0);
                                    int atkPbMax = sharedPreferences.getInt("atkPbMax", 0);
                                    int atkPbProg = sharedPreferences.getInt("atkPbProg", 0);
                                    int unitType = sharedPreferences.getInt("unitType", 0);
                                    int unitMp = sharedPreferences.getInt("unitMpValue", 0);


                                    unitTypeSpinner.setSelection(unitType);
                                    hpPb.setMax(hpPbMax);
                                    hpPb.setProgress(hpPbProg);
                                    defPb.setMax(defPbMax);
                                    defPb.setProgress(defPbProg);
                                    atkPb.setMax(atkPbMax);
                                    atkPb.setProgress(atkPbProg);
                                    hpValue.setText(hpValueTV);
                                    defValue.setText(defValueTV);
                                    atkValue.setText(atkValueTV);
                                    unitMpValue.setText(String.valueOf(unitMp));
                                    //Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();


                                } catch (Exception e) {
                                   // Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                break;
                            //Horseman
                            case 3:
                                try {
                                    saveInt("unitType", 3);
                                    saveInt("unitMpValue", 6);
                                    saveInt("hpPbProg", 20);
                                    saveInt("hpPbMax", 20);
                                    saveInt("defPbMax", 10);
                                    saveInt("defPbProg", 10);
                                    saveInt("atkPbMax", 30);
                                    saveInt("atkPbProg", 30);
                                   // saveInt("unitLvl", 0);
                                    saveString("hpValue", "20 / 20");
                                    saveString("defValue", "10 / 10");
                                    saveString("atkValue", "30 / 30");

                                    String hpValueTV = sharedPreferences.getString("hpValue", "");
                                    String defValueTV = sharedPreferences.getString("defValue", "");
                                    String atkValueTV = sharedPreferences.getString("atkValue", "");
                                    int hpPbMax = sharedPreferences.getInt("hpPbMax", 0);
                                    int hpPbProg = sharedPreferences.getInt("hpPbProg", 0);
                                    int defPbMax = sharedPreferences.getInt("defPbMax", 0);
                                    int defPbProg = sharedPreferences.getInt("defPbProg", 0);
                                    int atkPbMax = sharedPreferences.getInt("atkPbMax", 0);
                                    int atkPbProg = sharedPreferences.getInt("atkPbProg", 0);
                                    int unitType = sharedPreferences.getInt("unitType", 0);
                                    int unitMp = sharedPreferences.getInt("unitMpValue", 0);


                                    unitTypeSpinner.setSelection(unitType);
                                    hpPb.setMax(hpPbMax);
                                    hpPb.setProgress(hpPbProg);
                                    defPb.setMax(defPbMax);
                                    defPb.setProgress(defPbProg);
                                    atkPb.setMax(atkPbMax);
                                    atkPb.setProgress(atkPbProg);
                                    hpValue.setText(hpValueTV);
                                    defValue.setText(defValueTV);
                                    atkValue.setText(atkValueTV);
                                    unitMpValue.setText(String.valueOf(unitMp));
                                    //Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                   // Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
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
                                //saveInt("unitLvl", 0);
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