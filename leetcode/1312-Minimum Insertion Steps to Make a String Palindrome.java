package leetcode;

class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }
}

// s[i] == s[j] -> dp[i][j] = dp[i+1][j-1]
// else -> dp[i][j] = min(dp[i+1][j], dp[i][j-1]) + 1
// [i+1][j-1], [i+1][j], [i][j-1] 있어야함 -> 역방향
