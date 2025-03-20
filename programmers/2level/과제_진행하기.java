import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class 과제_진행하기 {
    public String[] solution(String[][] plans) {
        List<Plan> p = new ArrayList<>();
        for (String[] plan : plans) {
            p.add(new Plan(plan));
        }

        Collections.sort(p);

        Stack<Plan> keeps = new Stack<>();
        List<String> done = new ArrayList<>();
        for (int i = 1; i < plans.length; i++) {
            Plan next = p.get(i);
            Plan current = p.get(i - 1);
            int playTime = next.startToInt() - current.startToInt();

            if (playTime < current.playTime) { // 다 못끝내면
                current.reducePlayTime(playTime);
                keeps.push(current);
            } else if (playTime == current.playTime) { // 딱맞춰끝내면
                done.add(current.name);
            } else { // 시간 남으면
                done.add(current.name);
                playTime -= current.playTime;
                while (playTime > 0 && !keeps.isEmpty()) {
                    Plan keep = keeps.pop();
                    if (playTime < keep.playTime) {
                        keep.reducePlayTime(playTime);
                        keeps.push(keep);
                        playTime = 0;
                    } else {
                        done.add(keep.name);
                        playTime -= keep.playTime;
                    }
                }
            }

            if (i == plans.length - 1) {
                done.add(next.name);
            }
        }

        // 남은 거 마저하기
        while (!keeps.isEmpty()) {
            done.add(keeps.pop().name);
        }

        return done.toArray(new String[plans.length]);
    }
}

class Plan implements Comparable<Plan> {
    String name;
    String start;
    int playTime;

    public Plan(String[] plan) {
        this.name = plan[0];
        this.start = plan[1];
        this.playTime = Integer.parseInt(plan[2]);
    }

    public int startToInt() {
        return timeToInt(start);
    }

    public int reducePlayTime(int playTime) {
        return this.playTime -= playTime;
    }

    private int timeToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    @Override
    public int compareTo(Plan p) {
        return this.start.compareTo(p.start);
    }
}
