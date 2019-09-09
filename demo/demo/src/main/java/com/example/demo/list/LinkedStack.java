package com.example.demo.list;

public class LinkedStack {
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	private Node head;
	public LinkedStack push(LinkedStack stack, int data) {
		Node new_node =  new Node(data);
		Node start = head;
		if(start ==  null) {
			head = new_node;
		} else {
			while(start.next != null) {
				start = start.next;
			}			
			start.next = new_node;
		}
		return stack;
	}
	
	public LinkedStack pop(LinkedStack stack) {
		Node start = head;
		if(start ==  null) {
			System.out.println("stack is empty");
		} else {
			while(start.next.next != null) {
				start = start.next;
			}
			start.next = null;
		}
		return stack;
	}
	
	public void printStack() {
		Node start = head;
		System.out.println("Data in stack: ");
		 while(start != null) {
			 System.out.println(start.data);
			 start = start.next;
		 }
	}
}

