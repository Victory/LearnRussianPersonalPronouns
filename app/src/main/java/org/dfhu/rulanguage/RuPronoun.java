package org.dfhu.rulanguage;

public class RuPronoun extends RuWord {
    private String theType;

    public static final String SING = "Singular";
    public static final String PLUR = "Plural";
    public static final String SING_POSS =  "Singular Possessive";
    public static final String PLUR_POSS =  "Plural Possessive";
    public static final String REF_SELF = "Reflexive (self)";
    public static final String REF_ONES_OWN = "Reflexive (one's own)";
    public static final String EMPH = "Emphatic";
    public static final String DEM = "Demonstrative";
    public static final String DETER = "Determinative";
    public static final String INTERR = "Interrogative";

    public RuPronoun(String theWord, String theCase, String thePOV, String theType, String theGender) {
        super(theWord, theCase, thePOV, theGender);
        this.theType = theType;
    }

    public String getType() {
        return this.theType;
    }
}
