package com.academy.assignment.nov11;

// Question: https://www.interviewbit.com/problems/remove-nth-node-from-list-end/

public class RemoveNthNode {
	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		RemoveNthNode obj = new RemoveNthNode();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.printLL();
		obj.head = obj.removeNthFromEnd(obj.head, 1);
		obj.printLL();
	}

	public ListNode removeNthFromEnd(ListNode A, int B) {
		ListNode previous = A, current = A;
		while (B > 0 && current != null) {
			current = current.next;
			B--;
		}
		if (B >= 0 && current == null) {
			// B is greater than length of the list, so remove head
			A = A.next;
			return A;
		} else {
			while (current.next != null) {
				current = current.next;
				previous = previous.next;
			}
			previous.next = previous.next.next;
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

	public void printLL() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

}