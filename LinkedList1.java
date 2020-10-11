
public class LinkedList1 {
	Node head;
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
		
	}
	public static LinkedList1 insert(LinkedList1 list , int data)
	{
		Node new_node = new Node(data);
		new_node.next = null;
		
		if (list.head == null)
			list.head = new_node;
		else {
			Node last = list.head;
			while(last.next!=null) {
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
	
	public static void printList(Node node)
	{
		Node temp = node;
		System.out.print("LinkedList: "); 
		while(temp != null) {
			
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
		System.out.println(" ");
	}
	public static LinkedList1 insertAtHead(LinkedList1 list,int data)
	{
		Node new_node = new Node(data);
		if(list==null) {
			list.head=new_node;
			return list;
		}
		new_node.next = list.head;
		list.head = new_node;
		return list;
		
	}
	public static LinkedList1 insertAtPos(LinkedList1 list , int pos , int data) {
		Node new_node = new Node(data);
		Node curr = list.head;
		int index =0;
		
		while(index < pos-1)
		{
			curr = curr.next;
			index++;
		}
		
		new_node.next = curr.next;
		curr.next = new_node;
		
		return list;
	}
	public static LinkedList1 deleteAtPos(LinkedList1 list, int pos) {
		int  index =0;
		if(list.head ==null)
			return list;
		if(pos==0) {
			list.head = list.head.next;
			return list;
		}
		Node curr = list.head;
		while(index<pos-1)
		{
			curr = curr.next;
			index++;
		}
		curr.next = curr.next.next;
		return list;
	}
	public static Node reverse(Node node) {
		Node next =null;
		Node current = node;
		Node prev = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	public static Node reverseRecursive(Node head) {
		if(head==null || head.next==null)
			return head;
		
		Node rest = reverseRecursive(head.next);
		head.next.next = head;
		
		head.next = null;
		
		return rest;
	}
	public static int nthFromEnd(LinkedList1 list,int n)
	{
		Node temp = list.head;
		Node nth = null;
		
		for(int i=0;i<n;i++)
		{
			if(temp!=null)
				temp=temp.next;
		}
		while(temp!=null)
		{
			if(nth==null)
				nth=list.head;
			else
				nth=nth.next;
			
			temp = temp.next;
		}
		return nth.data;
	}
	public static Node nthFromEndRec(Node head,int n)
	{
		int count=0;
		if(head!=null) {
			
			nthFromEndRec(head.next, n);
			count++;
			
			if(count==n)
				return head;
			
		}
	
		return null;
	}

	public static boolean loopExist(Node head)
	{
		Node slowptr=head;
		Node fastptr=head;
		
		while(fastptr==null && fastptr.next==null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			
			if(slowptr==fastptr)
				return true;
		}
		return false;
		
		/* 
		 * if(loop_exits){
		 * slowPtr = head;
		 * while(slowptr!=fastptr)
		 * {
		 * slowptr = slowptr.next;
		 * fastptr = fastptr.next;
		 * }
		 * return fastptr;
		 * }else
		 * return null;*/
	}
	public static Node getMergePoint(Node list1,Node list2)
	{
		Node head1 = list1;
		Node head2 = list2;
		
		int L1=0,L2=0;
		while(head1 !=null)
		{
			L1++;
			head1 = head1.next;
		}
		while(head2!=null) {
			L2++;
			head2 = head2.next;
		}
		int diff=0;
		
		if(L1 < L2) {
			head1 = list2;
			head2 = list1;
			diff = L2-L1;
		}
		else {
			head1 = list1;
			head2 = list2;
			diff = L1-L2;
		}
		
		for(int i=0;i<diff;i++)
			head1= head1.next;
		
		while(head1 !=null && head2!=null) {
			
			if(head1 == head2)
				return head1;
			
			head1 = head1.next;
			head2 = head2.next;
			
		}
		return null;
	}
	public static int findMiddle(Node head)
	{
		Node ptr1=head,ptr2=head;
		int i=0;
				
				while(ptr1.next !=null)
				{
					if(i==0) {
						ptr1 = ptr1.next;
						i=1;
					}
					else if(i==1) {
						ptr1 = ptr1.next;
						ptr2 = ptr2.next;
						i=0;
					}
				}
				return ptr2.data;
		
	}
public static void fromEnd(Node head)
{
	if(head==null)
		return ;
	fromEnd(head.next);
	System.out.print(" "+head.data);
	
}
public static boolean checkEvenLength(Node head)
{
	while(head !=null && head.next != null)
	{
		head = head.next.next;
		
		if(head==null)
			return true;
		
	}
	return false;
}

public static Node mergeLists(Node head1,Node head2)
{
	if(head1==null)
		return head2;
	if(head2==null)
		return head1;
	
	Node head = new Node(0);
	
	
	
		if(head1.data < head2.data) {
			head = head1;
			head.next = mergeLists(head1.next,head2);
		}
		else {
			head = head2;
			head.next = mergeLists(head2.next , head1);
		}
	return head;
}
public static Node mergeTwoLists(Node head1,Node head2)
{
	Node head = new Node(0);
	Node curr = head;
	
	while(head1 != null && head2 != null)
	{
		if(head1.data <= head2.data) {
			curr.next = head1;
			head1 = head1.next;
		}else {
			curr.next = head2;
			head2 = head2.next;
		}
	}
	if(head1 != null)
		curr.next = head1;
	else if(head2!=null)
		curr.next = head2;
	return head.next;
}

public static Node reverseInPairs(Node head)
{
	Node temp;
	if(head==null || head.next==null)
		return head;
	else
	{
		temp = head.next;
		head.next = temp.next;
		temp.next = head;
		head = temp;
		
		head.next.next = reverseInPairs(head.next.next);
		return head;
	}
	
}
public static Node reversePairsIterative(Node head)
{
	Node temp1=null;
	Node temp2 = null;
	
	while(head != null || head.next !=null) {
		
		if(temp1!=null)
				temp1.next.next = head.next;
		
		temp1 = head.next;
		head.next = head.next.next;
		temp1.next = head;
		if(temp2==null)
			temp2 = temp1;
		
		head = head.next;
		
	}
	return temp2;
}
public static void main(String[] args) {
	
	LinkedList1 list = new LinkedList1();
	
	
	list = insert(list,5);
	list = insert(list,10);
	list = insert(list,15);
	list = insert(list,20);
	list = insert(list,25);
	list = insert(list,30);
	list = insert(list,35);
	//list = insert(list,40);
	
	printList(list.head);
	
	System.out.println("Inserting the element in the head : ");
	list = insertAtHead(list , 0);
	
	System.out.println("Inserting the element at given loaction : ");
	list = insertAtPos(list,5,22);
	printList(list.head);
	
	System.out.println("deleting the element at given loaction : ");
	list = deleteAtPos(list,5);
	printList(list.head);
	
//	System.out.println("Reversing the LinkedList by Iterative method : ");
	//printList(reverse(list.head));
	
	//System.out.println("Reversing the LinkedList by Recursive method : ");
	//printList(reverseRecursive(list.head));
	
	System.out.print("Find the nth node from end of the linkedlist : ");
	System.out.println(nthFromEnd(list,3));
	
	//System.out.println("Find the nth node from end of the linkedlist(using recursive calls) : ");
	//System.out.println(nthFromEndRec(list.head,3).data);
	
	System.out.println("Does LinkedList contains loop : "+loopExist(list.head));
	
	System.out.println("Middle element of the LinkedList is:"+findMiddle(list.head));
	
	System.out.print("Displaying LinkedList from the end: ");
	fromEnd(list.head);
	System.out.println(" ");
	
	System.out.println("Is a Linked List is of even length: "+checkEvenLength(list.head));
	
	System.out.println("Reversing LinkedList in reverse order: ");
	printList(reverseInPairs(list.head));
	
	
}
}
