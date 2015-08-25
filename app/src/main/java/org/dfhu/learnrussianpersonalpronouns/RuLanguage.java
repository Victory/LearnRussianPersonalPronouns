package org.dfhu.learnrussianpersonalpronouns;

import java.util.ArrayList;
import java.util.List;

/**
 * this will be mocked with a POJO
 */
public class RuLanguage {
    private List<RuWord> words = new ArrayList<>();

    public RuLanguage () {
        words.add(new RuWord("Я", "Nominative", "1st"));
        words.add(new RuWord("Меня", "Accusative", "1st"));
    }

    public RuWord getRandomWord () {
        return words.get((int) (Math.random() * words.size()));
    }


}
