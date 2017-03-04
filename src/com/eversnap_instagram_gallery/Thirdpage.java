package com.eversnap_instagram_gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Thirdpage extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.activity_thirdpage, container, false);

    TextView tv = (TextView) v.findViewById(R.id.tvFragThird);      

    return v;
}



public static Thirdpage newInstance(String text) {

	Thirdpage f = new Thirdpage();
    Bundle b = new Bundle();
    b.putString("msg", text);

    f.setArguments(b);

    return f;
}
}