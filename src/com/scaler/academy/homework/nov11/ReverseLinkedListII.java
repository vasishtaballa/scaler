package com.scaler.academy.homework.nov11;

// Question: https://www.interviewbit.com/problems/reverse-link-list-ii/

public class ReverseLinkedListII {
	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		ReverseLinkedListII obj = new ReverseLinkedListII();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		// obj.push(4);
		// obj.push(5);
		obj.printLL(obj.head);
		ListNode result = obj.reverseBetween(obj.head, 2, 3);
		obj.printLL(result);
	}

	public ListNode reverseBetween(ListNode A, int B, int C) {
		if (B == C)
			return A;
		ListNode startPrev = null, start = A, end = A, endNext = null;
		while ((start != null || end != null) && (B > 1 || C > 1)) {
			if (B-- > 1) {
				start = start.next;
				if (startPrev == null)
					startPrev = A;
				else
					startPrev = startPrev.next;
			}
			if (C-- > 1)
				end = end.next;
		}
		endNext = end.next;
		end.next = null;
		ListNode reverseList = reverseLL(start);
		if (startPrev != null) {
			startPrev.next = reverseList;
			start.next = endNext;
		} else {
			head = reverseList;
			start.next = endNext;
		}
		return head;
	}

	private ListNode reverseLL(ListNode head) {
		ListNode current = head, prev = null, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
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

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}