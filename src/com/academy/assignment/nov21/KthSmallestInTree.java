package com.academy.assignment.nov21;

import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/kth-smallest-element-in-tree/ 

public class KthSmallestInTree {

	public static void main(String[] args) {
		KthSmallestInTree obj = new KthSmallestInTree();
		String[] levelOrder = { "8", "5", "10", "4", "6", "9", "12" };
		TreeNode root = (TreeNode) TreeUtility.createTree(levelOrder, new TreeNode());
		System.out.println(obj.kthsmallest(root, 1));
	}

	public int kthsmallest(TreeNode A, int B) {
		int result = Integer.MAX_VALUE;
		int count = 0;
		while (A != null) {
			if (A.left == null) {
				count++;
				if (count == B)
					result = A.val;
				A = A.right;
			} else {
				TreeNode prev = A.left;
				while (prev.right != null && prev.right != A)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = A;
					A = A.left;
				} else {
					prev.right = null;
					count++;
					if (count == B)
						result = A.val;
					A = A.right;
				}
			}
		}
		return result;
	}
}
