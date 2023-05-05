class Solution {
    public int solution(String s) {
        char first = s.charAt(0);
        int firstInt = 1;
        int diffInt = 0;
        int answer = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != first) {
                diffInt++;
            } else {
                firstInt++;
            }
            if (firstInt == diffInt) {
                answer++;
                if (i + 1 < s.length()) {
                    first = s.charAt(i + 1);
                    firstInt = 1;
                    diffInt = 0;
                    i++;
                }
            }
        }
        if (firstInt != diffInt) {
            answer++;
        }
        return answer;
    }
}