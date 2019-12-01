package com.academy.homework.nov11;

// Question: https://www.interviewbit.com/problems/middle-element-of-linked-list/

public class MiddleElementLL {
	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		MiddleElementLL obj = new MiddleElementLL();
		obj.push(1);
		// obj.push(2);
		// obj.push(3);
		// obj.push(4);
		// obj.push(5);
		obj.printLL();
		System.out.println(obj.solve(obj.head));
	}

	public int solve(ListNode A) {
		ListNode slow = A, fast = A;
		while (fast != null) {
			if (fast.next == null)
				// Odd length
				return slow.val;
			else if (fast.next.next == null)
				// Even length
				return slow.next.val;
			slow = slow.next;
			fast = fast.next.next;
		}
		return -1;
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

	public void printLL() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

}
