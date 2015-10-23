package org.dfhu.learnrussianpersonalpronouns;


import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.dfhu.rulanguage.RuLanguage;
import org.dfhu.rulanguage.RuPhrase;
import org.dfhu.rulanguage.RuPronoun;

import java.util.Date;


public class FlashCardsFragment extends Fragment {

    private View theView;
    private static RuPronoun ruWord;
    private Boolean isFrontView = true;
    private static RuPhrase ruPhrase;

    private static long nextValidClick = new Date().getTime();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        theView = inflater.inflate(R.layout.flash_cards_fragment, container, false);
        ruPhrase = RuLanguage.getRandomPhrase();

        if (savedInstanceState == null) {
            isFrontView = true;
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.flashCardFragment, CardFrontFragment.getInstance())
                    .commit();
        }

        final FrameLayout clicky = (FrameLayout) theView.findViewById(R.id.flashCardFragment);

        clicky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // thwart fast clickers
                long now = new Date().getTime();
                if (now < nextValidClick) {
                    return;
                } else {
                    nextValidClick =
                            now + getResources().getInteger(R.integer.card_flip_time_full) / 3;
                }

                if (isFrontView) {
                    flipCard();
                } else {
                    ruPhrase = RuLanguage.getRandomPhrase();
                    getChildFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flashCardFragment, CardFrontFragment.getInstance())
                            .commit();
                }
                isFrontView = !isFrontView;
            }
        });

        return theView;
    }


    private void flipCard () {
        getChildFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.card_flip_left_in, R.anim.card_flip_left_out,
                        R.anim.card_flip_right_in, R.anim.card_flip_right_out)
                .replace(R.id.flashCardFragment, CardBackFragment.getInstances())
                .addToBackStack(null)
                .commit();

    }

    public static FlashCardsFragment newInstance() {
        return new FlashCardsFragment();
    }

    static public class CardFrontFragment extends Fragment {

        public CardFrontFragment () {}

        public static CardFrontFragment getInstance() {
            return new CardFrontFragment();
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout frameLayout = (LinearLayout) inflater.inflate(R.layout.flash_cards_front, container, false);
            TextView textView = (TextView)frameLayout.findViewById(R.id.flashCardFront);
            textView.setText(ruPhrase.getWord().getWord());
            TextView phraseView = (TextView) frameLayout.findViewById(R.id.flashCardPhrase);
            phraseView.setText(ruPhrase.getPhrase());
            return frameLayout;
        }
    }

    static public class CardBackFragment extends Fragment {

        public static CardBackFragment getInstances () {
            return new CardBackFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout frameLayout = (LinearLayout) inflater.inflate(R.layout.flash_cards_back, container, false);
            TextView textView = (TextView)frameLayout.findViewById(R.id.flashCardBack);
            textView.setText(ruPhrase.getWord().getCase());
            TextView translationView = (TextView) frameLayout.findViewById(R.id.flashCardTranslation);
            translationView.setText(ruPhrase.getTranslation());
            return frameLayout;
        }
    }
}
