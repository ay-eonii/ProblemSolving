/*
가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다.
직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
 */

class Solution {
    private final int divisor = 1000000007;

    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % divisor;
        }
        return dp[n];
    }
}

// n = 1 -> 1
// n = 2 -> 2
// n = 3 -> 3
// n = 4 -> 5
// n = 5 -> 8
// 피보나치 수열
