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
import org.dfhu.rulanguage.RuPronoun;


public class FlashCardsFragment extends Fragment {

    private View theView;
    private static RuPronoun ruWord;
    private Boolean isFrontView = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        theView = inflater.inflate(R.layout.flash_cards_fragment, container, false);
        ruWord = (RuPronoun) RuLanguage.getRandomWord();

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
                if (isFrontView) {
                    flipCard();
                } else {
                    ruWord = (RuPronoun) RuLanguage.getRandomWord();
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
            textView.setText(ruWord.getWord());
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
            textView.setText(ruWord.getCase());
            return frameLayout;
        }
    }
}
