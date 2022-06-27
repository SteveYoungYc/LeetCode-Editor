package com.yc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                node = queue.poll();
                if (node != null) {
                    System.out.print(" " + node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    System.out.print(" n ");
                }
            }
            System.out.println();
        }
    }
}