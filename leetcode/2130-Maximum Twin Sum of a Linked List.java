import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public int pairSum(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head.next != null) {
			list.add(head.val);
			head = head.next;
		}
		list.add(head.val);

		int max = 0;
		int len = list.size();
		int mid = len / 2;
		for (int i = 0; i < mid; i++) {
			max = Math.max(max, list.get(i) + list.get(len - 1 - i));
		}

		return max;
	}
}

// 0, n - 1 - i
//
