package com.academy.assignment.nov21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.academy.assignment.util.PrintUtility;
import com.academy.assignment.util.TreeNode;
import com.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/merge-two-bsts/

public class MergeTwoBSTs {

	public static void main(String[] args) {
		MergeTwoBSTs obj = new MergeTwoBSTs();
		String[] array1 = { "42", "28", "61", "13", "31", "56", "62", "11", "27", "29", "40", "46", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" };
		TreeNode tree1 = (TreeNode) TreeUtility.createTree(array1, new TreeNode());
		String[] array2 = { "78", "65", "93", "64", "71", "92", "100", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" };
		TreeNode tree2 = (TreeNode) TreeUtility.createTree(array2, new TreeNode());
		List<Integer> result = obj.solve(tree1, tree2);
		PrintUtility.printArrayList(result);
	}

	public ArrayList<Integer> solve(TreeNode A, TreeNode B) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		while (!stack1.isEmpty() || !stack2.isEmpty() || A != null || B != null) {
			while (A != null) {
				stack1.push(A);
				A = A.left;
			}
			while (B != null) {
				stack2.push(B);
				B = B.left;
			}
			if (!stack1.isEmpty() && !stack2.isEmpty()) {
				int a = stack1.peek().val;
				int b = stack2.peek().val;
				if (a < b) {
					result.add(a);
					A = stack1.pop();
					A = A.right;
				} else {
					result.add(b);
					B = stack2.pop();
					B = B.right;
				}
			} else {
				if (stack1.isEmpty())
					addElements(stack2, result);
				else if (stack2.isEmpty())
					addElements(stack1, result);
			}
		}
		return result;
	}

	private void addElements(Stack<TreeNode> stack, ArrayList<Integer> result) {
		TreeNode A = stack.pop();
		while (!stack.isEmpty() || A != null) {
			while (A != null) {
				stack.push(A);
				A = A.left;
			}
			A = stack.pop();
			result.add(A.val);
			A = A.right;
		}
	}

}
