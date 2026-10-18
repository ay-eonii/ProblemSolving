import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();

		q.add(root);
		int max = Integer.MIN_VALUE;
		int level = 1;
		int answer = level;

		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;

			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				sum += cur.val;

				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}

			if (max < sum) {
				answer = level;
				max = sum;
			}

			level++;
		}

		return answer;
	}
}

// 0 => 0 ~ 2^L
// 1   2 => 2^L ~ 2^L-1
// 3 4 5 6 => 2^L ~ 2^L-1
