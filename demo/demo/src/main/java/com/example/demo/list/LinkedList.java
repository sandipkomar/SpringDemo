package com.example.demo.list;

public class LinkedList {
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node head;
	
	public LinkedList insert(LinkedList list, int data) {
		
		Node new_node = new Node(data);
		
		if(head == null) {
			head = new_node;
		} else {
			Node start = head;
			while(start.next != null) {		
				start = start.next;
			}
			start.next = new_node;
		}		
		return list;
	}
	
	public LinkedList remove(LinkedList list, int data) {
		if(head == null) {
			System.out.println("List is Empty");
		} else {
			
			Node start = head;
			Node temp = head;			
			if(start.data ==  data || start.next == null) {
				start = start.next;
				head = start;
			}
			
			while(start.next != null && start.data != data) {
				temp = start;
				start = start.next;
			}
			
			if(start.data ==  data && start.next !=  null) {
				temp.next = start.next;
			}
			
			if(start.data ==  data && start.next == null) {
				temp.next = null;
			}
		}
		
		return list;
	}
	
	public LinkedList insertAtHead(LinkedList list, int data) {	
		Node new_node = new Node(data);		
		if(head == null) {
			head = new_node;
		} else {
			new_node.next = head;
			head = new_node;
		}		
		return list;
	}
	
	public LinkedList insertOnIndex(LinkedList list, int data) {	
		Node new_node = new Node(data + 2);		
		if(head == null) {
			head = new_node;
		} else {
			Node start = head;
			while(start.next != null && start.data != data) {
				start = start.next;
			}
			
			if(start.data == data && start.next != null) {
				new_node.next = start.next;
				start.next = new_node;
			}
			
			if(start.data ==  data && start.next == null) {
				System.out.println("Data: " + new_node.data + "Link: " + new_node);
				start.next = new_node;		
			}						
			
		}		
		return list;
	}

	public LinkedList sortedList(LinkedList list) {		
		Node temp = head;		
		while(temp.next != null) {
			Node start = temp.next;
			while(start != null) {
				if(temp.data < start.data) {
					int tmp = temp.data;
					temp.data = start.data;
					start.data = tmp;
				}
				start = start.next;
			}
		temp = temp.next;
		}	
		return list;
	}
	
	public void printList(LinkedList list) {
		Node start = list.head;
		System.out.println("Data in List: ");
		int sum = 0;
		while(start != null) {
			System.out.println(start.data + " Link: " + start.next);
			sum =  sum + start.data;
			start = start.next;
		}
		
		System.out.println("Sum of all nodes: " + sum);
	}
}
