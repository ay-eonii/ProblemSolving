class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int answer[] = new int[targets.length];
        int i = 0;
        for (String target : targets) {
            for (String t : target.split("")) {
                int index = 100;
                for (String key : keymap) {
                    if (key.indexOf(t) != -1) {
                        index = Math.min(index, key.indexOf(t) + 1);
                    }
                }
                if (index == 100) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += index;
            }
            i++;
        }
        return answer;
    }
}

/*
1. targets 순회 하면서 answer 배열에 저장
2. targets 원소 for (target.split(""))으로 하나하나 확인
3. keymap에 indexOf(t)
4. Math.min(keymap[j],keymap[k])
4-1. keymap.indexOf(c) == 1 -> break;
4-2. cnt += keymap.indexOf(c)
*/