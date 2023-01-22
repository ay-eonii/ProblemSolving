import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(String s) {
        String num = "0123456789";
        String[] numEng = new String[] { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine" };
        List<String> numEngList = Arrays.asList(numEng);
        for (String str : numEng) {
            int index = numEngList.indexOf(str);
            if (index != -1) {
                s = s.replace(str, String.valueOf(num.charAt(index)));
            }
        }
        return Integer.valueOf(s);
    }
}