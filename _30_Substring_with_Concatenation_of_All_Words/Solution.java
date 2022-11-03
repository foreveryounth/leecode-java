package _30_Substring_with_Concatenation_of_All_Words;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int nums = words.length;
        int gap = words[0].length();
        int len = s.length();
        List<Integer> res = new ArrayList<>();
        //跳过S头部的i个字符
        for (int i = 0; i < gap; i++) {
            //1.比较长度
            if (nums * gap > len - i)
                continue;
            //2.遍历头部的字符
            Map<String, Integer> diff = new HashMap<>();
            //2.1update diff bases on String s
            for (int j = 0; j < nums; j++) {
                String sWord = s.substring(i + j * gap, i + j * gap + gap);
                diff.put(sWord, diff.getOrDefault(sWord, 0) + 1);
            }
            //2.2update diff bases on String words
            for (String word : words) {
                diff.put(word, diff.getOrDefault(word, 0) - 1);
                if (diff.get(word) == 0)
                    diff.remove(word);
            }
            if (diff.isEmpty())
                res.add(i);

            //3对该次循环遍历每个word
            for (int j = 0; j < (len - i) / gap - nums; j++) {
                int cur = i + j * gap + gap;
                String remove = s.substring(i + j * gap, i + j * gap + gap);
                String add = s.substring(i + j * gap + gap * nums, i + j * gap + gap * nums + gap);
                diff.put(remove, diff.getOrDefault(remove, 0) - 1);
                diff.put(add, diff.getOrDefault(add, 0) + 1);
                //修改diff
                if (diff.containsKey(remove) && diff.get(remove) == 0)
                    diff.remove(remove);
                if (diff.containsKey(add) && diff.get(add) == 0)
                    diff.remove(add);
                //加入res
                if (diff.isEmpty())
                    res.add(i + j * gap + gap);
            }
        }
        return res;
    }
}
