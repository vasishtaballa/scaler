package com.scaler.academy.assignment.nov11;

// Question: https://www.interviewbit.com/problems/list-cycle/

public class ListCycle {
	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		ListCycle obj = new ListCycle();
		String input = "11->87797->23219->41441->58396->48953->94603->2721->95832->49029->98448->65450";
		String[] tokens = input.split("->");
		for (int i = 0; i < tokens.length; i++) {
			int item = Integer.parseInt(tokens[i]);
			obj.push(item);
		}
		obj.printLL();
		// Adding loop
		// obj.head.next.next.next = obj.head.next.next;
		System.out.println(obj.detectCycle(obj.head).val);
	}

	public ListNode detectCycle(ListNode a) {
		ListNode slow = a, fast = a;
		while (true) {
			if (fast == null || slow == null || fast.next == null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast && slow != null)
				break;
		}
		int cycleLength = 1;
		while (slow.next != fast) {
			slow = slow.next;
			cycleLength++;
		}
		slow = a;
		fast = a;
		while (cycleLength > 0) {
			slow = slow.next;
			cycleLength--;
		}
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
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
