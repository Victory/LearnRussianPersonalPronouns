package org.dfhu.learnrussianpersonalpronouns;

import java.util.ArrayList;
import java.util.List;

/**
 * this will be mocked with a POJO
 */
public class RuLanguage {
    private static List<RuWord> words;

    private RuLanguage () {}

    public static RuWord getRandomWord () {
        setUpWords();

        return words.get((int) (Math.random() * words.size()));
    }

    /**
     * initializes the words if they have not been already
     */
    private static void setUpWords () {
        if (words != null) {
            return;
        }

        words = new ArrayList<>();
        words.add(new RuPronoun("Я", RuCase.NOM, "1st", RuPronoun.SING));
        words.add(new RuPronoun("Меня", RuCase.ACU, "1st", RuPronoun.SING));
        words.add(new RuPronoun("Моего", RuCase.GEN, "1st", RuPronoun.SING_POSS));
        words.add(new RuPronoun("Моему", RuCase.DAT, "1st", RuPronoun.SING_POSS));
        words.add(new RuPronoun("Моим", RuCase.INS, "1st", RuPronoun.SING_POSS));
        words.add(new RuPronoun("Моём", RuCase.PRE, "1st", RuPronoun.SING_POSS));
    }


}
