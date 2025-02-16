package leetcode;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        Map<Character, Integer> current = new HashMap<>();
        while (right < s.length()) {
            char include = s.charAt(right++);
            current.put(include, current.getOrDefault(include, 0) + 1);

            while (current.get(include) > 1) {
                char exclude = s.charAt(left++);
                current.put(exclude, current.get(exclude) - 1);
            }

            max = Math.max(max, right - left);
        }
        return max;
    }
}
