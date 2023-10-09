/* problem
입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
 */

import java.util.*;

class Solution {

    private static char[][] newBoard;

    public int solution(int m, int n, String[] board) {
        newBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i].charAt(j);
            }
        }

        List<String> del;
        while ((del = find(m, n)).size() > 0) {
            remove(del);
            fill(m, n);
        }

        int answer = 0;
        for (char[] arr : newBoard) {
            for (char c : arr) {
                if (c == ' ') {
                    answer++;
                }
            }
        }

        return answer;
    }

    private List<String> find(int m, int n) {
        List<String> del = new ArrayList<>();
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (newBoard[i][j] == ' ') {
                    continue;
                }
                if (isRemovable(i, j)) {
                    del.add(i + " " + j);
                }
            }
        }
        return del;
    }

    private boolean isRemovable(int i, int j) {
        char temp = newBoard[i][j];
        return newBoard[i][j - 1] == temp && newBoard[i - 1][j] == temp && newBoard[i - 1][j - 1] == temp;
    }

    private void remove(List<String> del) {
        for (String d : del) {
            String[] split = d.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            newBoard[x - 1][y - 1] = ' ';
            newBoard[x - 1][y] = ' ';
            newBoard[x][y - 1] = ' ';
            newBoard[x][y] = ' ';
        }
    }

    private void fill(int m, int n) {
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                if (newBoard[row - 1][col] != ' ' && newBoard[row][col] == ' ') {
                    for (int temp = row; temp > 0; temp--) {
                        newBoard[temp][col] = newBoard[temp - 1][col];
                    }
                    newBoard[0][col] = ' ';
                }
            }
        }
    }
}

// strategy
// 1. 2x2 찾기
// 오른쪽 밑에서 왼쪽위, 위, 왼쪽 확인
// 1,1 ~ 끝가지
// 2x2 -> 오른족 밑 인덱스 저장
// 2. 제거하기
// 저장한 인덱스 다시 돌면서 왼쪽위, 위, 왼쪽 공백으로 변경
// 3. 빈공간 채우기
// row + 1가 공백이 아니거나 끝일때까지 내리기