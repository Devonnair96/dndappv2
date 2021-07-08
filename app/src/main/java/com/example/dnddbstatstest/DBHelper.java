package com.example.dnddbstatstest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public static final String CHARACTER_TABLE = "CHARACTER_TABLE";
    public static final String COLUMN_CHARACTER_NAME = "CHARACTER_NAME";
    public static final String COLUMN_STR = "STR";
    public static final String COLUMN_DEX = "DEX";
    public static final String COLUMN_CON = "CON";
    public static final String COLUMN_WIS = "WIS";
    public static final String COLUMN_INTEL = "INTEL";
    public static final String COLUMN_CHA = "CHA";

    public DBHelper(@Nullable Context context) {
        super(context, "characterDB", null, 1);
    }

    // called first time the database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createdb = "CREATE TABLE " + CHARACTER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHARACTER_NAME + " TEXT, " + COLUMN_STR + " INT, " + COLUMN_DEX + " INT, " +
                COLUMN_CON + " INT, " + COLUMN_WIS + " INT, " + COLUMN_INTEL + " INT, " + COLUMN_CHA +
                " INT)";
        db.execSQL(createdb);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addChar(CharSheet charSheet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CHARACTER_NAME, charSheet.getName());
        cv.put(COLUMN_STR, charSheet.getStr());
        cv.put(COLUMN_DEX, charSheet.getDex());
        cv.put(COLUMN_CON, charSheet.getCon());
        cv.put(COLUMN_WIS, charSheet.getWis());
        cv.put(COLUMN_INTEL, charSheet.getIntel());
        cv.put(COLUMN_CHA, charSheet.getCha());

        long insert = db.insert(CHARACTER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean deleteChar(CharSheet charSheet)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + CHARACTER_TABLE + " WHERE "  + "ID = " + charSheet.getId();

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else{return false;}
    }
    public List<CharSheet> getAllChar()
    {
        // gets readable database and create list to write to
        List<CharSheet> all = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + CHARACTER_TABLE;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                int charID = cursor.getInt(0);
                String charName = cursor.getString(1);
                int charStr = cursor.getInt(2);
                int charDex = cursor.getInt(3);
                int charCon = cursor.getInt(4);
                int charWis = cursor.getInt(5);
                int charIntel = cursor.getInt(6);
                int charCha = cursor.getInt(7);

                all.add(new CharSheet(charName,charID,charStr,charDex,charCon,charWis,charIntel,charCha));

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return all;
    }


}
