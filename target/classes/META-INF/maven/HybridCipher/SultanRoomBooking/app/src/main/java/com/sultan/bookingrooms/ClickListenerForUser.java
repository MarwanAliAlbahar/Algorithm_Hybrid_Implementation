package com.sultan.bookingrooms;

import com.sultan.bookingrooms.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ClickListenerForUser implements OnClickListener {
	Activity context;
	
   public ClickListenerForUser(Activity context) {
	   this.context = context;
}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {

	      case R.id.home_text:
	        Intent intentHome = new Intent(context, MainActivity.class);
	        intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        context.startActivity(intentHome);
	        break;
	      case R.id.ourservices_text:
		        Intent intentService = new Intent(context, BookingAppServicesActivity.class);
		        intentService.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		       context.startActivity(intentService);
		        break;
	      case R.id.info_text:
		        Intent intentPrice = new Intent(context, AboutCompanyActivity.class);
		        intentPrice.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentPrice);
		        break;
	      case R.id.reach_us_text:
		        Intent intentContact = new Intent(context, ReachUsActivity.class);
		        intentContact.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentContact);
		        break;
		        
	      case R.id.btn_book_beoforelogin1:
		        Intent intentbtn1 = new Intent(context, UserRegisterOrSignInActivity.class);
		        intentbtn1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentbtn1);
		        break;
		        
	      case R.id.btn_book_beoforelogin2:
		        Intent intentbtn2 = new Intent(context, UserRegisterOrSignInActivity.class);
		        intentbtn2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentbtn2);
		        break;
		        
	      case R.id.btn_book_beoforelogin3:
		        Intent intentbtn3 = new Intent(context, UserRegisterOrSignInActivity.class);
		        intentbtn3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentbtn3);
		        break;
		        
	      case R.id.signin_btn_home:
		        Intent intentLoginHm = new Intent(context, UserSignInActivity.class);
		        intentLoginHm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentLoginHm);
		        break;
		        
		   case R.id.signup_btn_home:
		 		        Intent intentRegisterHm = new Intent(context, UserSignUpActivity.class);
		 		       intentRegisterHm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 		        context.startActivity(intentRegisterHm);
		 		        break;
		 		       
		   case R.id. user_signout:
		        Intent intentLogout = new Intent(context, MainActivity.class);
		        intentLogout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        context.startActivity(intentLogout);
		        break;
		 		        
		 		        
		default:
			break;
		}
		
	}

}
