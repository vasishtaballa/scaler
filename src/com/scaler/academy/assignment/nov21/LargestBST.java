package com.scaler.academy.assignment.nov21;

import com.scaler.academy.assignment.util.TreeNode;
import com.scaler.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/largest-bst-subtree/
public class LargestBST {

	public static void main(String[] args) {
		LargestBST obj = new LargestBST();
		String[] array = { "1", "2", "3", "-1", "-1", "4", "-1", "-1", "5", "-1", "-1" };
		TreeNode root = (TreeNode) TreeUtility.createTree(array, new TreeNode());
		TreeUtility.printInorder(root);
		System.out.println(obj.solve(root));
	}

	public int solve(TreeNode A) {
		return solveUtil(A).ans;
	}

	public Result solveUtil(TreeNode A) {
		if (A == null)
			return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		if (A.left == null && A.right == null)
			return new Result(true, 1, A.val, A.val, 1);
		Result left = solveUtil(A.left);
		Result right = solveUtil(A.right);
		Result result = new Result();
		result.size = left.size + right.size + 1;
		if (left.isBST && right.isBST && A.val > left.maximum && A.val < right.minimum) {
			result.isBST = true;
			result.minimum = Math.min(left.minimum, Math.min(right.minimum, A.val));
			result.maximum = Math.max(right.maximum, Math.max(left.maximum, A.val));
			result.ans = result.size;
			return result;
		} else {
			result.isBST = false;
			result.ans = Math.max(left.ans, right.ans);
			return result;
		}
	}
}

class Result {
	boolean isBST = false;
	int ans = 0;
	int minimum = Integer.MAX_VALUE;
	int maximum = Integer.MIN_VALUE;
	int size = 0;

	public Result(boolean isBST, int ans, int minimum, int maximum, int size) {
		super();
		this.isBST = isBST;
		this.ans = ans;
		this.minimum = minimum;
		this.maximum = maximum;
		this.size = size;
	}

	public Result() {

	}

}