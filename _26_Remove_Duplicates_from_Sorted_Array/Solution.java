package _26_Remove_Duplicates_from_Sorted_Array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int insertIdx = 0, searchIdx = 1;
        while (searchIdx < len) {
            if (nums[searchIdx] != nums[insertIdx]) {
                nums[++insertIdx] = nums[searchIdx];
            }
            searchIdx++;
        }
        return insertIdx + 1;
    }
}
