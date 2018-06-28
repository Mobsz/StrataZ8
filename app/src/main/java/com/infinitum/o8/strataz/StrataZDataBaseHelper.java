package com.infinitum.o8.strataz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.DrawableRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

public class StrataZDataBaseHelper extends SQLiteOpenHelper {
    //Database Name
    private static final String DB_NAME = "StrataData8";
    //Database Version
    private static int DB_VERSION = 2;
    //ContentValues holds the info to pass to db
    ContentValues unitValues = new ContentValues();


    //DBHelper Constructor; Passes Name and Version;
    StrataZDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    //no such column: id - error - Possibly Listview adapter
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE UNIT (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "IMGNUM INTEGER, UNITTYPE INTEGER, MPNUM INTEGER, HPVALUE TEXT, ATKVALUE TEXT, DEFVALUE TEXT);");
        updateMyDatabase(db, 0, DB_VERSION);

        //insertUnit(db, 0, "Warrior", "Warrior Unit", R.drawable.warrior_unit);
        //db.update("UNIT", unitValues, "HPVALUE = ?", new String[] {});
        //Snackbar.make(null, String.valueOf(DB_VERSION), Snackbar.LENGTH_SHORT).show();


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);


    }

    public void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            //db.execSQL("CREATE TABLE UNIT (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    //+ "IMGNUM INTEGER, UNITTYPE INTEGER, MPNUM INTEGER, HPVALUE INTEGER, ATKVALUE INTEGER, DEFVALUE INTEGER);");
            insertUnit(db, R.drawable.warrior_unit, 1, 5, 30, 10, 15);
            insertUnit(db, R.drawable.warrior_unit, 1, 5, 30, 10, 15);
        }

    }


    //SQL Database Method
    private static void insertUnit(SQLiteDatabase db, int imgnum, int unittype, int mpnum,
                                                        int hpValue, int atkvalue, int defvalue) {
        ContentValues unitValues = new ContentValues();
        unitValues.put("IMGNUM", imgnum);
        unitValues.put("UNITTYPE", unittype);
        unitValues.put("MPNUM", mpnum);
        unitValues.put("HPVALUE", hpValue);
        unitValues.put("ATKVALUE", atkvalue);
        unitValues.put("DEFVALUE", defvalue);
        db.insert("UNIT", null, unitValues);

        //Snackbar.make(null, "Worked!", Snackbar.LENGTH_SHORT).show();
    }
}