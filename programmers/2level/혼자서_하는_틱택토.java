public class 혼자서_하는_틱택토 {

    public int solution(String[] board) {

        int oCount = 0;
        int xCount = 0;
        boolean[] winner = new boolean[2];
        for (int i = 0; i < 3; i++) {
            if ("OOO".equals(board[i])) { // 가로
                winner[0] = true;
            }

            if ("XXX".equals(board[i])) {
                winner[1] = true;
            }

            if ((board[0].charAt(i) != '.') && (board[0].charAt(i) == board[1].charAt(i)) && ((board[1].charAt(i) == board[2].charAt(i)))) { // 세로
                if (board[0].charAt(i) == 'O') {
                    winner[0] = true;
                } else {
                    winner[1] = true;
                }
            }

            if ((board[1].charAt(1) != '.') && (board[0].charAt(0) == board[1].charAt(1)) && (board[1].charAt(1) == board[2].charAt(2))) {
                if (board[1].charAt(1) == 'O') {
                    winner[0] = true;
                } else {
                    winner[1] = true;
                }
            }

            if ((board[1].charAt(1) != '.') && (board[0].charAt(2) == board[1].charAt(1)) && (board[1].charAt(1) == board[2].charAt(0))) {
                if (board[1].charAt(1) == 'O') {
                    winner[0] = true;
                } else {
                    winner[1] = true;
                }
            }

            for (char b : board[i].toCharArray()) {
                if (b == 'O') {
                    oCount++;
                } else if (b == 'X') {
                    xCount++;
                }
            }
        }

        if ((winner[0] && winner[1]) || (winner[1] && xCount < oCount) || (winner[0] && xCount >= oCount)) {
            return 0;
        }

        if (xCount > oCount || oCount - xCount >= 2) {
            return 0;
        }

        return 1;
    }
}
