package com.academy.assignment.nov19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.academy.assignment.util.PrintUtility;
import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/postorder-traversal/ 

public class PostOrderTraversal {
	public static void main(String[] args) {
		PostOrderTraversal obj = new PostOrderTraversal();
		String[] array = { "1", "2", "3", "4", "5", "-1", "-1" };
		TreeNode root = (TreeNode) TreeUtility.createTree(array, new TreeNode());
		int[] result = obj.postorderTraversal(root);
		PrintUtility.printArray(result);
	}

	public int[] postorderTraversal(TreeNode A) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		while (!stack.isEmpty() || A != null) {
			while (A != null) {
				if (A.right != null)
					stack.push(A.right);
				stack.push(A);
				A = A.left;
			}
			TreeNode item = stack.pop();
			if (item.right != null && !stack.isEmpty() && item.right == stack.peek()) {
				// Process right first
				A = stack.pop();
				stack.push(item);
			} else {
				list.add(item.val);
				A = null;
			}
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
