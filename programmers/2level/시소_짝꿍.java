import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 시소_짝꿍 {
    public long solution(int[] weights) {
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();
        long answer = 0L;
        for (int weight : weights) {
            double a = weight * 1.0;
            double b = (weight * 2) / 3.0;
            double c = (weight * 2) / 4.0;
            double d = (weight * 3) / 4.0;

            if (map.containsKey(a)) {
                answer += map.get(a);
            }
            if (map.containsKey(b)) {
                answer += map.get(b);
            }
            if (map.containsKey(c)) {
                answer += map.get(c);
            }
            if (map.containsKey(d)) {
                answer += map.get(d);
            }

            map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
        }

        return answer;
    }
}

// 시소짝꿍 = (탑승한 사람의 무게 * 시소 축과 좌석 간의 거리)가 동일한 사람
// 시간복잡도 => N^2 초과
