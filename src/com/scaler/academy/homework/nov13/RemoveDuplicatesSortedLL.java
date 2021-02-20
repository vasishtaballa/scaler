package com.scaler.academy.homework.nov13;

// Question: https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesSortedLL {

	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		RemoveDuplicatesSortedLL obj = new RemoveDuplicatesSortedLL();
		obj.push(1);
		obj.push(2);
		obj.push(2);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(5);
		obj.push(5);
		obj.printLL(obj.head);
		obj.printLL(obj.deleteDuplicates(obj.head));
	}

	public ListNode deleteDuplicates(ListNode A) {
		ListNode current = A;
		while (current != null && current.next != null) {
			if (current.val == current.next.val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return A;
	}

	public void push(int data) {
		ListNode node = new ListNode(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public void printLL(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

}
