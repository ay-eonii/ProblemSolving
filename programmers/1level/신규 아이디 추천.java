/* problem
신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

    [Rules]
    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/

//solution1
class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String symbol = "~!@#$%^&*()=+[{]}:?,<>/";
        String[] idArr = new_id.split("");

        Boolean dot = false;
        for (String id : idArr) {
            id = id.toLowerCase();
            if (symbol.contains(id)) {
                continue;
            }
            if (id.equals(".") && dot) {
                continue;
            }
            dot = id.equals(".") ? true : false;
            sb.append(id);
        }

        deleteDot(sb, 0);
        deleteDot(sb, sb.length() - 1);

        if (sb.length() == 0) {
            sb.append("a");
        }

        if (sb.length() >= 16) {
            sb = new StringBuilder(sb.substring(0, 15));
            deleteDot(sb, sb.length() - 1);
        }

        if (sb.length() <= 2) {
            char end = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) {
                sb.append(end);
            }
        }

        return sb.toString();
    }

    private static void deleteDot(StringBuilder sb, int index) {
        if (sb.length() > 0 && sb.charAt(index) == '.') {
            sb.deleteCharAt(index);
        }
    }
}

//solution2
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]", "");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}", ".");
        temp = temp.replaceAll("^[.]|[.]$", "");
        System.out.println(temp.length());
        if (temp.equals(""))
            temp += "a";
        if (temp.length() >= 16) {
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("^[.]|[.]$", "");
        }
        if (temp.length() <= 2)
            while (temp.length() < 3)
                temp += temp.charAt(temp.length() - 1);

        answer = temp;
        return answer;
    }
}
