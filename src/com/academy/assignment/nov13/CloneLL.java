package com.academy.assignment.nov13;

// Question: https://www.interviewbit.com/problems/copy-list/

public class CloneLL {

	SpecialNode head = null;
	SpecialNode current = null;

	public static void main(String[] args) {

	}

	SpecialNode cloneList(SpecialNode A) {
		SpecialNode newHead = null, newTail = null;
		while (A != null) {
			SpecialNode newNode = new SpecialNode(A.data);
			newNode.next = A.next;
			newNode.random = A.random;
			if (newHead == null) {
				newHead = newNode;
				newTail = newNode;
			} else {
				newTail.next = newNode;
				newTail = newNode;
			}
			A = A.next;
		}
		return newHead;
	}

}

class SpecialNode {
	int data;
	SpecialNode next;
	SpecialNode random;

	public SpecialNode(int data) {
		super();
		this.data = data;
	}

}
