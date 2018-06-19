package com.infinitum.o8.strataz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

public class StrataZDataBaseHelper extends SQLiteOpenHelper {
    //Database Name
    private static final String DB_NAME = "StrataData";
    //Database Version
    private static int DB_VERSION = 4;
    //ContentValues holds the info to pass to db
    ContentValues unitValues = new ContentValues();


    //DBHelper Constructor; Passes Name and Version;
    StrataZDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    //no such column: id - error - Possibly Listview adapter
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
        db.execSQL("CREATE TABLE UNIT (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "HPVALUE TEXT);");

        //insertUnit(db, 0, "Warrior", "Warrior Unit", R.drawable.warrior_unit);
        //db.update("UNIT", unitValues, "HPVALUE = ?", new String[] {});
        //Snackbar.make(null, String.valueOf(DB_VERSION), Snackbar.LENGTH_SHORT).show();


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);


    }

    public void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("CREATE TABLE UNIT (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "HPVALUE TEXT);");
            insertUnit(db, 1,"206");
        }

    }


    //SQL Database Method
    private static void insertUnit(SQLiteDatabase db, int id, String hpValue) {
        ContentValues unitValues = new ContentValues();
        unitValues.put("_id", id);
        unitValues.put("HPVALUE", hpValue);
        db.insert("UNIT", null, unitValues);

        Snackbar.make(null, "Worked!", Snackbar.LENGTH_SHORT).show();
    }
}