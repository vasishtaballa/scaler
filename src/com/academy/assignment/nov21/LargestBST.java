package com.academy.assignment.nov21;

import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/largest-bst-subtree/
public class LargestBST {

	public static void main(String[] args) {
		LargestBST obj = new LargestBST();
		String[] array = { "10", "5", "15", "1", "8", "7" };
		TreeNode root = (TreeNode) TreeUtility.createTree(array, new TreeNode());
		System.out.println(obj.solve(root));
	}

	public int solve(TreeNode A) {
		Value value = new Value();
		largestBSTUtil(A, value, value, value, value);
		return value.maxSize;
	}

	private int largestBSTUtil(TreeNode root, Value max, Value min, Value isBst, Value maxSize) {
		if (root == null) {
			isBst.isBst = true;
			return 0;
		}
		int leftSize = 0, rightSize = 0;
		boolean leftFlag = false, rightFlag = false;
		max.maximum = Integer.MIN_VALUE;
		leftSize = largestBSTUtil(root.left, max, min, isBst, maxSize);
		if (isBst.isBst && root.val > max.maximum)
			leftFlag = true;
		int minimumValue = min.minimum;
		min.minimum = Integer.MAX_VALUE;
		rightSize = largestBSTUtil(root.right, max, min, isBst, maxSize);
		if (isBst.isBst && root.val < min.minimum)
			rightFlag = true;
		if (minimumValue < min.minimum)
			min.minimum = minimumValue;
		if (min.minimum > root.val)
			min.minimum = root.val;
		if (max.maximum < root.val)
			max.maximum = root.val;
		if (leftFlag && rightFlag) {
			if (leftSize + rightSize + 1 > maxSize.maxSize)
				maxSize.maxSize = leftSize + rightSize + 1;
			return leftSize + rightSize + 1;
		} else {
			isBst.isBst = false;
			return 0;
		}
	}
}

class Value {
	boolean isBst = false;
	int minimum = Integer.MAX_VALUE;
	int maximum = Integer.MIN_VALUE;
	int maxSize = 0;
}
