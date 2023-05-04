class Solution1 {
    public String solution(String s, String skip, int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] skipSplit = skip.split("");
        for (String split : skipSplit) {
            alphabet = alphabet.replace(split, "");
        }

        String[] alphabetSplit = alphabet.split("");
        String[] sSplit = s.split("");
        StringBuilder answer = new StringBuilder();
        for (String str : sSplit) {
            String newString = alphabetSplit[(alphabet.indexOf(str) + index) % alphabetSplit.length];
            answer.append(newString);
        }
        return answer.toString();
    }
}

class Solution2 {
    public static String solution(String s, String skip, int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (char c : skip.toCharArray()) {
            alphabet = alphabet.replace(Character.toString(c), "");
        }

        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            int idx = (alphabet.indexOf(c) + index) % alphabet.length();
            answer.append(alphabet.charAt(idx));
        }
        return answer.toString();
    }
}