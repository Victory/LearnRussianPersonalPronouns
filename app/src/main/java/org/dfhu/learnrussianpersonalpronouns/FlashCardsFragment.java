package org.dfhu.learnrussianpersonalpronouns;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.dfhu.rulanguage.RuLanguage;
import org.dfhu.rulanguage.RuPronoun;

public class FlashCardsFragment extends Fragment implements View.OnClickListener {

    private View theView;
    private Button theButton;
    private static RuPronoun ruWord;
    private TextView flashCardAnswer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        theView = inflater.inflate(R.layout.flash_cards_fragment, container, false);

        theButton = (Button) theView.findViewById(R.id.buttonFlashCard);
        theButton.setOnClickListener(FlashCardsFragment.this);
        flashCardAnswer = (TextView) theView.findViewById(R.id.textFlashCardAnswer);
        flashCardAnswer.setVisibility(View.GONE);

        flashCardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashCardAnswer.setVisibility(View.GONE);

                ruWord = (RuPronoun) RuLanguage.getRandomWord();
                theButton.setText(ruWord.getWord());
                theButton.setVisibility(View.VISIBLE);
            }
        });

        ruWord = (RuPronoun) RuLanguage.getRandomWord();

        theButton.setText(ruWord.getWord());
        return theView;
    }


    @Override
    public void onClick(View view) {
        String msg = "Case: " + ruWord.getCase();
        flashCardAnswer.setText(msg);
        flashCardAnswer.setVisibility(View.VISIBLE);
        theButton.setVisibility(View.GONE);
    }

    public static FlashCardsFragment newInstance() {
        return new FlashCardsFragment();
    }
}
