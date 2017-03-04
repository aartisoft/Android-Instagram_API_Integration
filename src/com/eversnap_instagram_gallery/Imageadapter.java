package com.eversnap_instagram_gallery;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class Imageadapter extends BaseAdapter {
    private Context mContext;
   
    public ArrayList<Bitmap> bitmap;
	
	ImageLoader img;
	ArrayList <String>bbb;
	ArrayList <String>standard;
 
    // Keep all Images in array
    
 
    // Constructor
    
    
    public Imageadapter(Context c,ArrayList<String> bc,ArrayList<String> stan){
        mContext = c;
        bbb=new ArrayList<String>(bc);
        standard=new ArrayList<String>(stan);
         img=ImageLoader.getInstance();
Log.i("InstagramAPI","now   "+bbb.get(0));
ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(c));       	
        
    }
 
   
    
 
  
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        
    	
    	img.displayImage(bbb.get(position), imageView);
       // imageView.setImageBitmap(bmp);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
        return imageView;
    }
   
    	
		
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bbb.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return bitmap.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
 
    
}