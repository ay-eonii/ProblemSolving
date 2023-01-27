/* problem
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 */
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] { -1 };
        }

        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = min > i ? i : min;
        }

        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int i : arr) {
            if (i != min) {
                answer[index++] = i;
            }
        }
        return answer;
    }
}

/*
 * strategy
 * 1. 최소값
 * 2. arr-1 길이 배열에 저장
 * 3. arr==1인 경우 return [-1];
 */