package _31_Next_Permutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (i = len - 2; i > -1; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }
        if (i > -1) {
            //在l,r之间二分查找最后一个>target
            int l = i + 1, r = len - 1;
            int target = nums[i], mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (nums[mid] < target) {
                    r = mid - 1;
                } else if (nums[mid] > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            //由于本题限制，结果必然存在
            int j = r;
            if (nums[j] > nums[i]) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp;
        for (int start = i + 1, end = len - 1; start < end; start++, end--) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}
