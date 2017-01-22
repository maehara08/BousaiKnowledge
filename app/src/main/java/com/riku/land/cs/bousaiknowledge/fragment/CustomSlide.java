package com.riku.land.cs.bousaiknowledge.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.riku.land.cs.bousaiknowledge.R;

/**
 * @author Vlonjat Gashi (vlonjatg)
 */
public class CustomSlide extends Fragment {
    final String TAG = "CustomSlide";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom_slide, container, false);
        Button signInButton = (Button) rootView.findViewById(R.id.sign_in_button);
        Button signUpButton = (Button) rootView.findViewById(R.id.sign_up_button);

        return rootView;
    }
}
