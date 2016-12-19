package finalproject;

public class Words {
    // -------------------------------------------------
    // Treebank Tags
    // -------------------------------------------------
    // Note: this is here mostly to help me keep track of what I needed to account for.
    public enum TreebankTags {
        CC ("CD", "Coordinating Conjunction", Words.CC_WORDS),
        //CD ("Misc", "Cardinal Number"),
        DT ("DT", "Determiner", Words.DT_WORDS),
        DTS ("DT", "Determiner", Words.PLURAL_DT_WORDS),
        //EX ("Misc", "Existential There"),
        //FW ("Misc", "Foreign Word"),
        IN ("IN", "Preposition", Words.IN_WORDS),
        JJ ("JJ", "Adjective", Words.JJ_WORDS),
        JJR ("JJ", "Comparative Adjective", Words.JJR_WORDS),
        JJS ("JJS", "Superlative Adjective", Words.JJS_WORDS),
        //LS ("Misc", "List Item Marker"),
        //MD ("Misc", "Modal"),
        NN ("NN", "Singular Noun", Words.NN_WORDS),
        NNS ("NNS", "Plural Noun", Words.NNS_WORDS),
        NNP ("NNP", "Proper Singular Noun", Words.NNP_WORDS),
        NNPS ("NNPS", "Proper Plural Noun", Words.NNPS_WORDS),
        //PDT ("Determiner", "Predeterminer", PDT_WORDS),
        //POS ("Misc", "Possessive Ending"),
        //PRP ("Noun", "Personal Pronoun"),
        //PRPS ("Noun", "Possessive Pronoun"),
        RB ("RB", "Adverb", Words.RB_WORDS),
        RBR ("RBR", "Comparative Adverb", Words.RBR_WORDS),
        RBS ("RBS", "Superlative Adverb", Words.RBS_WORDS),
        //RP ("Misc", "Particle"),
        //SYM ("Misc", "Symbol"),
        TO ("TO", "to", Words.TO_WORDS),
        //UH ("Misc", "Interjection"),
        VB ("VB", "Verb", Words.VB_WORDS),
        VBD ("VBD", "Past Tense Verb", Words.VBD_WORDS),
        VBG ("VBG", "Gerund / Present Participle", Words.VBG_WORDS),
        VBN ("VBN", "Past Participle", Words.VBN_WORDS),
        VBP ("VBP", "Singular Present (Non-3rd Person) Verb", Words.VBP_WORDS),
        VBZ ("VBZ", "Singular Present (3rd Person) Verb", Words.VBZ_WORDS),
        //WDT ("Determiner", "wh-determiner"),
        //WP ("Noun", "Wh-pronoun"),
        //WPS ("Noun", "Possessive wh-pronoun"),
        //WRB ("Adverb", "Wh-adverb"),
        PU ("Misc", "Punctuation", Words.PU_WORDS);

        private final String tag;
        private final String name;
        private final String[] exampleWords;

        private TreebankTags (String t, String n, String[] words) {
            tag = t;
            name = n;
            exampleWords = words;
        }
    }

    // -------------------------------------------------
    // Word Lists
    // -------------------------------------------------

    //private static String[] _WORDS = {""};

    private static String[] CC_WORDS = {"and", "or"};

    //private static String[] CD_WORDS = {""};

    private static String[] DT_WORDS = {"a", /*"an",*/ "no", "the", "another", "each",
            "that","this", "any"};
    private static String[] PLURAL_DT_WORDS = {"every", "some", "either" /* Remove? */,
            "neither" /* Remove? */, "these", "those", "all", "both" };

    //private static String[] EX_WORDS = {""};
    //private static String[] FW_WORDS = {""};

    private static String[] IN_WORDS = {"in", "from", "with"};

    private static String[] JJ_WORDS = {"happy-go-lucky", "fourth", "fourth-largest",
            "superior", "nonhuman", "many", "higgildy-piggildy", "warm", "strange", "cozy"};
    private static String[] JJR_WORDS = {"better", "worse", "happier", "sadder"};
    private static String[] JJS_WORDS = {"best", "worst", "happiest", "saddest"};

    //private static String[] LS_WORDS = {""};
    //private static String[] MD_WORDS = {""};

