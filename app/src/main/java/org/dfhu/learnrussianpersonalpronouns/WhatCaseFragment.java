package org.dfhu.learnrussianpersonalpronouns;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class WhatCaseFragment extends Fragment implements View.OnClickListener {

    private static RuWord ruWord;
    private static boolean foundTarget = true;
    private View theView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        theView = inflater.inflate(R.layout.what_case_fragment, container, false);

        theView.findViewById(R.id.buttonNominative).setOnClickListener(this);
        theView.findViewById(R.id.buttonAccusative).setOnClickListener(this);
        theView.findViewById(R.id.buttonGenitive).setOnClickListener(this);
        theView.findViewById(R.id.buttonDative).setOnClickListener(this);
        theView.findViewById(R.id.buttonInstrumental).setOnClickListener(this);
        theView.findViewById(R.id.buttonPrepositional).setOnClickListener(this);

        if (foundTarget) {
            foundTarget = false;
            setNewWord(theView);
        } else {
            setWord(theView);
        }

        return theView;
    }

    public static WhatCaseFragment newInstance ()
    {
        return new WhatCaseFragment();
    }

    private void setWord (View view) {
        TextView target = (TextView) view.findViewById(R.id.textTargetKeyword);
        target.setText(ruWord.getWord());
    }

    private void setNewWord (View view) {
        ruWord = RuLanguage.getRandomWord();
        setWord(view);
    }

    @Override
    public void onClick(View view) {
        foundTarget = true;
        Log.d("tmp", "clicked a case");
        switch(view.getId()) {
            case R.id.buttonNominative:
                foundTarget = RuCase.isCase(ruWord, RuCase.NOM);
                break;
            case R.id.buttonAccusative:
                foundTarget = RuCase.isCase(ruWord, RuCase.ACU);
                break;
            default:
                foundTarget = false;

        }

        if (foundTarget) {
            Toast.makeText(getActivity(), "Yup " + ruWord.getCase(), Toast.LENGTH_SHORT).show();
            setNewWord(theView);
        } else {
            Toast.makeText(getActivity(), "Sorry try again", Toast.LENGTH_SHORT).show();
        }
    }

}