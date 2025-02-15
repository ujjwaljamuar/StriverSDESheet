public class Q2_MergeStringAlternatively {
    String mergeAlternatively(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        int i = 0;

        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                s.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                s.append(word2.charAt(i));
            }

            i++;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Q2_MergeStringAlternatively lc = new Q2_MergeStringAlternatively();

        String word1 = "abc";
        String word2 = "pqrxyz";

        System.out.println(lc.mergeAlternatively(word1, word2));
    }
}
