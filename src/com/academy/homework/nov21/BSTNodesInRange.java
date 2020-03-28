package com.academy.homework.nov21;

import com.academy.assignment.util.GeneralUtility;
import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/bst-nodes-in-a-range/

public class BSTNodesInRange {

	public static void main(String[] args) {
		BSTNodesInRange obj = new BSTNodesInRange();
		int[] intArray = { 15, 12, 20, 10, 14, 16, 27, 8, -1, -1, -1, -1, -1, -1, -1 };
		TreeNode root = (TreeNode) TreeUtility.createTree(GeneralUtility.getStrFrmInt(intArray), new TreeNode());
		System.out.println(obj.solve(root, 12, 20));
	}

	public int solve(TreeNode A, int B, int C) {
		if (A == null)
			return 0;
		if (A.val >= B && A.val <= C)
			return 1 + solve(A.left, B, C) + solve(A.right, B, C);
		else if (A.val < B)
			return solve(A.right, B, C);
		else
			return solve(A.left, B, C);
	}

}
