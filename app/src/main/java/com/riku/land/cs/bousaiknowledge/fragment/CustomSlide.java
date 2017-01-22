package com.riku.land.cs.bousaiknowledge.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.riku.land.cs.bousaiknowledge.R;
import com.riku.land.cs.bousaiknowledge.activity.MainActivity;

/**
 * @author Vlonjat Gashi (vlonjatg)
 */
public class CustomSlide extends Fragment {
    final String TAG = "CustomSlide";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_custom_slide, container, false);
        Button signInButton = (Button) rootView.findViewById(R.id.sign_in_button);
        Button signUpButton = (Button) rootView.findViewById(R.id.sign_up_button);
        Button debugButton = (Button) rootView.findViewById(R.id.debug_button);

        final FragmentTransaction transaction=getFragmentManager().beginTransaction();

        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        /*signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction.add(R.id.fragmentContainer,new SignInFragment());
                transaction.commit();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction.add(R.id.fragmentContainer,new SignUpFragment());
                transaction.commit();
            }
        });*/
        return rootView;
    }
}
