
public class DoublyLL {
	
	//Represents a node of the doubly linked list
	class Node{
		int data;
		Node previous;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	//Represent the head and tail of the doubly link list
	Node head,tail = null;
	
	//addNode() will add a node to the list
	public void addNode(int data)
	{
		Node newnode = new Node(data);
		if(head == null)
		{
			head = tail = newnode;
			
			head.previous =null;
			tail.next=null;
			
		}
		else {
			tail.next = newnode;
			newnode.previous =tail;
			tail=newnode;
			tail.next = null;
			
		}
	}
	public void display()
	{
		Node current = head;
		
		if(head == null) {
			System.out.println("List is empty");
		return ;
		}		System.out.println("List elements:");
		
		while(current != null)
		{
			System.out.println(current.data+" ");
			
			current = current.next;
		}
	}
	
	public static void main(String[] args)
	{
		DoublyLL list = new DoublyLL();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		
		list.display();
	}
	

}
