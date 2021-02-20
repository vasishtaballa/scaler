package com.scaler.academy.homework.nov13;

// Question: https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/

public class RemovingDuplicatesII {

	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		RemovingDuplicatesII obj = new RemovingDuplicatesII();
		obj.push(1);
		obj.push(2);
		obj.push(5);
		obj.push(5);
		obj.push(5);
		obj.push(5);
		obj.push(5);
		obj.push(5);
		obj.printLL(obj.head);
		ListNode result = obj.deleteDuplicates(obj.head);
		obj.printLL(result);
	}

	public ListNode deleteDuplicates(ListNode A) {
		ListNode previous = null, current = A;
		boolean equal = false;
		if (A.next == null)
			return A;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				equal = true;
			} else {
				if (previous == null && !equal)
					previous = current;
				else if (!equal)
					previous = previous.next;
				else {
					if (previous == null) {
						previous = null;
						A = current.next;
					} else
						previous.next = current.next;
					equal = false;
				}
			}
			current = current.next;
		}
		if (previous == null)
			return null;
		if (equal)
			previous.next = null;
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
