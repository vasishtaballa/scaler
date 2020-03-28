package com.academy.homework.nov21;

import java.util.ArrayList;

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
		ArrayList<Integer> nodes = new ArrayList<>();
		getNodes(A, nodes);
		int count = 0;
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i) >= B && nodes.get(i) <= C)
				count += 1;
		}
		return count;
	}
	
	private void getNodes(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		getNodes(root.left, list);
		list.add(root.val);
		getNodes(root.right, list);
	}

}
