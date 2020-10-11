/* 
 * Akshay Mainkar
  
 */


import java.util.Scanner;

public class LinkedList
{
	Node head;
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next =null;
		}
	}
	public static Node reverseList(Node head)
	{
		if(head == null)
			return head;
		Node currNode = head;
		Node prev =null;
		
		while(currNode != null)
		{
			Node next = currNode.next;
			currNode.next = prev;
			prev = currNode;
			currNode = next;
		}
		head =prev;
		return head;
	}
	public static LinkedList insertAtPosition(LinkedList list,int data,int position)
	{
		Node new_node = new Node(data);
		Node currNode = list.head;
		 int index =0;
		 
		 while(index < position-1)
		 {
			 currNode = currNode.next;
			 index++;
		 }
		 new_node.next = currNode.next;
		 currNode.next = new_node;
		 
		 return list;
		
	}
	public static LinkedList delete(LinkedList list , int del)
	{
		if(list.head == null)
			return list;
		if(del == 0)
		{
			list.head =list.head.next;
			return list;
			}
			
			int index =0;
			Node currNode =list.head;
			while(index < del-1)
			{
				currNode = currNode.next;
				index++;
			}
			currNode.next  = currNode.next.next;
			return list;
		
	}
	public static LinkedList insertAtHead(LinkedList list,int data)
	{
		Node new_node = new Node (data);
		if (list == null)
		{
		list.head = new_node ;
		return list;
		}
		new_node.next = list.head;
		list.head = new_node;
		
		
		return list;
		
	}
	
	public static LinkedList insert(LinkedList list,int data)
	{
		Node new_node = new Node(data);
		new_node.next = null;
		
		if(list.head == null)
		{
			list.head = new_node;
		}
		else
		{
			Node last = list.head;
			
			while(last.next != null)
			{
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
		
	}
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;
		System.out.print("LinkedList :");
		
		while(currNode != null)
			{
			System.out.print(currNode.data +" ");
			
			currNode = currNode.next;
			}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		int a = sc.nextInt();
		list = insert(list,a);
		}
	
		System.out.println("Element you want to enter in the head of the list is :");
		int b =  sc.nextInt();
		list = insertAtHead(list,b);
		
		System.out.println("Insert the position you want to add data :");
		int position = sc.nextInt();
		System.out.println("Data :");
		int c = sc.nextInt();
		list = insertAtPosition(list,c,position);
		System.out.println("Insert the position you want to delete the data :");
		int del = sc.nextInt();
		list = delete(list,del);
		 
		
		
		printList(list);
		

		
		System.out.println("After Reversing the LinkedList :" );
	list.head = 	reverseList(list.head);
		printList(list);
		
		
		sc.close();
		
	}
	
}