package org.dfhu.learnrussianpersonalpronouns;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class WhatCaseFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.what_case_fragment, container, false);

        view.findViewById(R.id.buttonNominative).setOnClickListener(this);
        view.findViewById(R.id.buttonAccusative).setOnClickListener(this);
        view.findViewById(R.id.buttonGenitive).setOnClickListener(this);
        view.findViewById(R.id.buttonDative).setOnClickListener(this);
        view.findViewById(R.id.buttonInstrumental).setOnClickListener(this);
        view.findViewById(R.id.buttonPrepositional).setOnClickListener(this);

        return view;
    }

    public static WhatCaseFragment newInstance ()
    {
        return new WhatCaseFragment();
    }

    @Override
    public void onClick(View view) {
        Log.d("tmp", "clicked a case");
        switch(view.getId()) {
            case R.id.buttonNominative:
                Toast.makeText(getActivity(), "Nominative", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
