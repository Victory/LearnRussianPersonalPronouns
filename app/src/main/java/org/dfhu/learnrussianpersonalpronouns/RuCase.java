package org.dfhu.learnrussianpersonalpronouns;

/**
 * POJO for the six cases
 */
public class RuCase {
    public static final String NOM = "Nominative";
    public static final String ACU = "Accusative";
    public static final String GEN = "Genitive";
    public static final String DAT = "Dative";
    public static final String INS = "Instrumental";
    public static final String PRE = "Prepositional";

    public static boolean isCase(RuWord word, String theCase) {
        return word.getCase().equals(theCase);
    }
}
