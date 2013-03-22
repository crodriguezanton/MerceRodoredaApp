package com.mercerodoreda.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "usersmanager";
	private static final String TABLE_USERS = "usuaris";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_SURNAME1 = "surname1";
	private static final String KEY_SURNAME2 = "surname2";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_PASSWORD = "password";
	private static final String KEY_TYPE = "type";
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

		@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY, "
				+ KEY_NAME + " TEXT NO NULL, " + KEY_SURNAME1 + " TEXT NO NULL, " + KEY_SURNAME2 + " TEXT NO NULL, " 
				+ KEY_EMAIL + " TEXT NO NULL, " + KEY_PASSWORD + " TEXT NO NULL, " + KEY_TYPE + " TEXT NO NULL" + ")";
		db.execSQL(CREATE_TABLE_USERS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		onCreate(db);
	}

}
