import java.util.ArrayList;
import java.util.List;

public class 카카오_인턴_수식_최대화 {

    private static final String[] ops = new String[]{
            "+-*",
            "+*-",
            "-+*",
            "-*+",
            "*+-",
            "*-+"
    };

    public long solution(String expression) {
        List<Long> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operands.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operators.add(c);
            } else {
                sb.append(c);
            }
        }
        operands.add(Long.parseLong(sb.toString()));

        long max = 0;
        for (String op : ops) { // 3!
            List<Long> operandsCopy = new ArrayList<>(operands);
            List<Character> operatorsCopy = new ArrayList<>(operators);
            for (char o : op.toCharArray()) { //"*+-"..
                int index = 0;
                while (index < operatorsCopy.size()) {
                    if (operatorsCopy.get(index) != o) {
                        index++;
                        continue;
                    }
                    operatorsCopy.remove(index);
                    long o1 = operandsCopy.get(index);
                    operandsCopy.remove(index);
                    long o2 = operandsCopy.get(index);
                    operandsCopy.remove(index);
                    if (o == '+') {
                        operandsCopy.add(index, o1 + o2);
                    } else if (o == '-') {
                        operandsCopy.add(index, o1 - o2);
                    } else {
                        operandsCopy.add(index, o1 * o2);
                    }
                }
            }
            max = Math.max(Math.abs(operandsCopy.get(0)), max);
        }

        return max;
    }
}
