package org.dfhu.learnrussianpersonalpronouns;

/**
 * mocked with a POJO
 */
public class RuWord {
    private final String theCase;
    private final String theWord;
    private final String thePOV;

    public RuWord(String theWord, String theCase, String thePOV) {
        this.theWord = theWord;
        this.theCase = theCase;
        this.thePOV = thePOV;
    }

    public String getWord() {
        return theWord;
    }

    public String getCase() {
        return theCase;
    }

    public String getPOV() {
        return thePOV;
    }

}
