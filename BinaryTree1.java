import java.util.*;

class BinaryTree1{
	static class Node{
		int value ;
		Node left , right=null;
		
		Node(int value){
			this.value = value;
			left=null;
			right=null;
		}
	}
	public static void insert(Node root,int value) {
		if(value<root.value) {
			if(root.left != null) {
				insert(root.left,value);
			}else
			{
				root.left = new Node(value);
			}
		}
		
		else if(value>root.value) {
		if(root.right != null)	{
				insert(root.right,value);
			}
		else {
			root.right = new Node(value);
		}
		}
		
	}
	
	public static void Inorder(Node root)
	{
		if(root!= null) {
			Inorder(root.left);
			System.out.println(root.value);
			Inorder(root.right);
		}
	}
	public static int getMax(Node root) {
		int maxval = Integer.MIN_VALUE;
		if(root!= null) {
			
			
			int leftmaxval = getMax(root.left);
			int rightmaxval = getMax(root.right);
			
			if(leftmaxval > rightmaxval)
				maxval = leftmaxval;
			else
				maxval = rightmaxval;
			
			if(root.value > maxval)
				maxval = root.value;
			
		}
		return maxval;
	}
	public static boolean IsPresent(Node root,int key)
	{
		if(root == null)
			return false;
		if(root.value == key)
			return true;
		
		return IsPresent(root.left,key) || IsPresent(root.right,key);
	}
	public static void reverseTraversal(Node root) {

		Queue<Node> q = new java.util.LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
			
			s.push(temp);
			
		}
		System.out.println("Reverse order traversal : ");
		while(!s.isEmpty()) {
			
			Node mp = s.pop();
			System.out.print(mp.value+" ");
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTree1 bt = new BinaryTree1();
		int n = sc.nextInt();
		Node root = new Node(n);
		
		//System.out.println("Enter the number child nodes:");
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
		int 	value = sc.nextInt();
		bt.insert(root,value);
		}
		
	bt.Inorder(root);
		
		System.out.println("Maximum Element is:");
		int ans = bt.getMax(root);
		System.out.println(ans);
		
		//System.out.println("Check if element is present or not,Enter Element :");
		//int key  = sc.nextInt();
		//System.out.println(bt.IsPresent(root,key));
		reverseTraversal(root);
		sc.close();
	}	
}