import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		int turnaround = 0;
		int len = jobs.length;

		Arrays.sort(jobs, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			for (int i = 0; i < 3; i++) {
				if (o1[i] != o2[i]) {
					return Integer.compare(o1[i], o2[i]);
				}
			}
			return 0;
		});

		int now = 0;
		int done = 0;
		int jobIdx = 0;
		while (done < len) {
			while (jobIdx < len && jobs[jobIdx][0] <= now) {
				pq.add(new int[] {jobs[jobIdx][1], jobs[jobIdx][0], jobIdx});
				jobIdx++;
			}

			if (pq.isEmpty()) {
				now++;
				continue;
			}

			int[] job = pq.poll();
			now += job[0];
			turnaround += now - job[1];
			done++;
		}

		return turnaround / jobs.length;
	}
}

// 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다. => int[][][]
// 우선순위 디스크 컨트롤러가 이 작업을 처리했을 때 모든 요청 작업의 반환 시간의 평균의 정수부분을 return
// 큐에 작업이 끝날때까지
// int 현재시간
// 0. if (큐.peek 요청시간 <= 현재시간)
// 1. 큐에서 작업 빼기
// 2. 현재시간 += 작업시간
// 3. 반환시간 = 현재시간 - 요청시간
// ... else 현재시간 = 큐.peek의 요청시간
