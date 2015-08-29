package org.dfhu.learnrussianpersonalpronouns;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.dfhu.rulanguage.RuCase;
import org.dfhu.rulanguage.RuLanguage;
import org.dfhu.rulanguage.RuPronoun;

public class WhatCaseFragment extends Fragment implements View.OnClickListener {

    private static RuPronoun ruWord;
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
        ruWord = (RuPronoun) RuLanguage.getRandomWord();
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
            case R.id.buttonGenitive:
                foundTarget = RuCase.isCase(ruWord, RuCase.GEN);
                break;
            case R.id.buttonDative:
                foundTarget = RuCase.isCase(ruWord, RuCase.DAT);
                break;
            case R.id.buttonInstrumental:
                foundTarget = RuCase.isCase(ruWord, RuCase.INS);
                break;
            case R.id.buttonPrepositional:
                foundTarget = RuCase.isCase(ruWord, RuCase.PRE);
                break;
            default:
                foundTarget = false;

        }

        if (foundTarget) {
            Toast.makeText(getActivity(),
                    "Yup '" + ruWord.getWord() + "' is " + ruWord.getCase() + ", " + ruWord.getType() + ", " + ruWord.getGender(),
                    Toast.LENGTH_SHORT).show();

            setNewWord(theView);
        } else {
            Toast.makeText(getActivity(), "Sorry try again", Toast.LENGTH_SHORT).show();
        }
    }

}
