package com.scaler.academy.assignment.nov11;

import java.util.Scanner;

public class LinkedListImpl {

	static ListNode head = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = 0, position = 0, value = 0;
		cases = s.nextInt();
		for (int i = 0; i < cases; i++) {
			char ch = s.next().charAt(0);
			switch (ch) {
			case 'i':
				position = s.nextInt();
				value = s.nextInt();
				insert_node(position, value);
				break;
			case 'd':
				position = s.nextInt();
				delete_node(position);
				break;
			case 'p':
				print_ll();
				System.out.println();
				break;
			default:
				System.out.println("Check Your Input");
			}
		}
		s.close();
	}

	public static void insert_node(int position, int value) {
		// @params position, integer
		// @params value, integer
		ListNode current = head, previous = null;
		int count = 1;
		ListNode node = new ListNode(value);
		// Insert at start/head of the LinkedList
		if (position == 1) {
			node.next = head;
			head = node;
			return;
		}
		while (count < position) {
			current = current.next;
			if (previous == null)
				previous = head;
			else
				previous = previous.next;
			count++;
		}
		if (count == position && current == null) {
			// Insert at end of the LinkedList
			previous.next = node;
		} else {
			ListNode temp = previous.next;
			previous.next = node;
			node.next = temp;
		}
	}

	public static void delete_node(int position) {
		// @params position, integer
		ListNode current = head;
		ListNode previous = null;
		if (position == 1) {
			head = head.next;
			return;
		}
		int count = 1;
		while (count < position && current != null) {
			current = current.next;
			if (previous == null)
				previous = head;
			else
				previous = previous.next;
			count++;
		}
		if (current == null)
			return;
		previous.next = previous.next.next;
	}

	public static void print_ll() {
		// Output each element followed by a space
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

}
