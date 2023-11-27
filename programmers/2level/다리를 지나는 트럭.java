/* problem
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight,
 * 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        List<Truck> trucks = new ArrayList<>();
        for (int truck_weight : truck_weights) {
            trucks.add(new Truck(truck_weight));
        }

        Queue<Truck> bridge = new LinkedList<>();
        int sum = 0;
        int index = 0;
        int answer = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(new Truck(0));
        }

        while (index < trucks.size()) {
            sum -= bridge.poll().getWeight();
            answer++;

            Truck truck = trucks.get(index);
            if (sum + truck.getWeight() <= weight) {
                bridge.add(truck);
                sum += truck.getWeight();
                index++;
            } else {
                bridge.add(new Truck(0));
            }
        }

        return answer + bridge_length;
    }
}

class Truck {
    private final int weight;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}

// 순서는 정해짐
// |--|--|
// queue. size == bridge_length
// queue의 모든 합 <= weight
// 1. truck_weights[i] <= weight ? queue.add(truck_weights[i])
// 2. while (bridge_length < size)
// 2-1. if (queue.sum + truck_weights[i+1] <= weigth) ? queue.add(truck_weights[i+1])
// 2-2. if (queue.sum + truck_weights[i+1] > weigth) ? queue.add(any)