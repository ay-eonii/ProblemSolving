/* problem
주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다.
차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
*/

import java.util.*;

class Solution {
    private static final int LAST_OUT = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        Map<String, Float> parkingTimes = new HashMap<>();
        Map<String, Integer> exitTimes = new HashMap<>();

        for (int i = records.length - 1; i >= 0; i--) {
            String[] carInfo = records[i].split(" ");

            if (carInfo[2].equals("OUT")) {
                exitTimes.put(carInfo[1], timeToMinute(carInfo[0]));
                continue;
            }

            int in = timeToMinute(carInfo[0]);
            float time = exitTimes.getOrDefault(carInfo[1], LAST_OUT) - in;

            parkingTimes.merge(carInfo[1], time, Float::sum);
        }

        List<String> list = new ArrayList<>(parkingTimes.keySet());
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            float time = parkingTimes.get(list.get(i));
            int overFee = (int) Math.ceil((time - fees[0]) / fees[2]) * fees[3];

            answer[i] = (time > fees[0]) ? fees[1] + overFee : fees[1];
        }

        return answer;
    }

    private int timeToMinute(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}

/* strategy
return: 차량번호 오름차순으로 요금을 정수 배열에 담아서
fees: 기본시간 기본요금 단위시간 단위요금
records: 시각 차량번호 내역 -> split(" ")

1. 요금 구하기
1-1. 주차 시간 = 출차 시각 - 입차 시각 == (출차 시 * 60 + 출차 분) - (입차 시 * 60 + 입차 분)
1-2. 요금 = 주차 시간 > 기본시간 ? 기본요금 + Math.ceil((주차시간 - 기본시간) / 단위시간) * 단위 요금 : 기본요금

2. 차량번호로 정렬
2-1. Map<차량번호, 요금> 후 key 로 정렬

** 00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다. **
-> 두번 왔다가도 기본요금 두번이 아님..ㅜㅜ
*/