class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        for (String g : goal) {
            if (idx1 < cards1.length && g.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < cards2.length && g.equals(cards2[idx2])) {
                idx2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
/*
1. for-goal
2. cards1[idx1] == goal -> idx++;
3. cards2[idx2] == goal -> idx++;
4. cards1[idx1] cards[idx2] 둘 다 goal 이랑 다르면 no
*/