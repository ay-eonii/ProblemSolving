public class 조이스틱 {

    private static final char DEFAULT_ALPHABET = 'A';
    private static final int BACK = ('Z' - 'A');

    public int solution(String name) {
        int n = name.length();

        int answer = changeAlphabet(name);
        int move = n;
        for (int i = 0; i < n; i++) {
            move = Math.min(greedy(i, name), move);
        }
        return answer + move;
    }

    private int changeAlphabet(String name) {
        int sum = 0;
        for (char n : name.toCharArray()) {
            int diff = n - DEFAULT_ALPHABET;
            sum += Math.min(diff, BACK - diff + 1);
        }
        return sum;
    }

    private int greedy(int start, String name) {
        int index = start + 1;
        int len = name.length();
        while (index < len && name.charAt(index) == 'A') {
            index++;
        }

        return Math.min(start * 2 + len - index, (len - index) * 2 + start);
    }
}

// 커서이동은 큐 형태
// 최소 이동 방법 (어차피 알파벳 변경은 불가피, 이동에서 최적화)
// 다음 || 이전이 최선
// 정방향이냐 역방향이냐
// name.charAt(?) - 'A'

