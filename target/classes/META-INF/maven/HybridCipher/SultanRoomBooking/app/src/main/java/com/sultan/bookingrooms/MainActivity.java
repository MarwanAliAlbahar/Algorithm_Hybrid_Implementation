package com.sultan.bookingrooms;

import com.sultan.bookingrooms.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Integer[] imgid = {R.drawable.place1,R.drawable.place2,R.drawable.place3,R.drawable.place4,R.drawable.place5,R.drawable.place6};
	String[] price, location, place, description;
	private TextView ourServicesTv, companyInfoTv, reachUsTv;
	private Button btn1, btn2, btn3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		View navigationLayout = findViewById(R.id.navigation_layout);
	
		ourServicesTv = (TextView) navigationLayout.findViewById(R.id.ourservices_text);
		companyInfoTv = (TextView) navigationLayout.findViewById(R.id.info_text);
		reachUsTv = (TextView) navigationLayout.findViewById(R.id.reach_us_text);
		View packageLayout = findViewById(R.id.list);
		btn1 = (Button) packageLayout.findViewById(R.id.btn_book_beoforelogin1);
		btn2 = (Button) packageLayout.findViewById(R.id.btn_book_beoforelogin2);
		btn3 = (Button) packageLayout.findViewById(R.id.btn_book_beoforelogin3);
		
		initCallbacks();
	
	}
	private void initCallbacks() {

		ourServicesTv.setOnClickListener(new ClickListenerForUser(this));
		companyInfoTv.setOnClickListener(new ClickListenerForUser(this));
		reachUsTv.setOnClickListener(new ClickListenerForUser(this));
		btn1.setOnClickListener(new ClickListenerForUser(this));
		btn2.setOnClickListener(new ClickListenerForUser(this));
		btn3.setOnClickListener(new ClickListenerForUser(this));
		
	}
	
	

}
