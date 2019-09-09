package com.example.demo.list;

public class LinkedQueue {
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	private Node head;
	public LinkedQueue enqueue(LinkedQueue queue, int data) {
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
		return queue;
	}
	
	public LinkedQueue dequeue(LinkedQueue queue) {
		Node start = head;
		if(start ==  null) {
			System.out.println("Queue is empty");
		} else {
			start = start.next;
			head = start;
		}
		return queue;
	}
	
	public void printQueue() {
		Node start = head;
		System.out.println("Data in Queue: ");
		 while(start != null) {
			 System.out.println(start.data);
			 start = start.next;
		 }
	}
}
