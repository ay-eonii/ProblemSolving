package leetcode;

class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int answer = maxPathSumNoSplit(root);

        return Math.max(answer, max);
    }

    public int maxPathSumNoSplit(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumNoSplit(current.left));
        int right = Math.max(0, maxPathSumNoSplit(current.right));
        max = Math.max(max, left + right + current.val);

        return Math.max(left, right) + current.val;
    }

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
}

// 좌/우 재귀 -> 자녀의 각각 최대합
// => 후위순회
// 1. 상위와 연결X. 현재 노드에서 자녀 연결 => left + right+ current
// 2. 상위와 연결O. current + max(left, right)
