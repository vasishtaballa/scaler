package com.scaler.academy.assignment.nov19;

import com.scaler.academy.assignment.util.TreeNode;
import com.scaler.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/ 

public class TreeFromInAndPostOrder {

	public static void main(String[] args) {
		TreeFromInAndPostOrder obj = new TreeFromInAndPostOrder();
		int[] inOrder = { 4, 2, 5, 1, 3 };
		int[] postOrder = { 4, 5, 2, 3, 1 };
		TreeNode root = obj.buildTree(inOrder, postOrder);
		TreeUtility.printInorder(root);
	}

	public TreeNode buildTree(int[] A, int[] B) {
		Index postIndx = new Index();
		postIndx.index = A.length - 1;
		return buildTreeUtil(A, B, 0, A.length - 1, postIndx);
	}

	private TreeNode buildTreeUtil(int[] inOrder, int[] postOrder, int inStart, int inEnd, Index postIndex) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(postOrder[postIndex.index]);
		postIndex.index--;
		int inIndex = getInIndex(inOrder, node.val);
		if (inIndex == -1)
			return null;
		else {
			node.right = buildTreeUtil(inOrder, postOrder, inIndex + 1, inEnd, postIndex);
			node.left = buildTreeUtil(inOrder, postOrder, inStart, inIndex - 1, postIndex);
		}
		return node;
	}

	private int getInIndex(int[] inOrder, int val) {
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == val)
				return i;
		}
		return -1;
	}

}

class Index {
	int index;
}