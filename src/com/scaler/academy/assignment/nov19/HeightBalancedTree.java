package com.scaler.academy.assignment.nov19;

import com.scaler.academy.assignment.util.TreeNode;
import com.scaler.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/balanced-binary-tree/

public class HeightBalancedTree {

	public static void main(String[] args) {
		HeightBalancedTree obj = new HeightBalancedTree();
		String[] nodes = { "1", "2", "3", "4", "-1", "-1", "-1", "5" };
		TreeNode root = (TreeNode) TreeUtility.createTree(nodes, new TreeNode());
		TreeUtility.printInorder(root);
		System.out.println();
		System.out.println(obj.isBalanced(root, new Height()));
	}

	public int isBalanced(TreeNode A, Height height) {
		if (A == null) {
			height.height = 0;
			return 1;
		}
		Height leftHeight = new Height();
		Height rightHeight = new Height();
		int leftB = isBalanced(A.left, leftHeight);
		int rightB = isBalanced(A.right, rightHeight);
		height.height = 1 + Math.max(leftHeight.height, rightHeight.height);
		if (leftB == 1 && rightB == 1 && Math.abs(leftHeight.height - rightHeight.height) <= 1)
			return 1;
		return 0;
	}

	public int getHeight(TreeNode A) {
		if (A == null)
			return 0;
		int leftHeight = getHeight(A.left);
		int rightHeight = getHeight(A.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

}

class Height {
	int height = 0;
}
