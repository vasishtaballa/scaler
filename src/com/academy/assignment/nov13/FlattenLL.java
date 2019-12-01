package com.academy.assignment.nov13;

// Question: https://www.geeksforgeeks.org/flattening-a-linked-list/

public class FlattenLL {

	DualPointerNode head = null;

	public static void main(String[] args) {

		FlattenLL obj = new FlattenLL();

		obj.head = obj.push(obj.head, 30);
		obj.head = obj.push(obj.head, 8);
		obj.head = obj.push(obj.head, 7);
		obj.head = obj.push(obj.head, 5);

		obj.head.right = obj.push(obj.head.right, 20);
		obj.head.right = obj.push(obj.head.right, 10);

		obj.head.right.right = obj.push(obj.head.right.right, 50);
		obj.head.right.right = obj.push(obj.head.right.right, 22);
		obj.head.right.right = obj.push(obj.head.right.right, 19);

		obj.head.right.right.right = obj.push(obj.head.right.right.right, 45);
		obj.head.right.right.right = obj.push(obj.head.right.right.right, 40);
		obj.head.right.right.right = obj.push(obj.head.right.right.right, 35);
		obj.head.right.right.right = obj.push(obj.head.right.right.right, 20);

		DualPointerNode result = obj.flatten(obj.head);
		obj.printLL(result);

	}

	DualPointerNode flatten(DualPointerNode root) {
		if (root == null || root.right == null)
			return root;
		root.right = flatten(root.right);
		root = merge(root, root.right);
		return root;
	}

	DualPointerNode merge(DualPointerNode list1, DualPointerNode list2) {
		DualPointerNode finalHead = null, finalTail = null;
		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				if (finalHead == null) {
					finalHead = list1;
					finalTail = list1;
				} else {
					finalTail.down = list1;
					finalTail = list1;
				}
				list1 = list1.down;
			} else {
				if (finalHead == null) {
					finalHead = list2;
					finalTail = list2;
				} else {
					finalTail.down = list2;
					finalTail = list2;
				}
				list2 = list2.down;
			}
		}
		if (list1 != null)
			finalTail.down = list1;
		if (list2 != null)
			finalTail.down = list2;
		return finalHead;
	}

	public DualPointerNode push(DualPointerNode head, int data) {
		DualPointerNode newNode = new DualPointerNode(data);
		newNode.down = head;
		head = newNode;
		return head;
	}

	public void printLL(DualPointerNode head) {
		while (head.down != null) {
			System.out.print(head.data + " -> ");
			head = head.down;
		}
	}

}

class DualPointerNode {
	int data;
	DualPointerNode right;
	DualPointerNode down;

	public DualPointerNode(int data) {
		super();
		this.data = data;
	}

}
