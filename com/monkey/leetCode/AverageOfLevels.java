package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {
    //二叉树每层的平均值
    public static List solution(TreeNode<Integer> root) {
        if (root == null) return null;
        //层次遍历使用队列
        LinkedList<TreeNode> list = new LinkedList<>();
        List result = new ArrayList();
        TreeNode<Integer> node;
        list.add(root);
        while (!list.isEmpty()) {
            double sum = 0.0;
            int n = list.size();
            for (int i = 0; i < n; i++) {
                node = list.poll();
                sum = sum + node.val;
                if (node.left.val != null) list.add(node.left);
                if (node.right.val != null) list.add(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        TreeNode bTree = new TreeNode(3);
        //也可以使用insertLeft方法等新建结点,按照方法插入
        bTree.left = new TreeNode(9);
        bTree.right = new TreeNode(20);
        bTree.right.left = new TreeNode(15);
        bTree.right.right = new TreeNode(7);
        System.out.println(solution(bTree));
    }

}
