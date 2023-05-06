class Solution {
    private int dp[];

    public int DynamicProgramming(int n) {
        dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }
        return dp[n] % 1234567;
    }
}

class Solution {
    private int dp[];

    public void Fibonacci(int n) {
        dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fib(n));

    }

    private int fib(int n) {
        if (n == 1) {
            return dp[1];
        }
        if (n == 0) {
            return dp[0];
        }
        return fib(n - 1) + fib(n - 2);
    }
}

