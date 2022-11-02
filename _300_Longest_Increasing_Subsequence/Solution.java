package _300_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return 1;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return 1;
        }

        int[] minTail = new int[len + 1];
        int maxLen = 1;
        minTail[maxLen] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] > minTail[maxLen])
                minTail[++maxLen] = nums[i];
            else {
                int left = 1, right = maxLen, mid;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (minTail[mid] < nums[i])
                        left = mid + 1;
                    else
                        right = mid;
                }
                minTail[left] = nums[i];
            }
        }
        return maxLen;
    }
}
