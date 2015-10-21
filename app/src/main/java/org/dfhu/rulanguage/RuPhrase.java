package org.dfhu.rulanguage;


/**
 * attaches a keyword and phrase
 */
public class RuPhrase {


    private String phrase;
    private RuWord keyWord;
    private String english;

    RuPhrase(String phrase, String english, RuWord keyWord) {
        this.phrase = phrase;
        this.keyWord = keyWord;
        this.english = english;
    }

    public RuWord getKeyWord() {
        return keyWord;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getEnglish () {
        return english;
    }
}
