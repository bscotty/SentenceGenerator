package finalproject;

import finalproject.Words.TreebankTags;

public class Generator {

    /**
     * The Main Actvitiy runs the sentence generator.
     */
    public static void main(String[] args) {
        String sentence = generateSentence();
        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
        sentence = sentence + Words.PU_WORDS[0];
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

        //TODO: Work on subject-verb number agreement.
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
            case 0: return Words.getDTWord() + " " + Words.getNNWord();
            // NP --> NNP
            case 1: return Words.getNNPWord();

            // NP --> DT ADJP NN
            case 2: return Words.getDTWord() + " " + generateAdjectivePhrase() + " " + Words.getNNWord();
            // NP --> DT JJR NN
            case 3: return Words.getDTWord() + " " + Words.getJJRWord() + " " + Words.getNNWord();
            // NP --> DT JJS NN
            case 4: return Words.getDTWord() + " " + Words.getJJSWord() + " " + Words.getNNWord();

            // NP --> ADJP NNP
            case 5: return generateAdjectivePhrase() + " " + Words.getNNPWord();
            // NP --> DT JJR NNP
            case 6: return Words.getDTWord() + " " + Words.getJJRWord() + " " + Words.getNNPWord();
            // NP --> DT JJS NNP
            case 7: return Words.getDTWord() + " " + Words.getJJSWord() + " " + Words.getNNPWord();
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
            case 0: return Words.getPluralDTWord() + " " + Words.getNNSWord();
            // NP --> DT NNPS
            case 1: return Words.getPluralDTWord() + " " + Words.getNNPSWord();
            // NP --> NNPS
            case 2: return Words.getNNPSWord();
            // NP --> DT ADJP NNS
            case 3: return Words.getPluralDTWord() + " " + generateAdjectivePhrase() + " " + Words.getNNSWord();
            // NP --> DT JJR NNS
            case 4: return Words.getPluralDTWord() + " " + Words.getJJRWord() + " " + Words.getNNSWord();
            // NP --> DT JJS NNS
            case 5: return Words.getPluralDTWord() + " " + Words.getJJSWord() + " " + Words.getNNSWord();

            // NP --> DT ADJP NNPS
            case 6: return Words.getPluralDTWord() + " " + generateAdjectivePhrase() + " " + Words.getNNPSWord();
            // NP --> ADJP NNPS
            case 7: return generateAdjectivePhrase() + " " + Words.getNNPSWord();

            // NP --> DT JJR NNPS
            case 8: return Words.getPluralDTWord() + " " + Words.getJJRWord() + " " + Words.getNNPSWord();
            // NP --> JJR NNPS
            case 9: return Words.getJJRWord() + " " + Words.getNNPSWord();
            // NP --> DT JJS NNPS
            case 10: return Words.getPluralDTWord() + " " + Words.getJJSWord() + " " + Words.getNNPSWord();
            // -- Plural Only NP --> NP CC NP
            case 11: return generateSingularOrPluralNounPhrase() + " " + Words.getWordFromTag(TreebankTags.CC) + " " + generateSingularOrPluralNounPhrase();
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
            case 0: case 3: case 5: return Words.getJJWord();
            // ADJP --> RB JJ
            case 1: case 4: case 6: return Words.getRBWord() + " " + Words.getJJWord();
            // ADJP --> ADJP CC ADJP
            case 2: return generateAdjectivePhrase() + " " + Words.getWordFromTag(TreebankTags.CC) + " " + generateAdjectivePhrase();
        }
    }

    /**
     * Generate a prepositional phrase based on Penn Treebank constituency rules.
     *
     * @return a preopositional phrase stored in a String.
     */
    private static String generatePrepositionalPhrase() {
        return Words.getINWord() + " " + generateSingularOrPluralNounPhrase();
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
            case 0: return Words.getVBZWord();
            // VP --> VBZ NP
            case 1: return Words.getVBZWord() + " " + generateSingularOrPluralNounPhrase();
            // VP --> VBZ PP
            case 2: return Words.getVBZWord() + " " + generatePrepositionalPhrase();
            // VP --> VBZ RB
            case 3: return Words.getVBZWord() + " " + Words.getRBWord();
            // VP --> VBZ NP RB
            case 4: return Words.getVBZWord() + " " + generateSingularOrPluralNounPhrase() + " " + Words.getRBWord();
            // VP --> VBZ RB PP
            case 5: return Words.getVBZWord() + " " + Words.getRBWord() + " " + generatePrepositionalPhrase();
            // VP --> VBZ RBR PP
            case 6: return Words.getVBZWord() + " " + Words.getRBRWord() + " " + generatePrepositionalPhrase();
            // VP --> VBZ RBS PP
            case 7: return Words.getVBZWord() + " " + Words.getRBSWord() + " " + generatePrepositionalPhrase();
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
            case 0:  return Words.getVBPWord();
            // VP --> VBP NN
            case 1: return Words.getVBPWord() + " " + generateSingularOrPluralNounPhrase();
            // VP --> VBP PP
            case 2: return Words.getVBPWord() + " " + generatePrepositionalPhrase();
            // VP --> VBP RB
            case 3: return Words.getVBPWord() + " " + Words.getRBWord();
            // VP --> VBP NP RB
            case 4: return Words.getVBPWord() + " " + generateSingularOrPluralNounPhrase() + " " + Words.getRBWord();
            // VP --> VBP RB PP
            case 5: return Words.getVBPWord() + " " + Words.getRBWord() + " " + generatePrepositionalPhrase();
            // VP --> VBP RBR PP
            case 6: return Words.getVBPWord() + " " + Words.getRBRWord() + " " + generatePrepositionalPhrase();
            // VP --> VBP RBS PP
            case 7: return Words.getVBPWord() + " " + Words.getRBSWord() + " " + generatePrepositionalPhrase();
        }
    }

}
