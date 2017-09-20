package com.monkey.dataStructure;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xugenli on 2017/6/26.
 */
public class BinaryTreeNode<T> {
    public T val;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T val) {
        this.val = val;
    }

    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //preOrderRecursion 前序遍历(递归)
    //前序遍历指的是root在前,根->左->右的顺序进行遍历
    public void preOrder(BinaryTreeNode<T> t) {
        if (t != null) {
            System.out.print(t.val);
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    //inOrder 中序遍历 左->根->右
    public void inOrder(BinaryTreeNode<T> t) {
        if (t != null) {
            inOrder(t.left);
            System.out.print(t.val);
            inOrder(t.right);
        }
    }

    //postOrder 后序遍历 左-->右-->根
    public void postOrder(BinaryTreeNode<T> t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.print(t.val);
        }
    }

    //preOrder 前序遍历(迭代)
    public void preOrderNoRecursion(BinaryTreeNode<T> t) {
        if (t == null) {
            return;
        }
        //使用栈来进行数据操作
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        //先压入根节点
        stack.push(t);
        //栈为空退出循环
        while (!stack.isEmpty()) {
            //创建临时节点
            BinaryTreeNode node = stack.pop();
            System.out.print(node.val);
            //先压入右节点,保证左节点先出栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //inOrder 中序遍历 迭代
    public void inOrderNoRecursion(BinaryTreeNode<T> t) {
        if (t == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = t;
        //注意这的判断条件 而且不需要在循环之前让root入栈
        //要想到先把左子树先全部入栈,然后再遍历
        while (node != null || !stack.isEmpty()) {
            //先把所有左子树压进去
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //这个时候开始出栈
            node = stack.pop();
            System.out.print(node.val);
            node = node.right;

        }

    }

    //postOrder 后序遍历 迭代
    public void postOrderNoRecursion(BinaryTreeNode t) {
        if (t == null) {
            return;
        }
        //需要两个栈来进行操作,存储时,stackIn 根-->左-->右,出栈就是右-->左-->根
        //每循环一次就会取出一个元素到stackOut,那么stackOut的出栈顺序就是左-->右-->根
        //这块也许第一遍读不懂,要结合下面代码,因为根的入栈出栈和left right不在一个循环里 所以可以达到上述效果
        //拿ABC会很好分析
        BinaryTreeNode node = t;
        Stack<BinaryTreeNode> in = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> out = new Stack<BinaryTreeNode>();
        in.push(t);
        while(!in.isEmpty()){
            node = in.pop();
            out.push(node);
            if(node.left!=null){
                in.push(node.left);
            }
            if(node.right!=null){
                in.push(node.right);
            }

        }
        while (!out.isEmpty()){
            node = out.pop();
            System.out.print(node.val);
        }
    }

    //levelOrder 二叉树的层次遍历
    public void levelOrder(BinaryTreeNode t) throws InterruptedException {
        //使用队列 直接从左到右插入就好
        LinkedList<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode node = new BinaryTreeNode();
        list.add(t);
        while(!list.isEmpty()){
            node = list.poll();
            System.out.print(node.val);
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }
    }

    //invertTree 翻转/镜像二叉树
    public BinaryTreeNode invertTree(BinaryTreeNode t) {
        if(t==null){
            return null;
        }
        BinaryTreeNode temp = invertTree(t.left);
        t.left = invertTree(t.right);
        t.right = temp;

        return t;
    }

    //invertTree 翻转/镜像二叉树 迭代
    public BinaryTreeNode invertTreeNoRecursion(BinaryTreeNode t) {
        if(t==null){
            return null;
        }
        LinkedList<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
        list.add(t);
        while(!list.isEmpty()){
            BinaryTreeNode node = list.poll();
            BinaryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }
        return t;
    }

    //maxDepth 最大深度
    public int maxDepth(BinaryTreeNode t){
        if(t==null){
            return 0;
        }
        int left = maxDepth(t.left);
        int right = maxDepth(t.right);


        return Math.max(left,right)+1;
    }

/*
    一棵BST定义为：
    节点的左子树中的值要严格小于该节点的值。
    节点的右子树中的值要严格大于该节点的值。
    左右子树也必须是二叉查找树。
    一个节点的树也是二叉查找树。
*/
    //isValidBST 判断二叉树是否是合法的二叉查找树(BST)
    //只要是中序遍历,然后是从小到大排列的代表是合法的二叉查找树


}