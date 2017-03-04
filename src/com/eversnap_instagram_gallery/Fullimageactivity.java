package com.eversnap_instagram_gallery;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Fullimageactivity extends Activity {
ImageLoader io;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullimageactivity);
		String path = getIntent().getStringExtra("fullimage");
		ImageView img=(ImageView) findViewById(R.id.imageView5);
		io=ImageLoader.getInstance();
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));       	
		io.displayImage(path, img);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fullimageactivity, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Take appropriate action for each action item click
	    switch (item.getItemId()) {
	    case R.id.action_about:
	   Intent i=new Intent(this,Fragmentact.class);
	   i.putExtra("position", 1);
	   
	   startActivity(i);
	   
	        return true;
	    case R.id.action_help:
	    	Intent in=new Intent(this,Fragmentact.class);
	    	   in.putExtra("position", 2);
	    	   startActivity(in);

	        return true;
	    case R.id.action_info:
	    	Intent inn=new Intent(this,Fragmentact.class);
	 	   inn.putExtra("position", 3);
	 	   startActivity(inn);
	        return true;
	    
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

	
}
