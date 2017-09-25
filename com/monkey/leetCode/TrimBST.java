package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode<Integer> root, int L, int R) {
        TreeNode<Integer> node;
        if (root == null) {
            return null;
        }
        //找到根节点
        //如果上来就满足条件 记得break跳出循环
        while (root != null) {
            if (root.val < L) {
                root = root.right;
            } else if (root.val > R) {
                root = root.left;
            } else {
                break;
            }
        }
        node = root;
        //修剪左节点
        //因为root在LR之间,所以左节点只需要判断左区间
        //判断之后向下进行 注意退出条件
        while (node.left != null) {
            if (node.left.val < L) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        node = root;

        //修剪右节点

        while (node.right != null) {
            if (node.right.val > R) {
                node.right = node.right.left;
            } else {
                node = node.right;
            }
        }

        return root;
    }

}
