package _516_Longest_Palindromic_Subsequence;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++)
            dp[i][i] = 1;

        for (int i = 0; i < len; i++) {
            int j = i + 1;
            if (j < len) {
                dp[i][j] = 1;
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
            }
        }

        for (int step = 3; step <= len; step++) {
            for (int i = 0; i < len; i++) {
                int j = i + step - 1;
                if (j < len) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
