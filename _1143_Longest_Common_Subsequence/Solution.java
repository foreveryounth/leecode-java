package _1143_Longest_Common_Subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String s1 = text1, s2 = text2;
        int len1 = s1.length(), len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            char ch1 = s1.charAt(i - 1);
            for (int j = 1; j < len2 + 1; j++) {
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
