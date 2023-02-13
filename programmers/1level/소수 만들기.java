/* problem
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

class Solution1 {
    static int cnt = 0;
    static boolean[] visited;
    static boolean[] cheArray;

    public int solution(int[] nums) {

        cheArray = new boolean[3000];
        for (int i = 2; i * i <= cheArray.length; i++) {
            for (int j = i * i; j < cheArray.length; j += i) {
                cheArray[j] = true;
            }
        }

        visited = new boolean[nums.length];
        dfs(nums, nums.length, 0, 3);
        return cnt;
    }

    public void dfs(int[] nums, int length, int start, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                if (visited[i]) {
                    sum += nums[i];
                }
            }
            if (!cheArray[sum]) {
                cnt++;
            }
        }
        for (int i = start; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(nums, length, i + 1, r - 1);
            visited[i] = false;
        }
    }
}

/*
 * strategy1
 * 1. 조합 nC3
 * 2. 소수 판별: 에라토스테네스의 체
 * 2-1. 길이 n 배열 초기화
 * 2-2. index 2부터 시작 -> 0이면 cnt++
 * 2-3. 해당 인덱스의 배수 1로 바꾸기 (검사 제외)
 */

class Solution2 {
    public int solution(int[] nums) {

        boolean[] cheArray = new boolean[3000];
        for (int i = 2; i * i <= cheArray.length; i++) {
            for (int j = i * i; j < cheArray.length; j += i) {
                cheArray[j] = true;
            }
        }

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (!cheArray[sum]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
