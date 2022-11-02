package Main;

import _438_Find_All_Anagrams_in_a_String.Solution;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{1};
        //System.out.println(solution.removeDuplicates(nums));
        //int len = solution.removeDuplicates(nums);
        //int[] res = solution.searchRange(nums, 1);
        System.out.println(solution.findAnagrams("cbaebabacd",
                "abc"));
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
}
