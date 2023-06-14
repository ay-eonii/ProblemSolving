class Solution1 {
    public long solution(long n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
        return -1;
    }
}

class Solution2 {
    public long solution(long n) {
        double answer = Math.sqrt(n);
        if (answer > 0 && answer == (long) answer) {
            return (long) ((answer + 1) * (answer + 1));
        }
        return -1;
    }
}