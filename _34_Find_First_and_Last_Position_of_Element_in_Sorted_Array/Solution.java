package _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, target);
        res[1] = binarySearch(nums, target + 1) - 1;
        //数组中不存在target
        if (res[0] >= nums.length || nums[res[0]] != target)
            res = new int[]{-1, -1};
        return res;
    }

    //二分查找第一个大于等于target的位置
    //注意本题为了优化，当不存在符合要求的结果时，返回数组数组最大下标+1
    private int binarySearch(int[] nums, int target) {
        if (nums.length == 0)
            return nums.length;
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //if (l < nums.length)
        //    return l;
        return l;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) return res;
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        // nums中找不到target, 直接返回[-1,-1]
        if (r == nums.length || nums[r] != target) return res;
        res[0] = r;
        // 此时不用改动l的值，继续往l右边段进行二分即可
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid;
        }
        res[1] = r - 1;
        return res;
    }
}
