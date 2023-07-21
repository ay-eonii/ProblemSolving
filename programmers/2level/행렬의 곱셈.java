/* problem
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
*/

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] matrix = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < arr2.length; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                matrix[i][j] = temp;
            }
        }

        return matrix;
    }
}

/* strategy
1. (i, j) => arr1[i][] * arr2[][j]
*/