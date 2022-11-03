package Main;

import _32_Longest_Valid_Parentheses.Solution;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2};
        int res = solution.longestValidParentheses("()()))))()()(");
        System.out.println(res);
    }

    public int binarySearchOne() {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        int target = 1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < target)
                left = mid + 1;
            else if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

    public void binarySearch() {
        int[] nums = {9, 8, 7, 6, 5, 4, 3};
        int l = 2, r = 5, target = 7;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                r = mid - 1;
            } else if (nums[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
}
