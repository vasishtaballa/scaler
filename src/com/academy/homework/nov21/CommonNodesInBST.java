package com.academy.homework.nov21;

import java.util.ArrayList;

import com.academy.assignment.util.GeneralUtility;
import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/common-nodes-in-two-binary-search-trees/

public class CommonNodesInBST {

	public static void main(String[] args) {
		CommonNodesInBST obj = new CommonNodesInBST();
		int[] arr1 = { 5, 2, 8, -1, 3, -1, 15, 7, -1 };
		int[] arr2 = { 7, 1, 10, -1, 2, -1, 15, 8, -1 };
		String[] array1 = GeneralUtility.getStrFrmInt(arr1);
		String[] array2 = GeneralUtility.getStrFrmInt(arr2);
		TreeNode root1 = (TreeNode) TreeUtility.createTree(array1, new TreeNode());
		TreeNode root2 = (TreeNode) TreeUtility.createTree(array2, new TreeNode());
		System.out.println(obj.solve(root1, root2));
	}

	public int solve(TreeNode A, TreeNode B) {
		ArrayList<Integer> treeA = new ArrayList<>();
		ArrayList<Integer> treeB = new ArrayList<>();
		getNodes(A, treeA);
		getNodes(B, treeB);
		int result = 0;
		for (int i = 0; i < treeA.size(); i++) {
			if (treeB.contains(treeA.get(i)))
				result += treeA.get(i);
		}
		return result;
	}

	private void getNodes(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		getNodes(root.left, list);
		list.add(root.val);
		getNodes(root.right, list);
	}

}
