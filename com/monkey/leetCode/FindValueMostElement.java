package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindValueMostElement {
    //二叉树中每层最大的数值
    //计划层次遍历 然后找出最大值
    public List calculate(TreeNode<Integer> root) {
        if(root==null) return new ArrayList();
        //存放结果
        List result = new ArrayList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int value = Integer.MIN_VALUE;
            int size = queue.size();
            //这层循环保证每层取出一个最大值
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                value = Math.max(node.val,value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(value);
        }
        return result;
    }
}
