package com.eversnap_instagram_gallery;

import java.lang.reflect.Field;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmenttwo extends Fragment
{
	public static Fragment newInstance() 
	{
	    Fragmenttwo myFragment = new Fragmenttwo();
	    return myFragment;
	}
	
	
	public View onCreateView(LayoutInflater inflater,
			
			      ViewGroup container, Bundle savedInstanceState) {
			
			       
			
			       //Inflate the layout for this fragment
			
			        
			
			      return inflater.inflate(
			
			              R.layout.activity_fragmentone, container, false);
			
			   }
	
	
	@Override
	public void onDetach() {
	    super.onDetach();

	    try {
	        Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
	        childFragmentManager.setAccessible(true);
	        childFragmentManager.set(this, null);

	    } catch (NoSuchFieldException e) {
	        throw new RuntimeException(e);
	    } catch (IllegalAccessException e) {
	        throw new RuntimeException(e);
	    }
	}

	
}