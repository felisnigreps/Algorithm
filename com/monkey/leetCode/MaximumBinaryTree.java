package com.monkey.leetCode;

import com.monkey.dataStructure.TreeNode;
import com.monkey.dataStructure.TreeNodeUtil;

public class MaximumBinaryTree {
    public TreeNode calculate(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int nums[], int start, int end) {
        if (start > end) return null;
        //找到最大节点 左右子树使用递归
        int idMax = start;
        //注意边界
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idMax]) {
                idMax = i;
            }
        }
        //找到最初节点
        TreeNode root = new TreeNode(nums[idMax]);
        root.left = build(nums, start, idMax - 1);
        root.right = build(nums, idMax + 1, end);
        return root;

    }

    public static void main(String[] args) throws InterruptedException {
        int[] num = {3, 2, 1, 6, 0, 5};
        MaximumBinaryTree a = new MaximumBinaryTree();
        TreeNode result = a.calculate(num);
        TreeNodeUtil.levelOrder(result);

    }
}
