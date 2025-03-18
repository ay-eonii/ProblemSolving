package leetcode;

class SuperEggDrop {
    private int[][] dp;

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        return find(k, n);
    }

    public int find(int k, int n) {
        if (k == 1) {
            return n;
        }

        if (n == 0) {
            return 0;
        }

        if (dp[k][n] != 0) {
            return dp[k][n];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(
                    res,
                    Math.max(
                            find(k, n - i), // 안깨지는 경우
                            find(k - 1, i - 1) // 깨지는 경우
                    ) + 1 // 현재 이동
            );
        }
        return res;
    }
}

// 이진탐색 -> 불가: 계란 개수가 정해져있음
// 상태: 계란 수, 확인할 층 수
// 선택: 계란을 던질 층
