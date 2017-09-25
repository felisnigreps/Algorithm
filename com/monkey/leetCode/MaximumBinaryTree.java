package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;
import com.monkey.dataStructure.TreeNodeUtil;

public class MaximumBinaryTree {

    public TreeNode calculate(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }


    public TreeNode<Integer> build(int[] nums, int start, int end) {
        if (start > end) return null;
        int idMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[idMax] < nums[i]) {
                idMax = i;
            }
        }
        TreeNode<Integer> root = new TreeNode<>(nums[idMax]);
        root.left = build(nums, start, idMax - 1);
        root.right = build(nums, idMax + 1, end);

        return root;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] num = {3, 2, 1, 6, 0, 5};
        MaximumBinaryTree a = new MaximumBinaryTree();
        TreeNode<Integer> root = new TreeNode<>();

        TreeNodeUtil.inOrder(a.calculate(num));


    }


}
