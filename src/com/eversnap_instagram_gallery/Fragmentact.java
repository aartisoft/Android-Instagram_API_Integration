package com.eversnap_instagram_gallery;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;


public class Fragmentact extends Activity {

	static int v=1;
	public void onCreate(Bundle savedInstanceState) {  
		super.onCreate(savedInstanceState);  	
		 setContentView(R.layout.activity_fragmentact);
        	
       
		Intent i = getIntent();
		 v=i.getIntExtra("position",1);
	
	
	
		//public  void setup()
		
		
			  
		FragmentManager fm = getFragmentManager();
		
		         FragmentTransaction fragmentTransaction = fm.beginTransaction();
		         fragmentTransaction.add(Fragmentone.newInstance(), "123");
		         fragmentTransaction.add(Fragmenttwo.newInstance(), "234");

		         fragmentTransaction.add(Fragmentthree.newInstance(), "345");

		         if(v==1){
		        	
			        // fragmentTransaction.replace(R.id.fragment1, Fragmentone.newInstance());
			        // fragmentTransaction.commit();

		         }
		if(v==2){
			 Fragment f=getFragmentManager().findFragmentByTag("123");
        	 if(f!=null)
        		 fragmentTransaction.remove(f);
		         fragmentTransaction.replace(R.id.fragment1, Fragmenttwo.newInstance());
		         fragmentTransaction.commit();

		}
		if(v==3){
			 Fragment f=getFragmentManager().findFragmentByTag("123");
        	 if(f!=null)
        		 fragmentTransaction.remove(f);
	         fragmentTransaction.replace(R.id.fragment1, Fragmentthree.newInstance());

		         fragmentTransaction.commit();
		}
		
		

}		

}

