class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
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
1. 최소값
2. arr-1 길이 배열에 저장
3. arr==1인 경우 return [-1];
*/