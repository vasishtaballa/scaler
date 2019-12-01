package com.academy.homework.nov13;

// Question: https://www.interviewbit.com/problems/length-of-longest-palindromic-list/

public class LengthOfLongestPalindromicList {

	ListNode head = null;
	ListNode tail = null;

	public static void main(String[] args) {
		LengthOfLongestPalindromicList obj = new LengthOfLongestPalindromicList();
		obj.push(2);
		obj.push(2);
		/*
		 * obj.push(1); obj.push(2); obj.push(1); obj.push(2); obj.push(2); obj.push(1);
		 * obj.push(3); obj.push(2); obj.push(2);
		 */
		obj.printLL(obj.head);
		System.out.println(obj.solve(obj.head));
	}

	public int solve(ListNode A) {
		ListNode current = A, previous = null, next = null;
		int maxLength = 0;
		while (current != null) {
			next = current.next;
			current.next = previous;
			maxLength = Math.max(maxLength, 2 * equalNodes(previous, next) + 1);
			maxLength = Math.max(maxLength, 2 * equalNodes(current, next));
			previous = current;
			current = next;
		}
		return maxLength;
	}

	private int equalNodes(ListNode a, ListNode b) {
		int count = 0;
		while (a != null && b != null) {
			if (a.val == b.val)
				count++;
			else
				break;
			a = a.next;
			b = b.next;
		}
		return count;
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
