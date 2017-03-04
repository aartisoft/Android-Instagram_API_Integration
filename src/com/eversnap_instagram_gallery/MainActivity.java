package com.eversnap_instagram_gallery;

import com.eversnap_instagram_gallery.InstagramApp.OAuthAuthenticationListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener 
{
	
	//client id from instagram developers
	
	public static final String CLIENT_ID = "530c5b54fb074b50894321083f7c2435";
    public static final String CLIENT_SECRET = "d40d44b1d54441acbdcffb3732de4ee4";
    public static final String CALLBACK_URL = "http://localhost";
    public static final String ACCESS_TOKEN="1302982602.530c5b5.f4a96a9c211c40e1b91ecaef0891e643";
    private InstagramApp instaObj;
	GridView gd;
	Button b;
	Imageadapter vv;
	int wait=0;
	
public void onCreate(Bundle savedInstanceState)
{
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     b=(Button)findViewById(R.id.button1);
     b.setVisibility(View.INVISIBLE);
     b.setOnClickListener(this);
     
    
     
	 OAuthAuthenticationListener listener = new OAuthAuthenticationListener() {
    
         @Override
         public void onSuccess() {

             Log.e("Userid", instaObj.getId());
             Log.e("Name", instaObj.getName());
             Log.e("UserName", instaObj.getUserName());
             Log.e("picture", instaObj.getUserPicture());
         }

         @Override
         public void onFail(String error) {
             Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT)
                     .show();
         }
     };
	
     
        // Instagram Implementation

            instaObj = new InstagramApp(this, CLIENT_ID,
                    CLIENT_SECRET, CALLBACK_URL);
            instaObj.setListener(listener);


             

            
            gd=(GridView) findViewById(R.id.gridview1);
            instaObj.authorize();
            b.setVisibility(View.VISIBLE);
            
            
            gd.setOnItemClickListener(new OnItemClickListener()
        	{

        		@Override
        		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        			// TODO Auto-generated method stub
        			Intent full=new Intent(MainActivity.this,Fullimageactivity.class);
        			full.putExtra("fullimage",instaObj.standardurl.get(position) );
        			Toast.makeText(MainActivity.this, instaObj.standardurl.get(position), Toast.LENGTH_SHORT).show();
        			startActivity(full);
        		}

        	});
           
           wait=1;
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);

    return super.onCreateOptionsMenu(menu);
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





public void onClick(View v)
{
	
	  
	
      
	 if(wait==1)
    gd.setAdapter(new Imageadapter(MainActivity.this,instaObj.urls(),instaObj.standardurl));
	 else
		 Toast.makeText(this, "Wait for the Images to load",Toast.LENGTH_SHORT).show();
    
   

}
	
	
}