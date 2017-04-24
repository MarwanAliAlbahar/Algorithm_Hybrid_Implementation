package com.sultan.roomsdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AdapterSignInDb 
{
		static final String DATABASE_NAME = "roombooking.db";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		// SQL Statement to create a new database.
		static final String DATABASE_CREATE = "create table "+"USER"+
		                             "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text  unique, NAME  text, EMAIL  text, PASSWORD text); ";
		// Variable to hold the database instance
		public  SQLiteDatabase sqliteDatabase;
		// Context of the application using the database.
		private final Context context;
		// Database open/upgrade helper
		private SupportDb dbSupport;
		public  AdapterSignInDb(Context _context) 
		{
			context = _context;
			dbSupport = new SupportDb(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  AdapterSignInDb open() throws SQLException 
		{
			sqliteDatabase = dbSupport.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			sqliteDatabase.close();
		}

		public  SQLiteDatabase getDatabaseInstance()
		{
			return sqliteDatabase;
		}

		public long insertEntry(String userName, String name, String email, String password)
		{
	       ContentValues newValues = new ContentValues();
			// Assign values for each row.
	       	newValues.put("USERNAME", userName);
			newValues.put("NAME", name);
			newValues.put("EMAIL", email);
			newValues.put("PASSWORD",password);
			
			// Insert the row into your table
		long rowid = sqliteDatabase.insert("USER", null, newValues);
			///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
		return rowid;
		}		
		public Cursor getSinlgeEntry(String userName)
		{
			Cursor cursor=sqliteDatabase.query("USER", null, " USERNAME=?", new String[]{userName}, null, null, null);
			
			return cursor;
	       			
		}
	
}

