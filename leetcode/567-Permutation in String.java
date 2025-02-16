package leetcode;

import java.util.HashMap;
import java.util.Map;

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (char s : s1.toCharArray()) {
            need.put(s, need.getOrDefault(s, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        Map<Character, Integer> current = new HashMap<>();
        char[] s2Array = s2.toCharArray();

        while (right < s2Array.length) {
            char include = s2Array[right++];
            if (need.containsKey(include)) {
                current.put(include, current.getOrDefault(include, 0) + 1);
                if (current.get(include).equals(need.get(include))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char exclude = s2Array[left++];
                if (need.containsKey(exclude)) {
                    if (current.get(exclude).equals(need.get(exclude))) {
                        valid--;
                    }
                    current.put(exclude, current.get(exclude) - 1);
                }
            }
        }

        return false;
    }
}
