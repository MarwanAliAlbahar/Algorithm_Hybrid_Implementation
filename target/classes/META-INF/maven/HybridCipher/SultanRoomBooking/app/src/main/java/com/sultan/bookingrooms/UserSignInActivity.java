package com.sultan.bookingrooms;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sultan.bookingrooms.R;
import com.sultan.roomsdatabase.AdapterSignInDb;

public class UserSignInActivity extends Activity {
	private EditText etUsername, etPassword;
	private Button signInButton;
	private AdapterSignInDb loginDataBaseAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_signin_activity);
		// get Instance  of Database Adapter
		loginDataBaseAdapter=new AdapterSignInDb(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
			etUsername = (EditText)findViewById(R.id.et_customer_user_name);
		     etPassword = (EditText)findViewById(R.id.et_customer_password);
		     signInButton = (Button)findViewById(R.id.sign_in_button);
		     initCallBacks();
		
	}
	
	public void initCallBacks()
	   {
			// Set On ClickListener
		signInButton.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// get The User name and Password
					String username=etUsername.getText().toString();
					String password=etPassword.getText().toString();
					
					// fetch the Password form database for respective user name
					Cursor cursor = loginDataBaseAdapter.getSinlgeEntry(username);
					
					 if(cursor.getCount()<1) // UserName Not Exist
				        {
				        	cursor.close();
				        	Toast.makeText(UserSignInActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
				        	return;
				        }
					    cursor.moveToFirst();
					    String userNameReg = cursor.getString(cursor.getColumnIndex("USERNAME"));
					    String nameReg = cursor.getString(cursor.getColumnIndex("NAME"));
					    String emailReg = cursor.getString(cursor.getColumnIndex("EMAIL"));
						String passwordregistered= cursor.getString(cursor.getColumnIndex("PASSWORD"));
					
					// check if the Stored password matches with  Password entered by user
					if(password.equals(passwordregistered))
					{
						
						Toast.makeText(UserSignInActivity.this, "Congrats: Login Successfull", Toast.LENGTH_SHORT).show();
						  Intent intentlogin = new Intent(UserSignInActivity.this, UserAccountBookingActivity.class);
						  Bundle extras = new Bundle();
						  extras.putString("userNameReg", userNameReg);
						  extras.putString("nameReg", nameReg);
						  extras.putString("emailReg", emailReg);
						  intentlogin.putExtras(extras);
					        intentlogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					        startActivity(intentlogin);
					}
					else
					{
						Toast.makeText(UserSignInActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
					}
				}
			});
	}
}
