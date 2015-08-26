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
        words.add(new RuWord("Я", RuCase.NOM, "1st"));
        words.add(new RuWord("Меня", RuCase.ACU, "1st"));
        words.add(new RuWord("Моего", RuCase.GEN, "1st"));
        words.add(new RuWord("Моему", RuCase.DAT, "1st"));
        words.add(new RuWord("Моим", RuCase.INS, "1st"));
        words.add(new RuWord("Моём", RuCase.PRE, "1st"));
    }


}
