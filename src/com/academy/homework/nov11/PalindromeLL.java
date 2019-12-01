package com.academy.homework.nov11;

public class PalindromeLL {
	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		PalindromeLL obj = new PalindromeLL();
		obj.push(1);
		obj.push(1);
		// obj.push(1);
		// obj.push(3);
		// obj.push(2);
		// obj.push(1);
		obj.printLL(obj.head);
		System.out.println(obj.lPalin(obj.head));
	}

	public int lPalin(ListNode A) {
		ListNode slow = A, fast = A, secondList = null, slowPrev = null;
		if (A.next == null)
			return 1;
		while (fast != null && fast.next != null) {
			if (slowPrev == null)
				slowPrev = A;
			else
				slowPrev = slowPrev.next;
			slow = slow.next;
			fast = fast.next.next;
		}
		slowPrev.next = null;
		if (fast == null)
			// Even length
			secondList = reverseLL(slow);
		else if (fast.next == null)
			// Odd length
			secondList = reverseLL(slow.next);
		ListNode head = A;
		while (head != null && secondList != null) {
			if (head.val != secondList.val)
				return 0;
			head = head.next;
			secondList = secondList.next;
		}
		if (head != null || secondList != null)
			return 0;
		return 1;
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
