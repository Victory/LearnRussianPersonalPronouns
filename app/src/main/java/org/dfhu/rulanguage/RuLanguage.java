package org.dfhu.rulanguage;

import java.util.ArrayList;
import java.util.List;

/**
 * this will be mocked with a POJO
 */
public class RuLanguage {
    private static List<RuWord> words;
    private static List<RuPhrase> phrases;

    private RuLanguage () {}

    public static RuWord getRandomWord () {
        setUpWordsAndPhrases();

        return words.get((int) (Math.random() * words.size()));
    }

    public static RuPhrase getRandomPhrase () {
        setUpWordsAndPhrases();

        return phrases.get((int) (Math.random() * phrases.size()));
    }

    /**
     * initializes the words if they have not been already
     */
    private static void setUpWordsAndPhrases() {
        if (words != null) {
            return;
        }

        words = new ArrayList<>();
        phrases = new ArrayList<>();
        RuPronoun I = new RuPronoun("Я", RuCase.NOM, "1st", RuPronoun.SING, RuGender.NA);
        words.add(I);
        phrases.add(new RuPhrase("я знаю", "I know", I));
        RuPronoun toMe = new RuPronoun("Меня", RuCase.ACU, "1st", RuPronoun.SING, RuGender.NA);
        words.add(toMe);
        phrases.add(new RuPhrase("Мне нравится рыба", "I like fish", toMe));

        words.add(new RuPronoun("Меня", RuCase.GEN, "1st", RuPronoun.SING, RuGender.NA));
        words.add(new RuPronoun("Мне", RuCase.DAT, "1st", RuPronoun.SING, RuGender.NA));
        words.add(new RuPronoun("Мной", RuCase.INS, "1st", RuPronoun.SING, RuGender.NA));
        words.add(new RuPronoun("Мне", RuCase.PRE, "1st", RuPronoun.SING, RuGender.NA));

        words.add(new RuPronoun("Ты", RuCase.NOM, "2nd", RuPronoun.SING_POSS, RuGender.NA));
        words.add(new RuPronoun("Тебя", RuCase.ACU, "2nd", RuPronoun.SING_POSS, RuGender.NA));
        words.add(new RuPronoun("Тебя", RuCase.GEN, "2nd", RuPronoun.SING_POSS, RuGender.NA));
        words.add(new RuPronoun("Тебе", RuCase.DAT, "2nd", RuPronoun.SING_POSS, RuGender.NA));
        words.add(new RuPronoun("Тобой", RuCase.INS, "2nd", RuPronoun.SING_POSS, RuGender.NA));
        words.add(new RuPronoun("Тебе", RuCase.PRE, "2nd", RuPronoun.SING_POSS, RuGender.NA));


        words.add(new RuPronoun("Моего", RuCase.GEN, "1st", RuPronoun.SING_POSS, RuGender.MAS));
        words.add(new RuPronoun("Моему", RuCase.DAT, "1st", RuPronoun.SING_POSS, RuGender.MAS));
        words.add(new RuPronoun("Моим", RuCase.INS, "1st", RuPronoun.SING_POSS, RuGender.MAS));
        words.add(new RuPronoun("Моём", RuCase.PRE, "1st", RuPronoun.SING_POSS, RuGender.MAS));

    }


}
