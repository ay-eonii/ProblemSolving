/* problem
점 네 개의 좌표를 담은 이차원 배열 dots가 다음과 같이 매개변수로 주어집니다.
    [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {
    public int solution(int[][] dots) {
        float[] distances = new float[2];
        float[] temp = new float[2];
        for (int i = 1; i <= 3; i++) {
            int cnt = 0;
            for (int j = 1; j < dots.length; j++) {
                if (i == j) {
                    distances[0] = (float) (dots[0][0] - dots[j][0]) / (dots[0][1] - dots[j][1]);
                } else {
                    if (cnt == 0) {
                        temp[0] = dots[j][0];
                        temp[1] = dots[j][1];
                        cnt++;
                        continue;
                    }
                    distances[1] = (float) (temp[0] - dots[j][0]) / (temp[1] - dots[j][1]);
                }
            }
            if (distances[0] == distances[1]) {
                return 1;
            }
        }
        return 0;
    }
}

/*
 * 0. dots 순회하면서 판단
 * 1. 평행 조건: 두 선분의 기울기 같아야 함 -> x의 차, y의 차 같아야 함 && 부호도 같아야함
 * 2. 두 선분 만드는 경우의 수: [0]&[1]~[2]&[3] || [0]&[2]~[1]&[3] || [0]&[3]~[1]&[2]
 * 
 * for 문으로 dots순회하는데, i번째인 경우에만 0이랑 연결 & i번째 아닌 경우끼리 연결
 * 
 */