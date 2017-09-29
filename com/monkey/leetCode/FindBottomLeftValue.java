package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    //找到最下层最左侧的数值
    public static int solution(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            //因为左子树 使用队列 所以先放右侧
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode<Integer> cache = new TreeNode<Integer>(2);
        cache.left = new TreeNode<Integer>(1);
        cache.right= new TreeNode<Integer>(3);
        System.out.println(solution(cache));
    }
}
