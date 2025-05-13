public class 문자열_압축 {

    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            String pattern = s.substring(0, i);
            int count = 1;
            int len = 0;
            for (int j = i; j + i <= s.length(); j += i) {
                if (pattern.equals(s.substring(j, j + i))) {
                    count++;
                } else {
                    len += countLen(count) + i;
                    count = 1;
                    pattern = s.substring(j, j + i);
                }
            }

            len += countLen(count) + i;
            int div = s.length() % i;
            answer = Math.min(answer, len + div);

        }

        return answer;
    }

    private int countLen(int count) {
        if (count == 1) {
            return 0;
        }
        if (count < 10) {
            return 1;
        }
        if (count < 99) {
            return 2;
        }
        if (count < 999) {
            return 3;
        }
        return 4;
    }
}
