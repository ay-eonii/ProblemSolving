package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Map<String, Integer> words = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            words.computeIfPresent(word, (k, v) -> v + 1);
            words.putIfAbsent(word, 1);
        }

        List<Word> list = new ArrayList<>();
        for (String key : words.keySet()) {
            list.add(new Word(key, words.get(key)));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.word).append("\n");
        }
        System.out.print(sb);
    }

    static class Word implements Comparable<Word> {
        String word;
        int frequency;

        public Word(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Word o) {
            if (frequency == o.frequency) {
                if (word.length() == o.word.length()) {
                    return word.compareTo(o.word);
                }
                return o.word.length() - word.length();
            }
            return o.frequency - frequency;
        }
    }
}

// strategy
// 1. 자주 나오는 단어일수록 앞에 배치한다.
// 2. 해당 단어의 길이가 길수록 앞에 배치한다.
// 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
// 길이가 M 이상인 것만
// 정렬

