/* problem
한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다. 
이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다. 
예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때, 
첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다. 
또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 
따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.

한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 
학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
 */

class Solution1 {
    public int solution(int[] number) {
        int answer = 0;
        int lastNum;
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                lastNum = (number[i] + number[j]) * -1;
                for (int k = j + 1; k < number.length; k++) {
                    if (number[k] == lastNum) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

/*
 * strategy (solution1)
 * 1. 두 번호의 합
 * 2. 나머지 한 번호 == 두 번호의 합 * -1 -> 삼총사
 * 3. number에 "두 번호의 합 * -1"이 있다면 answer++
 * ! 두 번호 중 한 번호와 "두 번호의 합 * -1"이 같은경우 인덱스는 달라야 함
 * 즉, number에는 그 번호가 2개 이상이어야 함
 * 4. 순방향 조합 -> 중복 X
 */

class Solution2 {
    static int count;
    static boolean[] visited;

    public int solution(int[] number) {
        int answer = 0;
        visited = new boolean[number.length];

        dfs(number, number.length, 0, 3);
        answer = count;
        return answer;
    }

    public void dfs(int[] numbers, int length, int start, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                if (visited[i]) {
                    sum += numbers[i];
                }
            }
            if (sum == 0) {
                count++;
            }
            return;
        }

        for (int i = start; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, length, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}

/*
 * strategy(solution2)
 * 1. 3명의 학생 조합(nC3)
 * 재귀함수
 */