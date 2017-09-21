package com.monkey.leetCode;

import com.monkey.dataStructure.BinaryTreeNode;

public class TrimBST {
    public BinaryTreeNode trimBST(BinaryTreeNode<Integer> root, int L, int R) {
        BinaryTreeNode<Integer> node;
        if (root == null) {
            return null;
        }
        //先找到根节点
        while (root != null) {
            if (root.val < L) {
                root = root.right;
            } else if (root.val > R) {
                root = root.left;
            } else {
                break;
            }
        }
        //根节点赋给node
        node = root;

        //筛选左侧节点
        while (node.left != null) {
            if (node.left.val < L) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        node = root;

        //筛选右侧节点
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
