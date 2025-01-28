import java.util.Arrays;

public class Q25_LongestCommonSubseq {
    int lcsUtilRec(String s1, String s2, int ind1, int ind2) {
        // Base case: If either of the strings reaches the end, return 0
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        // If the characters at the current indices are the same, increment the LCS
        // length
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + lcsUtilRec(s1, s2, ind1 - 1, ind2 - 1);
        }

        // If the characters are different, choose the maximum LCS length by either
        // skipping a character in s1 or skipping a character in s2
        else {
            return Math.max(lcsUtilRec(s1, s2, ind1 - 1, ind2), lcsUtilRec(s1, s2, ind1, ind2 - 1));
        }
    }

    int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Call the recursive function to find the LCS length
        return lcsUtilRec(s1, s2, n - 1, m - 1);
    }

    public static void main(String args[]) {
        Q25_LongestCommonSubseq dp = new Q25_LongestCommonSubseq();

        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println(dp.lcs(s1, s2));
    }
}
