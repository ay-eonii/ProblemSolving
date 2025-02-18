package leetcode;

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int text1Len = text1.length();
        int text2Len = text2.length();
        int[][] dp = new int[text1Len + 1][text2Len + 1];
        for (int i = 1; i <= text1Len; i++) {
            for (int j = 1; j <= text2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1Len][text2Len];
    }
}

// 공통 부분 순열
// base case: 공통 부분 순열이 없음 -> 0
// 선택: 특정 위치의 텍스트가 공통 vs 공통아님
