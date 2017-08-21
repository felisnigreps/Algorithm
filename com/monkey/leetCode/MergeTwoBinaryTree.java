package com.monkey.leetCode;

import com.monkey.dataStructure.BinaryTreeNode;

/**
 * Created by xugenli on 2017/6/26.
 */
public class MergeTwoBinaryTree {


    public BinaryTreeNode mergeTrees(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 == null) {
            return t1;
        } else if (t1 == null && t2 != null) {
            return t2;
        } else {
            t1.val = Integer.parseInt(t1.val.toString()) + Integer.parseInt(t2.val.toString());
            // t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }
        return t1;
    }

    public static void main(String[] args) {
        BinaryTreeNode t1 = new BinaryTreeNode(1);
        BinaryTreeNode t2 = new BinaryTreeNode("2");
        t1.left = new BinaryTreeNode("3");
        t1.right = new BinaryTreeNode("4");
        t1.left.left = new BinaryTreeNode("4");
        t2.left = new BinaryTreeNode("2");
        t2.right = new BinaryTreeNode("4");
        t2.right.right = new BinaryTreeNode("7");
        MergeTwoBinaryTree test = new MergeTwoBinaryTree();
        System.out.println(test.mergeTrees(t1, t2));


    }
}