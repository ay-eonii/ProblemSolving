/* problem
유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
 */


class Solution {
    private static boolean[] visited;
    private static int answer = 0;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        recur(k, dungeons);

        return answer;
    }

    private void recur(int k, int[][] dungeons) {
        int sum = 0;
        for (boolean v : visited) {
            if (v) sum++;
        }

        answer = Math.max(sum, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                recur(k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}

// strategy
// 던전 개수는 8개 이하 순열: 8! -> 완전탐색 가능

// 유망조건 ? 최소 필요 피로도 < 현재 피로도
// 던전 탐험 후 피로도 소모한 게 0 이하면 안됨