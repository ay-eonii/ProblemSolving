class Solution {
    private static int[] answer;
    private static int[][] directionArr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[] solution(String[] park, String[] routes) {
        answer = new int[2];
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
            }
        }

        for (String route : routes) {
            String[] op = route.split(" ");
            String direction = op[0];
            int distance = Integer.parseInt(op[1]);

            int index = getDirectionIndex(direction);

            if (!isBlock(park, answer[0], answer[1], distance, directionArr[index])) {
                answer[0] += distance * directionArr[index][0];
                answer[1] += distance * directionArr[index][1];
            }
        }
        return answer;
    }
    private static boolean isBlock(String[] park, int row, int col, int distance, int[] directionArr) {
        for(int i = 1; i <= distance; i++){
            row += directionArr[0];
            col += directionArr[1];

            if (row < 0 || row > park.length - 1 || col < 0 || col > park[0].length() - 1 || park[row].charAt(col) == 'X') {
                return true;
            }
        }
        return false;
    }

    private static int getDirectionIndex(String direction) {
        int index = 0;
        switch (direction){
            case "N":
                break;
            case "S":
                index = 1;
                break;
            case "W":
                index = 2;
                break;
            case "E":
                index = 3;
                break;
        }
        return index;
    }
}


/*
1. 시작점 찾기
2. routes 순회
2-1. route[] = split(" ")
2-2. route[0] == E or W -> 해당 string에서 찾기
2-3. route[0] == N or S -> i 변화

*/