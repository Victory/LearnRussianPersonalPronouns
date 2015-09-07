package org.dfhu.learnrussianpersonalpronouns;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.dfhu.rulanguage.RuLanguage;
import org.dfhu.rulanguage.RuPronoun;
import org.w3c.dom.Text;

public class FlashCardsFragment extends Fragment implements View.OnClickListener {

    private View theView;
    private Button theButton;
    private static RuPronoun ruWord;
    private TextView flashCardAnswer;
    private Boolean isFrontView = true;
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        theView = inflater.inflate(R.layout.flash_cards_fragment, container, false);

        if (savedInstanceState == null) {
            isFrontView = true;
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.flashCardFragment, new CardFrontFragment())
                    .commit();
        }

        final FrameLayout clicky = (FrameLayout) theView.findViewById(R.id.flashCardFragment);
        clicky.findViewById(R.id.flashCardFront);

        clicky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFrontView) {
                    flipCard();
                } else {
                    getChildFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flashCardFragment, new CardFrontFragment())
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
                .replace(R.id.flashCardFragment, new CardBackFragment())
                .addToBackStack(null)
                .commit();

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

    static public class CardFrontFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.flash_cards_front, container, false);
        }
    }

    static public class CardBackFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.flash_cards_back, container, false);
        }
    }
}
