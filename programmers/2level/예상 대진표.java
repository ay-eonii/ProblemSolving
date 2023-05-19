class Solution1 {
    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }
        return round;
    }
}

class Solution2 {
    public int solution(int n, int a, int b) {
        return Integer.toBinaryString((a - 1) ^ (b - 1)).length();
    }
}