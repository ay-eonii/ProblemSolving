package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1362 {
    public static final String HAPPY = " :-)";
    public static final String SAD = " :-(";
    public static final String DIE = " RIP";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] weights = br.readLine().split(" ");
        int o = Integer.parseInt(weights[0]);
        int w = Integer.parseInt(weights[1]);

        int senario = 1;

        while (true) {
            double minHappyRange = o / 2.0;
            int maxHappyRange = o * 2;

            w = getW(br, w);

            if (w > minHappyRange && w < maxHappyRange) {
                System.out.println(senario + HAPPY);
            } else if (w <= 0) {
                System.out.println(senario + DIE);
            } else {
                System.out.println(senario + SAD);
            }
            senario++;

            String againOrStop = br.readLine();
            if (againOrStop.startsWith("0")) {
                break;
            }
            weights = againOrStop.split(" ");
            o = Integer.parseInt(weights[0]);
            w = Integer.parseInt(weights[1]);
        }
    }

    private static int getW(BufferedReader br, int w) throws IOException {
        while (true) { // 시나리오
            String active = br.readLine();
            if (active.startsWith("#")) break;

            if (w <= 0) {
                continue;
            }

            String[] inputs = active.split(" ");
            String activity = inputs[0];
            int minutes = Integer.parseInt(inputs[1]);

            if (activity.equals("F")) {
                w += minutes;
            }
            if (activity.equals("E")) {
                w -= minutes;
            }
        }
        return w;
    }
}

