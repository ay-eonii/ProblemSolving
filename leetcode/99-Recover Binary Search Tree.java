package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RecoverBinarySearchTree {

    private final List<Integer> values = new ArrayList<>();
    private int index = 0;

    public void recoverTree(TreeNode root) {
        inorderTranversal(root);
        Collections.sort(values);

        setValue(root);
    }

    private void inorderTranversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTranversal(node.left);
        values.add(node.val);
        inorderTranversal(node.right);
    }

    private void setValue(TreeNode node) {
        if (node == null) {
            return;
        }

        setValue(node.left);
        node.val = values.get(index++);
        setValue(node.right);
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

// 중위순회
// 값 오름차순 정렬
// 트리에 저장
