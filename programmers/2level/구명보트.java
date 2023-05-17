import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int min = 0;

        for (int max = people.length - 1; max >= min; max--) {
            if (people[max] + people[min] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }
}