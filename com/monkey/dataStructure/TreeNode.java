package com.monkey.dataStructure;

/**
 * Created by xugenli on 2017/6/26.
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}