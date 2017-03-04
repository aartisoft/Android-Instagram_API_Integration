package com.eversnap_instagram_gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Secondpage extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.activity_secondpage, container, false);

    TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);

    return v;
}

public static Secondpage newInstance(String text) {

    Secondpage f = new Secondpage();
    Bundle b = new Bundle();
    b.putString("msg", text);

    f.setArguments(b);

    return f;
}
}