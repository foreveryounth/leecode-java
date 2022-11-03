package _32_Longest_Valid_Parentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] str = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len];
        int maxlen = 0;

        for (int i = 1; i < len; i++) {
            if (str[i] == ')') {
                if (str[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (str[i - 1] == ')') {
                    if (i - 1 - dp[i - 1] >= 0 && str[i - 1 - dp[i - 1]] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - 2 - dp[i - 1] >= 0 && str[i - 2 - dp[i - 1]] == ')')
                            dp[i] += dp[i - 2 - dp[i - 1]];
                    }
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }
}
