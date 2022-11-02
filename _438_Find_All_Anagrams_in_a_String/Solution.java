package _438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] diff = new int[32];
        int diffCount = 0;


        for (int i = 0; i < p.length(); i++) {
            diff[s.charAt(i) - 'a']++;
            diff[p.charAt(i) - 'a']--;
        }
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] != 0)
                diffCount++;
        }
        if (diffCount == 0)
            res.add(0);

        for (int i = 0; i < s.length() - p.length(); i++) {
            if (diff[s.charAt(i) - 'a'] == 1)
                diffCount--;
            else if (diff[s.charAt(i) - 'a'] == 0)
                diffCount++;
            diff[s.charAt(i) - 'a']--;

            if (diff[s.charAt(i + p.length()) - 'a'] == -1)
                diffCount--;
            else if (diff[s.charAt(i + p.length()) - 'a'] == 0)
                diffCount++;
            diff[s.charAt(i + p.length()) - 'a']++;
            if (diffCount == 0)
                res.add(i + 1);
        }
        return res;
    }
}
