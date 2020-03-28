package com.academy.assignment.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtility {
	public static BaseNode createTree(String[] levelOrder, BaseNode type) {
		if (type instanceof TreeNode) {
			return buildTreeNodeTree(levelOrder);
		}
		return null;
	}

	private static TreeNode buildTreeNodeTree(String[] levelOrder) {
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = null;
		for (String item : levelOrder) {
			TreeNode treeNode = new TreeNode(Integer.parseInt(item));
			if (root == null)
				root = treeNode;
			else if (queue.peek().left == null) {
				queue.peek().left = treeNode;
			} else {
				queue.peek().right = treeNode;
				queue.poll();
			}
			if (Integer.parseInt(item) != -1)
				queue.add(treeNode);
		}
		root = deleteUnwantedLeaves(root);
		return root;
	}

	/**
	 * This method delete all -1's that are present as leaves in the tree
	 * 
	 * @param root
	 * @return
	 */
	private static TreeNode deleteUnwantedLeaves(TreeNode root) {
		if (root == null)
			return null;
		root.left = deleteUnwantedLeaves(root.left);
		root.right = deleteUnwantedLeaves(root.right);
		if (root.val == -1 && root.left == null && root.right == null)
			return null;
		return root;
	}

	public static void printInorder(TreeNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	/**
	 * This method returns ArrayList of in-order of any tree
	 * 
	 * @param root
	 * @param list
	 */
	public static void getNodes(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		getNodes(root.left, list);
		list.add(root.val);
		getNodes(root.right, list);
	}
}
