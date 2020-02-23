package com.academy.assignment.nov19;

import com.academy.assignment.util.TreeNode;

// Question: https://www.interviewbit.com/problems/check-if-given-preorder-inorder-and-postorder-traversals-are-of-same-tree/

public class CheckTreeFromTraversals {
	public static void main(String[] args) {
		CheckTreeFromTraversals obj = new CheckTreeFromTraversals();
		int[] preOrder = { 1, 2, 4, 5, 3 };
		int[] inOrder = { 4, 2, 5, 1, 3 };
		int[] postOrder = { 4, 5, 2, 3, 1 };
		System.out.println(obj.solve(preOrder, inOrder, postOrder));
	}

	public int solve(int[] A, int[] B, int[] C) {
		Index preIndx = new Index();
		preIndx.index = 0;
		Index postIndx = new Index();
		postIndx.index = B.length - 1;
		TreeNode tree1 = buildTreeFromPostInUtil(B, C, 0, B.length - 1, postIndx);
		TreeNode tree2 = buildTreeFromPreInUtil(A, B, 0, B.length - 1, preIndx);
		boolean result = areTreesEqual(tree1, tree2);
		return result == true ? 1 : 0;
	}

	private boolean areTreesEqual(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		if (tree1 != null && tree2 != null) {
			return (tree1.val == tree2.val && areTreesEqual(tree1.left, tree2.left)
					&& areTreesEqual(tree1.right, tree2.right));
		}
		return false;
	}

	private TreeNode buildTreeFromPreInUtil(int[] preOrder, int[] inOrder, int inStart, int inEnd, Index preIndx) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(preOrder[preIndx.index]);
		preIndx.index++;
		int inIndex = getInIndex(inOrder, node.val, inStart, inEnd);
		if (inStart == inEnd)
			return node;
		if (inIndex == -1)
			return null;
		else {
			node.left = buildTreeFromPreInUtil(preOrder, inOrder, inStart, inIndex - 1, preIndx);
			node.right = buildTreeFromPreInUtil(preOrder, inOrder, inIndex + 1, inEnd, preIndx);
		}
		return node;
	}

	private TreeNode buildTreeFromPostInUtil(int[] inOrder, int[] postOrder, int inStart, int inEnd, Index postIndx) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(postOrder[postIndx.index]);
		postIndx.index--;
		int inIndex = getInIndex(inOrder, node.val, inStart, inEnd);
		if (inStart == inEnd)
			return node;
		if (inIndex == -1)
			return null;
		else {
			node.right = buildTreeFromPostInUtil(inOrder, postOrder, inIndex + 1, inEnd, postIndx);
			node.left = buildTreeFromPostInUtil(inOrder, postOrder, inStart, inIndex - 1, postIndx);
		}
		return node;
	}

	private int getInIndex(int[] inOrder, int val, int start, int end) {
		for (int i = start; i <= end; i++)
			if (inOrder[i] == val)
				return i;
		return -1;
	}
}