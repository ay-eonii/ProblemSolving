class Solution {
    public int[] solution(String[] wallpaper) {
        int left = 50, right = 0, top = 50, bottom = 0;
        for (int row = 0; row < wallpaper.length; row++) {
            String[] rowString = wallpaper[row].split("");
            for (int i = 0; i < rowString.length; i++) {
                if (rowString[i].equals("#")) {
                    left = Math.min(left, i);
                    right = Math.max(right, i);
                    top = Math.min(top, row);
                    bottom = Math.max(bottom, row);
                }
            }
        }

        return new int[]{top, left, bottom + 1, right + 1};
    }
}

/*
! wallpaper[i][j]는 바탕화면에서 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.

1. 최소한 이동거리 드래그 -> 제일 왼쪽(l), 제일 오른쪽(r), 제일 위(h), 제일 아래(u) 고려
2. 1행 -> h | 마지막 행 -> u | 1열 -> l | 마지막 열 -> r
3.
*/