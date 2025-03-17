package leetcode;

class RegularExpressionMatching {

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()][p.length()];

        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int n = s.length();
        int m = p.length();

        if (j == m) {
            return i == n;
        }

        if (i == n) {
            if ((m - j) % 2 == 1) {
                return false;
            }

            for (; j + 1 < m; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 동일함
            if (j < m - 1 && p.charAt(j + 1) == '*') {
                // 0번이상일치
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // 1번일치
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 동일하지 않음
            if (j < m - 1 && p.charAt(j + 1) == '*') {
                // 0번일치
                res = dp(s, i, p, j + 2);
            }
        }

        return memo[i][j] = res;
    }
}

// 상태: i, j (포인터 위치)
// 선택: p[j]에 일치하는 문자가 몇 개인지
// j+2 => '*'때문에 일치하는 것인지, 그 다음 문자에 일치하는 것인지 확인
// i+1 => '*'때문에 일치
