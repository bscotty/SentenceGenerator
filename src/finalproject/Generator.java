package finalproject;

import finalproject.Words.TreebankTags;

public class Generator {

    /**
     * The Main Activity runs the sentence generator.
     */
    public static void main(String[] args) {
        Words.printSupportedPoS();
        if(args.length == 1) {
            Words.initFromCustomWB(args[0]);
        }

        String sentence = generateSentence();
        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
        sentence += Words.getWordFromTag(TreebankTags.PU);
        System.out.println();
        System.out.println(sentence);
    }

    /**
     * Generates a random sentence based on Penn Treebank constituency rules.
     *
     * @return a sentence stored in a String.
     */
    private static String generateSentence() {
        // Consider making it 3 for run-on sentences
        int i = (int) (Math.random() * 2);

        // Potentially need to separate NP and VP to plural vs singular.
        switch(i) {
            // S --> NP VP
            default:
            case 0: return generateSingularNounPhrase() + " " + generatePresentSingularVerbPhrase();
            case 1: return generatePluralNounPhrase() + " " + generatePresentPluralVerbPhrase();
            // S --> S CC S
            case 2: return generateSentence() + " " + Words.getWordFromTag(TreebankTags.CC) + " " + generateSentence();
        }
    }

    private static String generateSingularOrPluralNounPhrase() {
        int i = (int) (Math.random() * 2);
        switch(i) {
            default:
            case 0: return generateSingularNounPhrase();
            case 1: return generatePluralNounPhrase();
        }
    }

    /**
     * Generates a random noun phrase based on Penn Treebank constituency rules.
     * Note: This will always be a singular noun phrase.
     *
     * @return a singular noun phrase stored in a String.
     */
    private static String generateSingularNounPhrase() {
        int i = (int) (Math.random() * 8);
        switch(i) {
            // NP --> DT NN
            default:
            case 0: return Words.getWordFromTag(TreebankTags.DT) + " " + Words.getWordFromTag(TreebankTags.NN);
            // NP --> NNP
            case 1: return Words.getWordFromTag(TreebankTags.NNP);

            // NP --> DT ADJP NN
            case 2: return Words.getWordFromTag(TreebankTags.DT) + " " + generateAdjectivePhrase() + " "
                    + Words.getWordFromTag(TreebankTags.NN);
            // NP --> DT JJR NN
            case 3: return Words.getWordFromTag(TreebankTags.DT) + " " + Words.getWordFromTag(TreebankTags.JJR) + " "
                    + Words.getWordFromTag(TreebankTags.NN);
            // NP --> DT JJS NN
            case 4: return Words.getWordFromTag(TreebankTags.DT) + " " + Words.getWordFromTag(TreebankTags.JJS) + " "
                    + Words.getWordFromTag(TreebankTags.NN);

            // NP --> ADJP NNP
            case 5: return generateAdjectivePhrase() + " " + Words.getWordFromTag(TreebankTags.NNP);
            // NP --> DT JJR NNP
            case 6: return Words.getWordFromTag(TreebankTags.DT) + " " + Words.getWordFromTag(TreebankTags.JJR) + " "
                    + Words.getWordFromTag(TreebankTags.NNP);
            // NP --> DT JJS NNP
            case 7: return Words.getWordFromTag(TreebankTags.DT) + " " + Words.getWordFromTag(TreebankTags.JJS) + " "
                    + Words.getWordFromTag(TreebankTags.NNP);
        }
    }

    /**
     * Generates a random noun phrase based on Penn Treebank constituency rules.
     * Note: This will always be a plural noun phrase.
     *
     * @return a plural noun phrase stored in a String.
     */
    private static String generatePluralNounPhrase() {
        int i = (int) (Math.random() * 12);
        switch(i) {
            // NP --> DT NNS
            default:
            case 0: return Words.getWordFromTag(TreebankTags.DTS) + " " + Words.getWordFromTag(TreebankTags.NNS);
            // NP --> DT NNPS
            case 1: return Words.getWordFromTag(TreebankTags.DTS) + " " + Words.getWordFromTag(TreebankTags.NNPS);
            // NP --> NNPS
            case 2: return Words.getWordFromTag(TreebankTags.NNPS);
            // NP --> DT ADJP NNS
            case 3: return Words.getWordFromTag(TreebankTags.DTS) + " " + generateAdjectivePhrase() + " "
                    + Words.getWordFromTag(TreebankTags.NNS);
            // NP --> DT JJR NNS
            case 4: return Words.getWordFromTag(TreebankTags.DTS) + " " + Words.getWordFromTag(TreebankTags.JJR) + " "
                    + Words.getWordFromTag(TreebankTags.NNS);
            // NP --> DT JJS NNS
            case 5: return Words.getWordFromTag(TreebankTags.DTS) + " " + Words.getWordFromTag(TreebankTags.JJS) + " "
                    + Words.getWordFromTag(TreebankTags.NNS);

            // NP --> DT ADJP NNPS
            case 6: return Words.getWordFromTag(TreebankTags.DTS) + " " + generateAdjectivePhrase() + " " + Words.getWordFromTag(TreebankTags.NNPS);
            // NP --> ADJP NNPS
            case 7: return generateAdjectivePhrase() + " " + Words.getWordFromTag(TreebankTags.NNPS);

            // NP --> DT JJR NNPS
            case 8: return Words.getWordFromTag(TreebankTags.DTS) + " " + Words.getWordFromTag(TreebankTags.JJR) + " "
                    + Words.getWordFromTag(TreebankTags.NNPS);
            // NP --> JJR NNPS
            case 9: return Words.getWordFromTag(TreebankTags.JJR) + " " + Words.getWordFromTag(TreebankTags.NNPS);
            // NP --> DT JJS NNPS
            case 10: return Words.getWordFromTag(TreebankTags.DTS) + " " + Words.getWordFromTag(TreebankTags.JJS) + " "
                    + Words.getWordFromTag(TreebankTags.NNPS);
            // -- Plural Only NP --> NP CC NP
            case 11: return generateSingularOrPluralNounPhrase() + " " + Words.getWordFromTag(TreebankTags.CC) + " "
                    + generateSingularOrPluralNounPhrase();
        }
    }

