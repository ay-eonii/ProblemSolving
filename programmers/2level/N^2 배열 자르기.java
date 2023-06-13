/* problem
1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
2-1. 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
3. 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
*/

class Solution1 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            int max = Math.max((int) ((left + i) / n), (int) ((left + i) % n));
            answer[i] = max + 1;
        }

        return answer;
    }
}
/* strategy2
배열을 전부 만들면 시간초과 | 메모리 초과
1. 행과 열을 이용
2. 큰 쪽이 값
*/

class Solution2 {
    public static int[] solution(int n, long left, long right) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Math.max(i + 1, j + 1);
            }
        }

        int d = (int) (right - left) + 1;
        int[] answer = new int[d];
        for (int i = 0; i < d; i++) {
            int col = (int) (left % n);
            int row = (int) (left / n);
            left++;
            answer[i] = arr[row][col];

        }
        return answer;
    }
}

/* strategy2
1. new int[n*n]
2. 배열 채우기
1행은 1열까지만 1, 이후로 1 씩증가
2행은 2열까지만 2, 이후로 1씩 증가
3행은 3열까지만 3, 이후로 1씩 증가
4행은 4열까지만 4
=> i/n행은 i%n열까지만 i/n, 이후로 1씩 증가
3. for-i : from 0 to n*n-1
4. row = i / n, col = i % n;
5. arr[i] = col <= row ? row +1 : ++row
*/