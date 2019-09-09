package com.example.demo.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.list.DoubleLinkedList;
import com.example.demo.list.LinkedList;
import com.example.demo.list.LinkedQueue;
import com.example.demo.list.LinkedStack;

public class DemoMain {

	public static void main(String[] args) {
		
		String name = "SANDEEP KUMAR";
		char [] chrArr = name.toCharArray();
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0;  i< name.length(); i++) {			
			if(map.get(Character.toString(chrArr[i])) == null) {
				if(chrArr[i] == ' ')  continue;
				map.put(Character.toString(chrArr[i]), 1);
			} else {
				map.put(Character.toString(chrArr[i]), map.get(Character.toString(chrArr[i])) + 1);
			}
		}
		
		Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,  
						LinkedHashMap::new));
		
		System.out.println(sortedMap);
		
		Parent parent = new Child();
		
		if(parent instanceof Child) {
			Child ch = (Child) parent;
			ch.print();
		}
		
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("A");
		int i	= Collections.frequency(list, "A");
		System.out.println(i);
		
		Map<Employee, String> emap = new HashMap<>();
		Employee e1 =  new Employee();
		e1.setName("Hello");
		e1.setDate(new Date());
		emap.put(e1, "A");
		
		Employee e2 =  new Employee();
		e2.setName("Hello");
		e2.setDate(new Date());
		emap.put(e2, "B");
		
		System.out.println(emap.get(e1));
		
		LinkedList li = new LinkedList();
		
		li = li.insertAtHead(li, 4);
		li = li.insertAtHead(li, 5);
		li = li.insertAtHead(li, 3);
		li = li.insertAtHead(li, 7);
		li = li.insertAtHead(li, 8);
		li = li.insertAtHead(li, 9);
		
		li.printList(li);
		
		//li.remove(li, 9);
		//li.remove(li, 5);
		//li.remove(li, 6);
		//li.remove(li, 4);
		li.sortedList(li);
		
		li.printList(li);
		
		/*DoubleLinkedList dli = new DoubleLinkedList();
		dli = dli.insertAtHead(dli, 4);
		dli = dli.insertAtHead(dli, 5);
		dli = dli.insertAtHead(dli, 6);
		dli = dli.insertAtHead(dli, 7);
		dli = dli.insertAtHead(dli, 8);
		dli = dli.insertAtHead(dli, 9);
		
		//dli.printListLast(dli);
		
		//dli.printListNext(dli);
		
		DoubleLinkedList lid = new DoubleLinkedList();
		lid = lid.insertAtHead(lid, 4);
		lid = lid.insertAtHead(lid, 5);
		lid = lid.insertAtHead(lid, 6);
		lid = lid.insertAtHead(lid, 7);
		lid = lid.insertAtHead(lid, 8);
		
		lid.printListNext(lid);
		
		lid = lid.insertAtIndex(lid, 4);
		
		lid.printListLast(lid);
		
		lid.remove(lid, 7);
		
		System.out.println("Remove List: ");
		lid.printListNext(lid);
		*/
		
		LinkedQueue queue = new LinkedQueue();
		queue = queue.enqueue(queue, 5);
		queue = queue.enqueue(queue, 6);
		queue = queue.enqueue(queue, 7);
		queue = queue.enqueue(queue, 8);
		queue = queue.enqueue(queue, 9);
		queue = queue.enqueue(queue, 10);
		queue = queue.enqueue(queue, 11);
		
		queue.dequeue(queue);
		queue.dequeue(queue);
		queue.dequeue(queue);
		
		queue.printQueue();
		
		LinkedStack stack = new LinkedStack();
		stack = stack.push(stack, 5);
		stack = stack.push(stack, 6);
		stack = stack.push(stack, 7);
		stack = stack.push(stack, 8);
		stack = stack.push(stack, 9);
		stack = stack.push(stack, 10);
		stack = stack.push(stack, 11);
		
		stack.pop(stack);
		
		stack.printStack();
	}
}