    /**
     *
     */
    private static String generateAdjectivePhrase() {
        // Keep is so that recursive ADJPs occur infrequently, and the other options occur an equal amount.
        int i = (int) (Math.random() * 7);
        switch(i) {
            default:
                // ADJP --> JJ
            case 0: case 3: case 5: Words.getWordFromTag(TreebankTags.JJ);
            // ADJP --> RB JJ
            case 1: case 4: case 6: return Words.getWordFromTag(TreebankTags.RB) + " "
                    + Words.getWordFromTag(TreebankTags.JJ);
            // ADJP --> ADJP CC ADJP
            case 2: return generateAdjectivePhrase() + " " + Words.getWordFromTag(TreebankTags.CC) + " "
                    + generateAdjectivePhrase();
        }
    }

    /**
     * Generate a prepositional phrase based on Penn Treebank constituency rules.
     *
     * @return a preopositional phrase stored in a String.
     */
    private static String generatePrepositionalPhrase() {
        return Words.getWordFromTag(TreebankTags.IN) + " " + generateSingularOrPluralNounPhrase();
    }

    /**
     * Generate a verb phrase based on Penn Treebank constituency rules.
     * Note: the verb phrase will always be singular.
     *
     * @return a verb phrase stored in a String.
     */
    private static String generatePresentSingularVerbPhrase() {
        int i = (int) (Math.random() * 8);
        switch(i) {
            // VP --> VBZ
            default:
            case 0: return Words.getWordFromTag(TreebankTags.VBZ);
            // VP --> VBZ NP
            case 1: return Words.getWordFromTag(TreebankTags.VBZ) + " " + generateSingularOrPluralNounPhrase();
            // VP --> VBZ PP
            case 2: return Words.getWordFromTag(TreebankTags.VBZ) + " " + generatePrepositionalPhrase();
            // VP --> VBZ RB
            case 3: return Words.getWordFromTag(TreebankTags.VBZ) + " " + Words.getWordFromTag(TreebankTags.RB);
            // VP --> VBZ NP RB
            case 4: return Words.getWordFromTag(TreebankTags.VBZ) + " " + generateSingularOrPluralNounPhrase() + " "
                    + Words.getWordFromTag(TreebankTags.RB);
            // VP --> VBZ RB PP
            case 5: return Words.getWordFromTag(TreebankTags.VBZ) + " " + Words.getWordFromTag(TreebankTags.RB) + " "
                    + generatePrepositionalPhrase();
            // VP --> VBZ RBR PP
            case 6: return Words.getWordFromTag(TreebankTags.VBZ) + " " + Words.getWordFromTag(TreebankTags.RBR) + " "
                    + generatePrepositionalPhrase();
            // VP --> VBZ RBS PP
            case 7: return Words.getWordFromTag(TreebankTags.VBZ) + " " + Words.getWordFromTag(TreebankTags.RBS) + " "
                    + generatePrepositionalPhrase();
        }
    }

    /**
     * Generate a verb phrase based on Penn Treebank constituency rules.
     * Note: the verb phrase will always be plural.
     *
     * @return a verb phrase stored in a String.
     */
    private static String generatePresentPluralVerbPhrase() {
        int i = (int) (Math.random() * 8);
        switch(i) {
            // VP --> VBP
            default:
            case 0:  return Words.getWordFromTag(TreebankTags.VBP);
            // VP --> VBP NN
            case 1: return Words.getWordFromTag(TreebankTags.VBP) + " " + generateSingularOrPluralNounPhrase();
            // VP --> VBP PP
            case 2: return Words.getWordFromTag(TreebankTags.VBP) + " " + generatePrepositionalPhrase();
            // VP --> VBP RB
            case 3: return Words.getWordFromTag(TreebankTags.VBP) + " " + Words.getWordFromTag(TreebankTags.RB);
            // VP --> VBP NP RB
            case 4: return Words.getWordFromTag(TreebankTags.VBP) + " " + generateSingularOrPluralNounPhrase() + " "
                    + Words.getWordFromTag(TreebankTags.RB);
            // VP --> VBP RB PP
            case 5: return Words.getWordFromTag(TreebankTags.VBP) + " " + Words.getWordFromTag(TreebankTags.RB) + " "
                    + generatePrepositionalPhrase();
            // VP --> VBP RBR PP
            case 6: return Words.getWordFromTag(TreebankTags.VBP) + " " + Words.getWordFromTag(TreebankTags.RBR) + " "
                    + generatePrepositionalPhrase();
            // VP --> VBP RBS PP
            case 7: return Words.getWordFromTag(TreebankTags.VBP) + " " + Words.getWordFromTag(TreebankTags.RBS) + " "
                    + generatePrepositionalPhrase();
        }
    }

}
