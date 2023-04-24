class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        for (String[] str : photo) {
            int sum = 0;
            for (String s : str) {
                if (findScore(name, s) != -1) {
                    sum += yearning[findScore(name, s)];
                }
            }
            answer[idx++] = sum;
        }
        return answer;
    }
    public int findScore(String[] name, String s) {
        for (int i = 0; i < name.length; i++) {
            if (s.equals(name[i])) {
                return i;
            }
        }
        return -1;
    }
}