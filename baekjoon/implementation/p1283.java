package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p1283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Character> shortcuts = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String rawOption = br.readLine();
            String[] options = rawOption.split(" ");
            boolean flag = false;
            for (String option : options) {
                char shortcut = option.charAt(0);
                if (hasShortcut(shortcuts, shortcut)) {
                    continue;
                }
                shortcuts.add(shortcut);
                String replaced = option.replaceFirst(String.valueOf(shortcut), String.format("[%c]", shortcut));
                sb.append(rawOption.replaceFirst(option, replaced)).append("\n");
                flag = true;
                break;
            }

            if (flag) {
                continue;
            }
            flag = false;
            for (String shortcut : rawOption.split("")) {
                if (shortcut.equals(" ")) {
                    continue;
                }
                if (hasShortcut(shortcuts, shortcut.charAt(0))) {
                    continue;
                }
                flag = true;
                shortcuts.add(shortcut.charAt(0));
                sb.append(rawOption.replaceFirst(shortcut, String.format("[%c]", shortcut.charAt(0)))).append("\n");
                break;
            }

            if (!flag) {
                sb.append(rawOption).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean hasShortcut(Set<Character> shortcuts, char shortcut) {
        return shortcuts.contains(Character.toLowerCase(shortcut)) || shortcuts.contains(Character.toUpperCase(shortcut));
    }
}
