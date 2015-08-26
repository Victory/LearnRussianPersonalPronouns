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
         words.add(new RuWord("Я", "Nominative", "1st"));
         words.add(new RuWord("Меня", "Accusative", "1st"));
    }


}
