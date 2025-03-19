class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] += 10;
            int hour = (schedules[i] / 100) * 100;
            if ((schedules[i] - hour) >= 60) {
                schedules[i] = hour + 100 + (schedules[i] / 10 % 10 - 6) + (schedules[i] % 10);
            }
        }

        boolean[] isLate = new boolean[schedules.length];
        for (int i = 0; i < 7; i++) {
            int weekday = (i + startday) % 7;
            if (weekday == 6 || weekday == 0) {
                continue;
            }

            for (int j = 0; j < schedules.length; j++) {
                if (schedules[j] < timelogs[j][i]) {
                    isLate[j] = true;
                }
            }
        }

        int answer = 0;
        for (boolean late : isLate) {
            if (!late) {
                answer++;
            }
        }

        return answer;
    }
}

// 설정한 출근 희망 시각 + 10분 
// 토일 X
// 시 * 100 + 분
// 일주일동안 지각안한 직원들 상품
// 상품을 받을 직원이 몇명일까?

// schedules
// 855 -> 905까지 인정
// 분이 50이상이라면 시간으로 넘어감
// 855 -> 865 -> 865/100 + 100 + 865/10 % 10 - 6 + 865%10
