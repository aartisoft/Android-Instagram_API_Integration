package com.eversnap_instagram_gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Firstpage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_firstpage, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);

        return v;
    }

    public static Firstpage newInstance(String text) {

        Firstpage f = new Firstpage();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}