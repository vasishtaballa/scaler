package com.scaler.academy.homework.nov19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.scaler.academy.assignment.util.PrintUtility;
import com.scaler.academy.assignment.util.TreeNode;
import com.scaler.academy.assignment.util.TreeUtility;

// Question: https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/

public class ZigZagLOT {

	public static void main(String[] args) {
		ZigZagLOT obj = new ZigZagLOT();
		String[] array = { "1", "2", "3", "4", "5", "6", "7", "8", "-1" };
		TreeNode root = (TreeNode) TreeUtility.createTree(array, new TreeNode());
		int[][] result = obj.zigzagLevelOrder(root);
		PrintUtility.printMatrix(result);
	}

	public int[][] zigzagLevelOrder(TreeNode A) {
		List<ArrayList<Integer>> list = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		int level = 1;
		int maxCols = -1;
		stack1.push(A);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			ArrayList<Integer> levelList = new ArrayList<>();
			if (level % 2 != 0) {
				// Odd levels -> Use Stack1
				while (!stack1.isEmpty()) {
					TreeNode item = stack1.pop();
					levelList.add(item.val);
					if (item.left != null)
						stack2.push(item.left);
					if (item.right != null)
						stack2.push(item.right);
				}
			} else {
				// Even levels -> Use Stack2
				while (!stack2.isEmpty()) {
					TreeNode item = stack2.pop();
					levelList.add(item.val);
					if (item.right != null)
						stack1.push(item.right);
					if (item.left != null)
						stack1.push(item.left);
				}
			}
			maxCols = Math.max(maxCols, levelList.size());
			list.add(levelList);
			level++;
		}
		return getMatrixFromList(list, maxCols);
	}

	private int[][] getMatrixFromList(List<ArrayList<Integer>> list, int maxCols) {
		int rows = list.size();
		int rowIdx = 0, colIdx = 0;
		int[][] result = new int[rows][];
		for (int i = 0; i < rows; i++) {
			colIdx = 0;
			result[i] = new int[list.get(i).size()];
			for (int j = 0; j < list.get(i).size(); j++)
				result[rowIdx][colIdx++] = list.get(i).get(j);
			rowIdx++;
		}
		return result;
	}

}
