package com.example.demo.list;

public class DoubleLinkedList {
	
	static class Node {
		int data;
		Node next;
		Node previous;
		
		Node(int data) {
			this.data = data;
			next = null;
			previous = null;
		}
	}
	
	private Node head;
	private Node last;
	
	public DoubleLinkedList insert(DoubleLinkedList list, int data) {
		
		Node new_node = new Node(data);
		
		if(head == null && last == null) {
			head = new_node;
			last = new_node;
		} else {
			Node start = head;
			while(start.next != null) {		
				start = start.next;
			}
			new_node.previous = start;
			start.next = new_node;
			last = new_node;
		}		
		return list;
	}
	
	public DoubleLinkedList insertAtIndex(DoubleLinkedList list, int data) {
		Node new_node = new Node(data);
		if(head ==  null && last == null) {
			head = new_node;
			last = new_node;
		} else {
			Node start = head;
			while(start.next != null && start.data != data) {
				start = start.next;
			}
			
			if(start.data == data && start.next != null) {
				new_node.next = start.next;
				start.next = new_node;
				new_node.previous = start;
				new_node.next.previous = new_node;
			}
			
			if(start.data ==  data && start.next == null) {
				new_node.previous = start;
				start.next = new_node;
				last = new_node;
			}
		}
		return list;
	}
	
	public DoubleLinkedList insertAtHead(DoubleLinkedList list, int data) {
		
		Node new_node = new Node(data);		
		if(head == null && last == null) {
			head = new_node;
			last = new_node;
		} else {
			Node start = head;
			new_node.next = start;
			start.previous = new_node;
			head = new_node;
		}		
		return list;
	}
	
	public DoubleLinkedList remove(DoubleLinkedList list, int data) {
		if(head == null && last ==  null) {
			System.out.println("List is Empty");
		} else {
			Node start = head;
			
			if(start.next == null && last == start) {
				start = null;
				last = null;
			}
			
			while(start.next != null && start.data !=  data) {
				start = start.next;
			}
			
			if(start.data == data && start.previous == null) {
				start.next.previous = null;
				start = start.next;
				head = start;
			}
			
			if(start.data == data && start.next == null) {
				last = start.previous;
				start.previous.next = null;
			}
			
			if(start.data == data && start.next != null) {
				start.next.previous = start.previous;
				start.previous.next = start.next;				
			}
		}
		
		return list;
	}

	
	public void printListLast(DoubleLinkedList list) {
		Node start = last;
		System.out.println("Data Double in List: ");
		while(start != null) {
			System.out.println(start.data + " Link: " + start.previous);
			start = start.previous;
		}
	}
	
	public void printListNext(DoubleLinkedList list) {
		Node start = head;
		System.out.println("Data Double in List: ");
		while(start != null) {
			System.out.println(start.data + " Link: " + start.previous);
			start = start.next;
		}
	}
	
}
