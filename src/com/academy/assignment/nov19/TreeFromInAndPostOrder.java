package com.academy.assignment.nov19;

import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/ 

public class TreeFromInAndPostOrder {

	public static void main(String[] args) {
		TreeFromInAndPostOrder obj = new TreeFromInAndPostOrder();
		int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };
		TreeNode root = obj.buildTree(inOrder, postOrder);
		TreeUtility.printInorder(root);
	}

	public TreeNode buildTree(int[] A, int[] B) {
		Index preIndx = new Index();
		preIndx.index = A.length - 1;
		return buildTreeUtil(A, B, 0, A.length - 1, preIndx);
	}

	private TreeNode buildTreeUtil(int[] inOrder, int[] postOrder, int inStart, int inEnd, Index preIndex) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(postOrder[preIndex.index]);
		preIndex.index--;
		int inIndex = getInIndex(inOrder, node.val);
		if (inIndex == -1)
			return null;
		else {
			node.right = buildTreeUtil(inOrder, postOrder, inIndex + 1, inEnd, preIndex);
			node.left = buildTreeUtil(inOrder, postOrder, inStart, inIndex - 1, preIndex);
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