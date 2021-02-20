package com.scaler.academy.assignment.util;

public class TreeNode extends BaseNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {

	}

	public TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "" + val;
	}

}
