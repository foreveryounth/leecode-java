package _78_Subsets;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            //add subset(i) to res
            boolean[] isAdd = new boolean[nums.length];
            addSubSet(nums, isAdd, i, 0);
        }
        return res;
    }

    private void addSubSet(int[] nums, boolean[] isAdd, int addNum, int cur) {
        if (addNum <= 0) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (isAdd[i]) {
                    linkedList.add(nums[i]);
                }
            }
            res.add(linkedList);
        } else if (cur < nums.length) {
            boolean[] add = isAdd.clone();
            add[cur] = true;
            addSubSet(nums, add, addNum - 1, cur + 1);
            addSubSet(nums, isAdd.clone(), addNum, cur + 1);
        }
    }
}
