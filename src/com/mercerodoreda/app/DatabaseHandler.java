package com.mercerodoreda.app;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

	//CRUD Operations
	//CREATE
	public void addUsuari(Usuari usuari) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, usuari.getName());
		values.put(KEY_SURNAME1, usuari.getSurname1());
		values.put(KEY_SURNAME2, usuari.getSurname2());
		values.put(KEY_EMAIL, usuari.getEmail());
		values.put(KEY_PASSWORD, usuari.getPassword());
		values.put(KEY_TYPE, usuari.getType());
		
		db.insert(TABLE_USERS, null, values);
		db.close();
	}
	//READ
	public Usuari getUsusari(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(TABLE_USERS, new String [] { KEY_ID, KEY_NAME, KEY_SURNAME1, KEY_SURNAME2, KEY_EMAIL, 
				KEY_PASSWORD, KEY_TYPE }, KEY_ID + "=?", new String[] {String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		
		Usuari usuari = new Usuari(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), 
				cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
		
		return usuari;
	}
	
	public List<Usuari> getAllUsuaris() {
		List<Usuari> usuariList = new ArrayList<Usuari>();
		String selectQuery = "SELECT  * FROM " + TABLE_USERS;
		 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Usuari usuari = new Usuari();
	            usuari.setID(Integer.parseInt(cursor.getString(0)));
	            usuari.setName(cursor.getString(1));
	            usuari.setSurname1(cursor.getString(2));
	            usuari.setSurname2(cursor.getString(3));
	            usuari.setEmail(cursor.getString(4));
	            usuari.setPassword(cursor.getString(5));
	            usuari.setType(cursor.getString(6));
	            // Adding contact to list
	            usuariList.add(usuari);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return usuariList;
	}
	
	public int getUsuarisCount() {
		String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
	}
	//UPDATE
	public int updateContact(Usuari usuari) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NAME, usuari.getName());
	    values.put(KEY_SURNAME1, usuari.getSurname1());
	    values.put(KEY_SURNAME2, usuari.getSurname2());
	    values.put(KEY_EMAIL, usuari.getEmail());
	    values.put(KEY_PASSWORD, usuari.getPassword());
	    values.put(KEY_TYPE, usuari.getType());
	 
	    // updating row
	    return db.update(TABLE_USERS, values, KEY_ID + " = ?",
	            new String[] { String.valueOf(usuari.getID()) });
	}
	//DELETE
	public void deleteContact(Usuari usuari) {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_USERS, KEY_ID + " = ?",
	            new String[] { String.valueOf(usuari.getID()) });
	    db.close();
	}
}
