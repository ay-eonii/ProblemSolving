/* problem
파일명 정렬 프로그램을 구현하라.
 */


import java.util.Arrays;
import java.util.Comparator;

class File {
    private final String head;
    private final String number;
    private final String fullName;

    public File(String head, String number, String fullName) {
        this.head = head;
        this.number = number;
        this.fullName = fullName;
    }

    public String getHead() {
        return this.head.toLowerCase();
    }

    public int getNumber() {
        return Integer.parseInt(this.number);
    }

    public String getFullName() {
        return this.fullName;
    }
}

class Solution {

    public String[] solution(String[] files) {
        File[] array = new File[files.length];

        String head, number, tail;
        for (int i = 0; i < files.length; i++) {
            int end = 0;
            while (!Character.isDigit(files[i].charAt(end))) {
                end++;
            }
            head = files[i].substring(0, end);

            int start = end;
            while (end != files[i].length() && Character.isDigit(files[i].charAt(end))) {
                end++;
            }
            number = files[i].substring(start, end);

            array[i] = new File(head, number, files[i]);
        }

        Arrays.sort(array, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                String f1Head = f1.getHead();
                String f2Head = f2.getHead();

                if (f1Head.equals(f2Head)) {
                    return f1.getNumber() - f2.getNumber();
                }
                return f1Head.compareTo(f2Head);
            }
        });

        String[] answers = new String[files.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = array[i].getFullName();
        }
        return answers;
    }
}

// strategy
// 객체의 정렬 -> Comparator

// 분리
// 숫자 처음 나오기 전까지가 HEAD
// 문자 나오기 전까지 NUMBER
// 나머지 TAIL

// 정렬
// HEAD: 대소문자 구분x , 들어온 순서대로
// NUMBER: 앞에 0 신경x, 들어온 순서대로
// TAIL:
