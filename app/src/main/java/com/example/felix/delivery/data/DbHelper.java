package com.example.felix.delivery.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by FeliX on 31.05.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "backets.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_GUESTS_TABLE = "CREATE TABLE " + DbContract.GuestEntry.TABLE_NAME + " ("
                + DbContract.GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbContract.GuestEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DbContract.GuestEntry.COLUMN_ITEM + " TEXT NOT NULL, "
                + DbContract.GuestEntry.COLUMN_COUNTS + " INTEGER NOT NULL DEFAULT 3, ";
                //+ DbContract.GuestEntry.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0);";

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_NAME);
        // Создаём новую таблицу
        onCreate(db);
    }
}
