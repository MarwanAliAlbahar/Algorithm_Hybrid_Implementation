package com.sultan.bookingrooms;

import com.sultan.bookingrooms.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookingAppServicesActivity extends Activity {
	 TextView homeTv;
		TextView ourServicesTv;
		TextView companyInfoTv;
		TextView reachUsTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.booking_app_service_activity);
		View navigationLayout = findViewById(R.id.navigation_layout);
		
		View headerLayout = findViewById(R.id.header_layout);
		TextView headerText = (TextView) headerLayout.findViewById(R.id.header_text_layout);
		headerText.setText("SERVICE CATEGORIES");
		homeTv = (TextView) navigationLayout.findViewById(R.id.home_text);
		ourServicesTv = (TextView) navigationLayout.findViewById(R.id.ourservices_text);
		companyInfoTv = (TextView) navigationLayout.findViewById(R.id.info_text);
		reachUsTv = (TextView) navigationLayout.findViewById(R.id.reach_us_text);
		homeTv.setOnClickListener(new ClickListenerForUser(this));
		companyInfoTv.setOnClickListener(new ClickListenerForUser(this));
		reachUsTv.setOnClickListener(new ClickListenerForUser(this));
	
	}
	
}
