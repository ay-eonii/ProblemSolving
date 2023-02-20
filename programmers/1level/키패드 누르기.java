/* problem
이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 
각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    StringBuilder sb = new StringBuilder();
    int[] left = new int[] { 3, 0 };
    int[] right = new int[] { 3, 2 };

    public String solution(int[] numbers, String hand) {
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                press("L", number, 0);
            } else if (number == 3 || number == 6 || number == 9) {
                press("R", number - 1, 2);
            } else {
                if (number == 0) {
                    number = 11;
                }
                int leftDistance = Math.abs(number / 3 - left[0]) + Math.abs(1 - left[1]);
                int rightDistance = Math.abs(number / 3 - right[0]) + Math.abs(1 - right[1]);
                if (leftDistance < rightDistance) {
                    press("L", number, 1);
                } else if (leftDistance > rightDistance) {
                    press("R", number, 1);
                } else {
                    if (hand.equals("left")) {
                        press("L", number, 1);
                    } else {
                        press("R", number, 1);
                    }
                }
            }
        }

        return sb.toString();
    }

    public void press(String s, int number, int column) {
        sb.append(s);
        if (s.equals("L")) {
            left[0] = number / 3;
            left[1] = column;
        } else {
            right[0] = number / 3;
            right[1] = column;
        }

    }
}

/*
 * strategy
 * - 147 : L
 * - 369 : R
 * - 2580 : 거리순 -> hand
 * 1. numbers순회
 * 2. 147/369이면 L/R, 2580이면 손 위치 확인
 * 2-1. 누른 후 손 위치 저장 : left/right
 * 2-2. left위치| 행: number / 3 열:0
 * 2-3. right위치| 행: number / 3 - 1 열: 2
 * 2-3. 처음 위치 : left = 10(*), right = 12(#)
 * 3. return String append하기위해 StringBuilder
 */