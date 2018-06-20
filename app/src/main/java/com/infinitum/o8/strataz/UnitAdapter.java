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

    //Loads data from SharedPreferences
    public void loadInt() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        savedValue = sharedPreferences.getInt("key", 0);
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

        long unitType;

        switch (position) {

            case 0:
                //not going off position; change to work on which unittype is selected
                    if (position == 0) {

                        try {

                            unitMpValue = cardView.findViewById(R.id.unitMpValue);
                            unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);
                            int mpValue = sharedPreferences.getInt("unitMpValue", 1);
                            int hpPbProg = sharedPreferences.getInt("hpPbProg", 1);
                            int hpPbMax = sharedPreferences.getInt("hpPbMax", 1);
                            unitType = sharedPreferences.getInt("hpPbMax", 1);
                            //unitTypeSpinner.setSelection((int)(long)unitType);

                            unitTypeSpinner.setSelection(2);
                            hpPb.setProgress(hpPbProg);
                            hpPb.setMax(hpPbMax);
                            unitMpValue.setText(String.valueOf(mpValue));
                            //defPb.setMax(20);
                            //defPb.setProgress(20);
                            //atkPb.setMax(20);
                            //atkPb.setProgress(20);
                            hpValue.setText(String.valueOf(hpPbMax));
                            //defValue.setText("20/20");
                            //atkValue.setText("20/20");
                            Snackbar.make(cardView, "Load Worked!", Snackbar.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Snackbar.make(cardView, "Load Didn't Work!", Snackbar.LENGTH_SHORT).show();
                        }

                    }
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
                       /* case 0:
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
                            */
                            //Warrior
                            case 1:
                                //hpPb.setMax(40);
                                try {
                                    saveInt("unitType", 1);
                                    saveInt("unitMpValue", 25);
                                    saveInt("hpPbProg", 50);
                                    saveInt("hpPbMax", 100);
                                    Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                //hpPb.setProgress(20);
                                //defPb.setMax(20);
                                //defPb.setProgress(20);
                                //atkPb.setMax(20);
                                //atkPb.setProgress(20);
                                //hpValue.setText("20/20");
                                //defValue.setText("20/20");
                                //atkValue.setText("20/20");
                                //unitMpValue.setText("3");
                                Snackbar.make(cardView, "Warrior Created!", Snackbar.LENGTH_SHORT);
                                break;
                            //Archer
                            case 2:
                                try {
                                    saveInt("unitType", 2);
                                    saveInt("unitMpValue", 24);
                                    saveInt("hpPbProg", 49);
                                    saveInt("hpPbMax", 99);
                                    Snackbar.make(cardView, "Save Worked!", Snackbar.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Snackbar.make(cardView, "Save Didn't Work!", Snackbar.LENGTH_SHORT).show();
                                }
                                hpPb.setMax(30);
                                saveInt("unitMpValue2", 5);
                                hpPb.setProgress(30);
                                defPb.setMax(10);
                                defPb.setProgress(10);
                                atkPb.setMax(10);
                                atkPb.setProgress(10);
                                hpValue.setText("30/30");
                                defValue.setText("10/10");
                                atkValue.setText("10/10");
                                unitMpValue.setText("4");
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