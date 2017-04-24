package com.sultan.bookingrooms;

import com.sultan.bookingrooms.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutCompanyActivity extends Activity {
	 TextView homeTv;
	TextView ourServicesTv;
	TextView companyInfoTv;
	TextView reachUsTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_company_activity);
		View navigationLayout = findViewById(R.id.navigation_bar_top_layout);
		View headerLayout = findViewById(R.id.header_description_layout);
		TextView headerText = (TextView) headerLayout.findViewById(R.id.header_text_layout);
		headerText.setText("About Us");
		homeTv = (TextView) navigationLayout.findViewById(R.id.home_text);
		ourServicesTv = (TextView) navigationLayout.findViewById(R.id.ourservices_text);
		companyInfoTv = (TextView) navigationLayout.findViewById(R.id.info_text);
		reachUsTv = (TextView) navigationLayout.findViewById(R.id.reach_us_text);
		
		homeTv.setOnClickListener(new ClickListenerForUser(this));
		ourServicesTv.setOnClickListener(new ClickListenerForUser(this));
		//tvAbout.setOnClickListener(new CustomOnClickListener(this));
		reachUsTv.setOnClickListener(new ClickListenerForUser(this));	
	}

}
