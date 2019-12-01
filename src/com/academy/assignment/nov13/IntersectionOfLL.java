package com.academy.assignment.nov13;

// Question: https://www.interviewbit.com/problems/intersection-of-linked-lists/

public class IntersectionOfLL {
	ListNode head1 = null;
	ListNode tail1 = null;
	ListNode head2 = null;
	ListNode tail2 = null;
	ListNode head3 = null;
	ListNode tail3 = null;

	public static void main(String[] args) {
		IntersectionOfLL obj = new IntersectionOfLL();
		obj.push(1, "list1");
		obj.push(3, "list2");
		obj.push(5, "list3");
		obj.push(2, "list3");
		obj.push(3, "list3");
		obj.printLL(obj.head1);
		obj.printLL(obj.head2);
		obj.printLL(obj.head3);
		obj.tail1.next = obj.head3;
		obj.tail2.next = obj.head3;
		obj.printLL(obj.head1);
		obj.printLL(obj.head2);
		obj.printLL(obj.head3);
		System.out.println("Answer is: " + obj.getIntersectionNode(obj.head1, obj.head2).val);
	}

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int length1 = getLength(a);
		int length2 = getLength(b);
		int difference = Math.abs(length1 - length2);
		if (length1 > length2) {
			while (difference > 0) {
				a = a.next;
				difference--;
			}
		} else if (length2 > length1) {
			while (difference > 0) {
				b = b.next;
				difference--;
			}
		}
		if (a == b)
			return a;
		while (a != null && b != null) {
			if (a.next == b.next)
				return a.next;
			a = a.next;
			b = b.next;
		}
		return null;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	public void push(int data, String list) {
		ListNode node = new ListNode(data);
		if (list.equals("list1")) {
			if (head1 == null) {
				head1 = node;
				tail1 = node;
			} else {
				tail1.next = node;
				tail1 = node;
			}
		} else if (list.equals("list2")) {
			if (head2 == null) {
				head2 = node;
				tail2 = node;
			} else {
				tail2.next = node;
				tail2 = node;
			}
		} else if (list.equals("list3")) {
			if (head3 == null) {
				head3 = node;
				tail3 = node;
			} else {
				tail3.next = node;
				tail3 = node;
			}
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
