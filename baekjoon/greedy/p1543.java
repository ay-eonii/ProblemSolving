package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String docs = br.readLine();
        String word = br.readLine();

        int answer = 0;
        for (int i = 0; i <= docs.length() - word.length(); i++) {
            String substring = docs.substring(i, i + word.length());
            if (word.equals(substring)) {
                i += word.length() - 1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}

// strategy
// 겹치지 않게 단어 찾기
// 그리디
//
