class Solution {
    public int solution(int n, int m, int[] section) {
        int maxPoint = 0, cntPoint = 0;
        for (int point : section) {
            if (maxPoint <= point) {
                maxPoint = point + m;
                cntPoint++;
            }
        }
        return cntPoint++;
    }
}