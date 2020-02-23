package com.academy.homework.nov19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.academy.assignment.util.PrintUtility;
import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/preorder-traversal/

public class PreorderTraversal {
	public static void main(String[] args) {
		PreorderTraversal obj = new PreorderTraversal();
		String[] array = { "1", "2", "3", "4", "5", "-1", "-1" };
		TreeNode root = (TreeNode) TreeUtility.createTree(array, new TreeNode());
		int[] result = obj.preorderTraversal(root);
		PrintUtility.printArray(result);
	}

	public int[] preorderTraversal(TreeNode A) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(A);
		while (!stack.isEmpty()) {
			TreeNode item = stack.pop();
			list.add(item.val);
			if (item.right != null)
				stack.push(item.right);
			if (item.left != null)
				stack.push(item.left);
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
