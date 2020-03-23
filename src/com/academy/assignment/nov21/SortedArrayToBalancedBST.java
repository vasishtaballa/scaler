package com.academy.assignment.nov21;

import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/

public class SortedArrayToBalancedBST {

	public static void main(String[] args) {
		SortedArrayToBalancedBST obj = new SortedArrayToBalancedBST();
		int[] array = { 1, 2, 3, 4, 5, 6 };
		TreeUtility.printInorder(obj.sortedArrayToBST(array));
	}

	public TreeNode sortedArrayToBST(final int[] A) {
		return sortedArrToBSTUtil(A, 0, A.length - 1);
	}

	private TreeNode sortedArrToBSTUtil(int[] array, int low, int high) {
		if (low > high)
			return null;
		int mid = (int) Math.ceil(low + (double) ((double) high - (double) low) / 2.0);
		TreeNode root = new TreeNode(array[mid]);
		if (low == high)
			return root;
		root.left = sortedArrToBSTUtil(array, low, mid - 1);
		root.right = sortedArrToBSTUtil(array, mid + 1, high);
		return root;
	}

}
