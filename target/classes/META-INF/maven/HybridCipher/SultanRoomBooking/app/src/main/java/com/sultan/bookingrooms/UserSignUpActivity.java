package com.sultan.bookingrooms;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sultan.bookingrooms.R;
import com.sultan.roomsdatabase.AdapterSignInDb;

public class UserSignUpActivity extends Activity
{
private EditText etUserName, etCustName, etEmail, etPassword, etConfirmPassword;
private Button btnRegister;
	
	AdapterSignInDb loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_signup_activity);
		
		// get Instance  of Database Adapter
		loginDataBaseAdapter=new AdapterSignInDb(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		// Get Refferences of Views
		
		etUserName = (EditText)findViewById(R.id.et_reg_username);
		etCustName = (EditText)findViewById(R.id.et_reg_customer_name);
		etEmail = (EditText)findViewById(R.id.et_reg_customer_email);
		etPassword = (EditText)findViewById(R.id.et_reg_customer_password);
		etConfirmPassword = (EditText)findViewById(R.id.et_reg_customer_confirm_password);
		
		btnRegister=(Button)findViewById(R.id.btn_register);
		btnRegister.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String userName=etUserName.getText().toString();
			String name=etCustName.getText().toString();
			String email=etEmail.getText().toString();
			String password=etPassword.getText().toString();
			String confirmPassword=etConfirmPassword.getText().toString();
			
			// check if any of the fields are vaccant
			if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_SHORT).show();
					return;
			}
			// check if both password matches
			if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
				return;
			}
			else
			{
			    // Save the Data in Database
			long rowID =   loginDataBaseAdapter.insertEntry(userName, name, email, password);
			Log.e("RegisterCustomerActivity===> row id", rowID+"");
			if(rowID != -1){
			    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_SHORT).show();
			   Intent intentregister = new Intent(UserSignUpActivity.this, UserAccountBookingActivity.class);
		        intentregister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        startActivity(intentregister);
			} else {
				 Toast.makeText(getApplicationContext(), "Data invalid register again ", Toast.LENGTH_SHORT).show();
				 return;
			}
			}
		}
	});
}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		loginDataBaseAdapter.close();
	}
}
