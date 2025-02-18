package leetcode;

class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + 1, // 변경
                            Math.min(
                                    dp[i][j - 1] + 1, // 삽입
                                    dp[i - 1][j] + 1 // 삭제
                            )
                    );
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

// word1 to word2
// 삽입, 삭제, 변경
// 상태: word1 편집 위치, word2 대상 위치
// 선택: 건너뛰기, 삽입, 삭제, 변경
