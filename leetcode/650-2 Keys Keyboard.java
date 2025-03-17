package leetcode;

class TwoKeysKeyboard {
    private int[] dp;

    public int minSteps(int n) {
        dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = find(i);
        }
        return dp[n];
    }

    private int find(int i) {
        for (int j = i - 1; j >= 1; j--) {
            // 이전 클립보드 사용
            if (i % j == 0) {
                // 제일 처음이 최적
                return dp[j] + (i / j);
            }
        }
        return i;
    }
}

// n개의 'A'를 만드는 최소 횟수 구하기
// 초기: 'A'
// 선택: C, V
// 상태: A 수
// dp[n]: n개 만들기 위한 최소 횟수

// 마지막은 붙여넣기
// 최악: 'A' 계속 붙여넣기
// dp[j] + 1 (기존 클립보드에서 붙여넣기). j:복사타이밍
