package com.sultan.bookingrooms;

import com.sultan.bookingrooms.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class UserRegisterOrSignInActivity extends Activity{
	private Button signInButton, signupButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_signup_or_signin_activity);
		signInButton = (Button) findViewById(R.id.signin_btn_home);
		signupButton = (Button) findViewById(R.id.signup_btn_home);
		initCallBacks();
	}

	private void initCallBacks() {
		signInButton.setOnClickListener(new ClickListenerForUser(UserRegisterOrSignInActivity.this));
		signupButton.setOnClickListener(new ClickListenerForUser(UserRegisterOrSignInActivity.this));
	}
}
