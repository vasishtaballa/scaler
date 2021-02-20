package com.scaler.academy.homework.nov21;

import java.util.Stack;

import com.scaler.academy.assignment.util.GeneralUtility;
import com.scaler.academy.assignment.util.TreeNode;
import com.scaler.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/common-nodes-in-two-binary-search-trees/

public class CommonNodesInBST {

	public static void main(String[] args) {
		CommonNodesInBST obj = new CommonNodesInBST();
		int[] arr1 = { 5, 2, 8, -1, 3, -1, 15, -1, -1, 7, -1 };
		int[] arr2 = { 7, 1, 10, -1, 2, -1, 15, -1, -1, 8, -1 };
		String[] array1 = GeneralUtility.getStrFrmInt(arr1);
		String[] array2 = GeneralUtility.getStrFrmInt(arr2);
		TreeNode root1 = (TreeNode) TreeUtility.createTree(array1, new TreeNode());
		TreeNode root2 = (TreeNode) TreeUtility.createTree(array2, new TreeNode());
		System.out.println(obj.solve(root1, root2));
	}

	public int solve(TreeNode A, TreeNode B) {
		int result = 0;
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		while (true) {
			if (A != null) {
				stack1.push(A);
				A = A.left;
			} else if (B != null) {
				stack2.push(B);
				B = B.left;
			} else if (!stack1.isEmpty() && !stack2.isEmpty()) {
				A = stack1.peek();
				B = stack2.peek();
				if (A.val == B.val) {
					result += A.val;
					stack1.pop();
					stack2.pop();
					A = A.right;
					B = B.right;
				}
				else if (A.val > B.val) {
					stack2.pop();
					B = B.right;
					A = null;
				} else if(A.val < B.val) {
					stack1.pop();
					A = A.right;
					B = null;
				}
			} else
				break;
		}
		return result;
	}

}
