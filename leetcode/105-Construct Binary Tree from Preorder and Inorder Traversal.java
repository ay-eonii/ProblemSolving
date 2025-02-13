package leetcode;

class Solution {
    private int i = 0; // inorder 배열의 현재 탐색 위치
    private int p = 0; // preorder 배열의 현재 탐색 위치

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            // preorder를 다 사용했으면 종료
            return null;
        }
        if (inorder[i] == stop) {
            // 오른쪽으로 넘어가는 시점
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public class TreeNode {
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

// preoder traversal: 전위순회
// inorder traversal: 중위순회

// preorder[0] : root
// preorder[1] : left
// preorder[2 ~] : right

// inorder[?] == preorder[0] : root
// inorder[~?] : left
// inorder[?~] : right