    private static String[] NN_WORDS = {"science", "fiction", "slalom", "hootenanny",
            "kerfuffle", "inquisition"};
    private static String[] NNS_WORDS = {"primates", "tools", "aliens", "ponies",
            "players", "orcs", "conquistadors"};
    private static String[] NNP_WORDS = {"Adam Meyers", "New York University", "Brexit"};
    private static String[] NNPS_WORDS = {"Kardashians", "Obamas", "Kennedys", "Americas"};

    //private static String[] PDT_WORDS = {"all", "both", "half", "many", "nary", "quite", "rather", "such"};
    //private static String[] POS_WORDS = {""};
    //private static String[] PRP_WORDS = {""};
    //private static String[] PRPS_WORDS = {""};

    private static String[] RB_WORDS = {"badly", "a little", "well", "excitedly"};
    // public static String[] RB_WORDS_PROBLEM = {"quite", "too", "very"/*, "far", "n't"*/};
    private static String[] RBR_WORDS = {"worse", "farther", "less", "better"};
    private static String[] RBS_WORDS = {"worst", "farthest", "least", "best"};

    //private static String[] RP_WORDS = {""};
    //private static String[] SYM_WORDS = {""};

    private static String[] TO_WORDS = {"to"};

    //private static String[] UH_WORDS = {""};

    private static String[] VB_WORDS = {"expunge"};
    private static String[] VBD_WORDS = {"were"};
    private static String[] VBG_WORDS = {"asking"};
    private static String[] VBN_WORDS = {"looked"};
    private static String[] VBP_WORDS = {"eat", "do", "engage", "engulf", "enrage"};
    private static String[] VBZ_WORDS = {"eats", "does", "engages", "engulfs", "enrages"};

    //private static String[] WDT_WORDS = {""};
    //private static String[] WP_WORDS = {""};
    //private static String[] WPS_WORDS = {""};
    //private static String[] WRB_WORDS = {""};

    public static String[] PU_WORDS = {"."};


    // -------------------------------------------------
    // Word Getters
    // -------------------------------------------------
    public static String getCCWord() { return getRandomWordFromList(Words.CC_WORDS); }

    public static String getDTWord() { return getRandomWordFromList(Words.DT_WORDS); }

    public static String getPluralDTWord() { return getRandomWordFromList(Words.PLURAL_DT_WORDS); }

    public static String getINWord() { return getRandomWordFromList(Words.IN_WORDS); }

    // -------------------------------------------------
    // Adjective Getters
    // -------------------------------------------------

    public static String getJJWord() { return getRandomWordFromList(Words.JJ_WORDS); }

    public static String getJJRWord() { return getRandomWordFromList(Words.JJR_WORDS); }

    public static String getJJSWord() { return getRandomWordFromList(Words.JJS_WORDS); }

    // -------------------------------------------------
    // Noun Getters
    // -------------------------------------------------

    public static String getNNWord() { return getRandomWordFromList(Words.NN_WORDS); }

    public static String getNNSWord() { return getRandomWordFromList(Words.NNS_WORDS); }

    public static String getNNPWord() { return getRandomWordFromList(Words.NNP_WORDS); }

    public static String getNNPSWord() { return getRandomWordFromList(Words.NNPS_WORDS); }

    // -------------------------------------------------
    // Adverb Getters
    // -------------------------------------------------
    public static String getRBWord() { return getRandomWordFromList(Words.RB_WORDS); }

    public static String getRBRWord() { return getRandomWordFromList(Words.RBR_WORDS); }

    public static String getRBSWord() { return getRandomWordFromList(Words.RBS_WORDS); }


    // -------------------------------------------------
    // Verb Getters
    // -------------------------------------------------

    public static String getVBWord() { return getRandomWordFromList(Words.VB_WORDS); }

    public static String getVBPWord() { return getRandomWordFromList(Words.VBP_WORDS); }

    public static String getVBZWord() { return getRandomWordFromList(Words.VBZ_WORDS); }

    // -------------------------------------------------
    // Generic Word Getter
    // -------------------------------------------------
    public static String getWordFromTag(TreebankTags tag) {
        int i = (int) (Math.random() * tag.exampleWords.length);
        System.out.println("Getting word \"" + tag.exampleWords[i] + "\" for PoS " + tag.tag + ":" + tag.name);
        return tag.exampleWords[i];
    }

    private static String getRandomWordFromList(String[] wordList) {
        int i = (int) (Math.random() * wordList.length);
        return wordList[i];
    }

}
