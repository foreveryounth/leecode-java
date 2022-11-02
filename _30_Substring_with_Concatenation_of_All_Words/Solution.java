package _30_Substring_with_Concatenation_of_All_Words;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int nums = words.length;
        int gap = words[0].length();
        int len = s.length();
        List<Integer> res = new ArrayList<>();
        //跳过S头部的i个字符
        for (int i = 0; i < len; i++) {
            //比较长度
            if (nums * gap > len - i)
                continue;
            //遍历头部的字符
            Dictionary<String, Integer> diff = new Hashtable<>();
            int diffCount = 0;
            for (int j = 0; j < nums; j++) {
                String sWord = s.substring(i + j * gap, i + j * gap + gap);
                diff.put(sWord, diff.);
            }
            //对该次循环遍历每个word
            for (int j = 0; j < (len - i) / gap; j++) {

            }
            //修改diff
            //加入res
        }
    }
}
