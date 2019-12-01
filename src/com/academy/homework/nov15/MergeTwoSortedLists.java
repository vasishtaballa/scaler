package com.academy.homework.nov15;

import com.academy.homework.nov13.ListNode;

//Question: https://www.interviewbit.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists {
	ListNode head1 = null;
	ListNode tail1 = null;
	ListNode head2 = null;
	ListNode tail2 = null;

	public static void main(String[] args) {
		MergeTwoSortedLists obj = new MergeTwoSortedLists();
		obj.push(5, "list1");
		obj.push(8, "list1");
		obj.push(20, "list1");
		obj.push(4, "list2");
		obj.push(11, "list2");
		obj.push(15, "list2");
		obj.printLL(obj.head1);
		obj.printLL(obj.head2);
		ListNode finalHead = obj.mergeTwoLists(obj.head1, obj.head2);
		obj.printLL(finalHead);
	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode finalHead = null, finalTail = null;
		while (A != null && B != null) {
			if (A.val < B.val) {
				if (finalHead == null) {
					finalHead = A;
					finalTail = A;
				} else {
					finalTail.next = A;
					finalTail = A;
				}
				A = A.next;
			} else {
				if (finalHead == null) {
					finalHead = B;
					finalTail = B;
				} else {
					finalTail.next = B;
					finalTail = B;
				}
				B = B.next;
			}
		}
		if (A != null)
			finalTail.next = A;
		if (B != null)
			finalTail.next = B;
		return finalHead;
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
		} else {
			if (head2 == null) {
				head2 = node;
				tail2 = node;
			} else {
				tail2.next = node;
				tail2 = node;
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
