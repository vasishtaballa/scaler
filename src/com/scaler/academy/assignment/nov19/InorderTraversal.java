package com.scaler.academy.assignment.nov19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.scaler.academy.assignment.util.PrintUtility;
import com.scaler.academy.assignment.util.TreeNode;
import com.scaler.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/inorder-traversal/

public class InorderTraversal {
	public static void main(String[] args) {
		InorderTraversal obj = new InorderTraversal();
		String[] array = { "1", "2", "3", "4", "5", "-1", "-1" };
		TreeNode root = (TreeNode) TreeUtility.createTree(array, new TreeNode());
		int[] result = obj.inorderTraversal(root);
		PrintUtility.printArray(result);
	}

	public int[] inorderTraversal(TreeNode A) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while (!stack.isEmpty() || A != null) {
			while (A != null) {
				stack.push(A);
				A = A.left;
			}
			A = stack.pop();
			list.add(A.val);
			A = A.right;
		}
		return getArrayFromList(list);
	}

	private int[] getArrayFromList(List<Integer> list) {
		int[] result = new int[list.size()];
		int index = 0;
		for (Integer item : list)
			result[index++] = item;
		return result;
	}
}
