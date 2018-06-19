package com.infinitum.o8.strataz;

import android.app.LauncherActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
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
//Stop RecyclerView from Recycling
        holder.isRecyclable();
        holder.setIsRecyclable(false);

        ProgressBar hpPb = cardView.findViewById(R.id.hpPb);
        ProgressBar defPb = cardView.findViewById(R.id.defPb);
        ProgressBar atkPb = cardView.findViewById(R.id.atkPb);
        ImageView unitImg = cardView.findViewById(R.id.unitImg);
        TextView hpValue = cardView.findViewById(R.id.hpValue);
        TextView defValue = cardView.findViewById(R.id.defValue);
        TextView atkValue = cardView.findViewById(R.id.atkValue);
        TextView unitMpValue = cardView.findViewById(R.id.unitMpValue);
        Spinner unitTypeSpinner = cardView.findViewById(R.id.unitTypeSpinner);


//cardView OnClickListener to delegate clicks by position
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
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

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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

                int unitId = position;

                    //Trying to get the view id from SelectItem position to change which reference to edit (hpPb1 in 2nd table)

                    //Unit Switch - Still need to add Imgs
                    switch(unitTypeSpinner.getSelectedItemPosition()){
                            //Default Unit
                        case 0:
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
                            hpPb.setMax(20);
                            hpPb.setProgress(20);
                            defPb.setMax(20);
                            defPb.setProgress(20);
                            atkPb.setMax(20);
                            atkPb.setProgress(20);
                            hpValue.setText("20/20");
                            defValue.setText("20/20");
                            atkValue.setText("20/20");
                            unitMpValue.setText("3");
                            Snackbar.make(cardView, "Warrior Created!", Snackbar.LENGTH_SHORT);
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