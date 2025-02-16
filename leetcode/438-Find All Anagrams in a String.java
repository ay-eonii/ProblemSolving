package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> current = new HashMap<>();
        while (right < s.length()) {
            char include = s.charAt(right++);
            if (need.containsKey(include)) {
                current.put(include, current.getOrDefault(include, 0) + 1);
                if (current.get(include).equals(need.get(include))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    answer.add(left);
                }

                char exclude = s.charAt(left++);
                if (need.containsKey(exclude)) {
                    if (current.get(exclude).equals(need.get(exclude))) {
                        valid--;
                    }
                    current.put(exclude, current.get(exclude) - 1);
                }
            }
        }

        return answer;
    }
}
