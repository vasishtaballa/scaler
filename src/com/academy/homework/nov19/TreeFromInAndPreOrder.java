package com.academy.homework.nov19;

import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/

public class TreeFromInAndPreOrder {
	public static void main(String[] args) {
		TreeFromInAndPreOrder obj = new TreeFromInAndPreOrder();
		int[] inOrder = { 4, 2, 5, 1, 3 };
		int[] preOrder = { 1, 2, 4, 5, 3 };
		TreeNode root = obj.buildTree(inOrder, preOrder);
		TreeUtility.printInorder(root);
	}

	public TreeNode buildTree(int[] A, int[] B) {
		Index preIndx = new Index();
		preIndx.index = 0;
		return buildTreeFromPreInUtil(A, B, 0, B.length - 1, preIndx);
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

	private int getInIndex(int[] inOrder, int val, int start, int end) {
		for (int i = start; i <= end; i++)
			if (inOrder[i] == val)
				return i;
		return -1;
	}
}

class Index {
	int index;
}
