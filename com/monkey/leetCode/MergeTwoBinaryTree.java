package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;

/**
 * Created by xugenli on 2017/6/26.
 */
public class MergeTwoBinaryTree {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode("2");
        t1.left = new TreeNode("3");
        t1.right = new TreeNode("4");
        t1.left.left = new TreeNode("4");
        t2.left = new TreeNode("2");
        t2.right = new TreeNode("4");
        t2.right.right = new TreeNode("7");
        MergeTwoBinaryTree test = new MergeTwoBinaryTree();
        System.out.println(test.mergeTrees(t1, t2));


    }
}