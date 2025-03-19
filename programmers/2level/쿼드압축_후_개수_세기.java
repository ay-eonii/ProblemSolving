class 쿼드압축_후_개수_세기 {

    private static int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        temp(0, 0, arr.length, arr);

        return answer;
    }

    private void temp(int x, int y, int size, int[][] arr) {
        if (size == 1) {
            answer[arr[y][x]]++;
            return;
        }

        boolean isDifferent = false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != arr[y][x]) {
                    isDifferent = true;
                    break;
                }
            }
            if (isDifferent) {
                break;
            }
        }

        if (!isDifferent) {
            answer[arr[y][x]]++;
            return;
        }

        int newSize = size / 2;
        temp(x + newSize, y, newSize, arr); // 1사분면
        temp(x + newSize, y + newSize, newSize, arr); // 2사분면
        temp(x, y + newSize, newSize, arr); // 3사분면
        temp(x, y, newSize, arr); // 4사분면
    }
}

// 1 <= arr.length <= 1024
// 1,048,576 O(N^2)
//
