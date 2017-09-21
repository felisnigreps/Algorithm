package com.monkey.BinaryTree;

import com.monkey.dataStructure.BinaryTreeNode;
import com.monkey.leetCode.TrimBST;

public class BinaryTreeDemo {
    //minDepth 最小深度
    //numOfTreeNode 节点个数
    //numOfChildNode 叶子节点个数
    //numOfkLevelNode 第K层节点的个数
    //isBalanced 是否为平衡二叉树
    //isComplete 是否为完全二叉树
    //isSameTreeNode 二叉树是否相同
    //isMirror 是否互为镜像
    //getLastCommonParent 二叉树最低的公共祖先节点

    //buildBinaryTree 前序遍历和后序遍历构造二叉树
    //insertNode 二叉树中插入节点
    //findPath 输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
    //searchRange 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。
    // 即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
    //maxLength 二叉树内两个节点的最长距离
    //numTrees 给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？


    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E            F
     *  </pre>
     */
    public static void main(String[] args) throws InterruptedException {
        BinaryTreeNode<String> bTree = new BinaryTreeNode<String>("A");
        //也可以使用insertLeft方法等新建结点,按照方法插入
        bTree.left = new BinaryTreeNode("B");
        bTree.left.left = new BinaryTreeNode("D");
        bTree.left.right = new BinaryTreeNode("E");
        bTree.right = new BinaryTreeNode("C");
        bTree.right.right = new BinaryTreeNode("F");

        System.out.println("---前序遍历---");
        bTree.preOrder(bTree);
        System.out.println();
        System.out.println("---前序遍历非递归---");
        bTree.preOrderNoRecursion(bTree);
        System.out.println();

        System.out.println("---中序遍历---");
        bTree.inOrder(bTree);
        System.out.println();
        System.out.println("---中序遍历非递归---");
        bTree.inOrderNoRecursion(bTree);
        System.out.println();

        System.out.println("---后序遍历---");
        bTree.postOrder(bTree);
        System.out.println();
        System.out.println("---后序遍历非递归---");
        bTree.postOrderNoRecursion(bTree);
        System.out.println();

        System.out.println("---层次遍历---");
        bTree.levelOrder(bTree);
        System.out.println();

        System.out.println("---翻转二叉树---");
        bTree.levelOrder(bTree.invertTree(bTree));
        System.out.println();
        //翻转了一次又翻转过来了
        bTree.levelOrder(bTree.invertTreeNoRecursion(bTree));
        System.out.println();

        System.out.println("---最大深度---");
        System.out.println(bTree.maxDepth(bTree));

        System.out.println("---修剪二叉树---");
        TrimBST a = new TrimBST();
        BinaryTreeNode<Integer> cache = new BinaryTreeNode<Integer>(1);
        cache.left = new BinaryTreeNode<Integer>(0);
        cache.right= new BinaryTreeNode<Integer>(2);
        cache.levelOrder(a.trimBST(cache,1,2));


    }

}
