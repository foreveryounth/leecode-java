package _28_Find_the_Index_of_the_First_Occurrence_in_a_String;

public class Solutioin {
    public int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = new int[p.length];
        for (int i = 1, j = 0; i < p.length; i++) {
            while (j > 0 && p[i] != p[j])
                j = next[j - 1];
            if (p[i] == p[j])
                j++;
            next[i] = j;
        }

        for (int i = 0, j = 0; i < s.length; i++) {
            while (j > 0 && s[i] != p[j])
                j = next[j - 1];
            if (s[i] == p[j])
                j++;
            if (j == p.length) {
                return i - p.length + 1;
            }
        }
        return -1;
    }
}
