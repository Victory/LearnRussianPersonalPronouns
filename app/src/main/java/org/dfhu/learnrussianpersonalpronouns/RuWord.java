package org.dfhu.learnrussianpersonalpronouns;

/**
 * mocked with a POJO
 */
public class RuWord {
    private final String theCase;
    private final String theWord;
    private final String thePOV;
    private final String theGender;

    public RuWord(String theWord, String theCase, String thePOV, String theGender) {
        this.theWord = theWord;
        this.theCase = theCase;
        this.thePOV = thePOV;
        this.theGender = theGender;
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

    public String getGender() {
        return this.theGender;
    }

}
