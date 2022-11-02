package _72_Edit_Distance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;
        dp[0][0] = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int equal = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    equal = dp[i - 1][j - 1];
                int insert = 1 + dp[i][j - 1];
                int delete = 1 + dp[i - 1][j];
                int replace = 1 + dp[i - 1][j - 1];

                dp[i][j] = Math.min(Math.min(equal, insert), Math.min(delete, replace));
            }
        }
        return dp[len1][len2];
    }
}
