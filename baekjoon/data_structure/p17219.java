package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class p17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        Map<String, String> password = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] pw = br.readLine().split(" ");
            password.put(pw[0], pw[1]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            String pw = password.get(site);
            bw.write(pw + "\n");
        }

        bw.flush();
        bw.close();
    }
}
