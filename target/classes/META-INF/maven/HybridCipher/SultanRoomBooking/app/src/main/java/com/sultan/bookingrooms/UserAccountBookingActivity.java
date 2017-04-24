package com.sultan.bookingrooms;

import com.sultan.bookingrooms.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserAccountBookingActivity extends Activity {
	private TextView signoutTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_account_booking_activity);
	View navigationLayout = findViewById(R.id.navigation_layout);
	signoutTextView = (TextView) navigationLayout.findViewById(R.id.user_signout);
	
		
	initCallBacks();
	signoutTextView.setOnClickListener(new ClickListenerForUser(UserAccountBookingActivity.this));
	}
	
	public void initCallBacks() {
		
	}
@Override
public void onBackPressed() {
}
	
}
