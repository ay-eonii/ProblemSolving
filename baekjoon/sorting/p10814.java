package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Member> members = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // age, name
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name, i));
        }

        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                if (m1.age == m2.age) {
                    return m1.sequence - m2.sequence;
                }
                return m1.age - m2.age;
            }
        });
        for (Member member : members) {
            sb.append(member.age + " ");
            sb.append(member.name);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
class Member {
    int age;
    String name;
    int sequence;

    public Member(int age, String name, int sequence) {
        this.age = age;
        this.name = name;
        this.sequence = sequence;
    }
}

