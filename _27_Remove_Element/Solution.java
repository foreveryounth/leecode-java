package _27_Remove_Element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int insertIdx = 0, searchIdx = 0;
        while (searchIdx < len) {
            if (nums[searchIdx] != val) {
                nums[insertIdx++] = nums[searchIdx];
            }
            searchIdx++;
        }
        return insertIdx;
    }
}
