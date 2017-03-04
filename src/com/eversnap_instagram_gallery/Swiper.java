package com.eversnap_instagram_gallery;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class Swiper extends FragmentActivity {
	ViewPager pager;
	 MyPagerAdapter viii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiper);     

        
         viii=new MyPagerAdapter(getSupportFragmentManager());
         pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(viii);
        
        
        
        
        
    }

    
    
    public void switcher(View v)
    {
    	 Intent mainIntent = new Intent(this,MainActivity.class);
         Swiper.this.startActivity(mainIntent);
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
     
        public MyPagerAdapter(android.support.v4.app.FragmentManager fragmentManager) {
        	super(fragmentManager);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

            case 0: return Firstpage.newInstance("FirstFragment, Instance 1");
            case 1: return Secondpage.newInstance("SecondFragment, Instance 1");
            case 2: return Thirdpage.newInstance("ThirdFragment, Instance 1");
            
            default: return Thirdpage.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
            
            @Override
            public void restoreState(Parcelable arg0, ClassLoader arg1) {
                //do nothing here! no call to super.restoreState(arg0, arg1);
            }     

       

		
    }
}