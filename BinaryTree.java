import java.util.*;


public class BinaryTree {

	public static class Node{
		int value;
		Node left,right;
		
		Node(int value){
			this.value = value;
			left=null;
			right=null;
		}
	}

	public void insert(Node node,int value)
	{
		if(value < node.value) {
			if(node.left != null) {
				insert(node.left,value);
			}
			else
			{
				System.out.println("Inserted "+value+" to the left of "+node.value);
				node.left = new Node(value);
			}
			}
		else if(value > node.value) {
			if(node.right != null) {
				insert(node.right,value);
			}
			else {
				System.out.println("Inserted "+value+" to right of "+node.value);
				node.right = new Node(value);
				
			}
		}
			
		
	}
	
	public void traverseInorder(Node node)
	{
		if(node != null) {
			traverseInorder(node.left);
			System.out.print("  "+ node.value);
			traverseInorder(node.right);
		}
	}
	
	public static boolean IsPresent(Node root , int key)
	{
		if(root==null)
			return false;
		Queue<Node> q = new java.util.LinkedList<Node>(); 
		q.offer(root);
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(tmp.value == key)
				return true;
			
			if(tmp != null) {
				
				if(tmp.left != null)
					q.offer(tmp.left);
				if(tmp.right != null)
					q.offer(tmp.right);
				
				
			}
		}
		return false;
	}
	public static int nodeCount(Node root) {
		
		int leftnodecount = root.left == null?0 :nodeCount(root.left);
		int rightnodecount = root.right==null?0:nodeCount(root.right);
		
		return 1+leftnodecount+rightnodecount ;
	}
	public static int size(Node root) {
		int count =0;
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			count++;
			
			if(temp.left != null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
		}
		return count;
	}
	public static void delete(Node root) {
		root=null;
	}
	public static int depth(Node root) {
		if(root==null)
			return 0  ;
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		
		return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
		
		
	}
	public static int depthByIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node prev = null;
		int maxDepth = 0;
		s.push(root);
		while(!s.isEmpty()) {
			Node curr = s.peek();
			
			if(prev == null || prev.left ==curr || prev.right==curr)
			{
				if(curr.left!=null)
					s.push(curr.left);
				else if(curr.right != null)
					s.push(curr.right);
			}
			else if(curr.left == prev)
			{
				 if(curr.right != null)
						s.push(curr.right);
			}
			else
				s.pop();
			
			prev = curr;
			if(s.size() > maxDepth)
				maxDepth = s.size();
		}
		return maxDepth;
	}
	public static int minDepth(Node root)
	{
		if(root==null)
			return 0;
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			if(temp!=null)
			{
				if(temp.left == null && temp.right == null)
				{
					return count;
				}
				
				if(temp.left!=null)
					q.offer(temp.left);
				
				if(temp.right!=null)
					q.offer(temp.right);
				
			}
			else {
				if(!q.isEmpty())
				{
				count++;
				q.offer(null);
				}
			}
		}
		return count;
	}
	public static int DepthWithoutRecursion(Node root)
	{
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		
		int count=1;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(curr !=null) {
				if(curr.left == null && curr.right==null) {
					return count;
				}
				if(curr.left!=null)
					q.offer(curr.left);
				
				if(curr.right!=null)
					q.offer(curr.right);
			}
			else {
				if(!q.isEmpty()) {
				count++;
				q.offer(null);
				}
			}
		}
		return count;
	}
	public static Node  deepestNode(Node root)
	{
		Node temp =null;
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			temp = q.poll();
			
			if(temp.left !=null)
				q.offer(temp.left);
			
			if(temp.right !=null)
				q.offer(temp.right);
		}
		return temp;
	}
	public static int Leaves(Node root)
	{
		int count =0;
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left == null && temp.right==null)
				count++;
			if(temp.left != null)
				q.offer(temp.left);
			if(temp.right!= null)
				q.offer(temp.right);
		}
		return count;
	}
	
	public static int FullNodes(Node root)
	{
		int count =0;
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left != null && temp.right!=null)
				count++;
			if(temp.left != null)
				q.offer(temp.left);
			if(temp.right!= null)
				q.offer(temp.right);
		}
		return count;
	}
	
	public static int halfNodes(Node root)
	{
		int count =0;
		Queue<Node> q = new java.util.LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if((temp.left == null && temp.right!=null) || (temp.left != null && temp.right==null))
				count++;
			if(temp.left != null)
				q.offer(temp.left);
			if(temp.right!= null)
				q.offer(temp.right);
		}
		return count;
	}

	public static boolean areIdentical(Node root,Node root1)
	{
		if(root == null && root1==null)
			return true;
		if(root ==null || root1==null)
			return false;
		
		return(areIdentical(root.left,root1.right) && areIdentical(root.right,root1.left));
	}
	public static int Diameter(Node root)
	{
		if(root==null)
			return 0;
		int left,right;
		int diameter =0;
		 left = Diameter(root.left);
		 right = Diameter(root.right);
		 if(left+right > diameter)
			 diameter = left+right;
		 
		 return Math.max(left, right)+1;
		
		 
	}
	
	public static int getDiameter(Node root)
	{
		if(root==null)
			return 0;
		
		int len1 = depth(root.left) + depth(root.right)+3;
		
		int len2 = Math.max(getDiameter(root.left), getDiameter(root.right));
		
		return Math.max(len1,len2);
		 
	}
	public static int maxWidth(Node root)
	{
		int max =0; 
		int h = depth(root);
		for(int i=1;i<=h;i++)
		{
			int temp= Width(root,i);
			if(temp>max)max=temp;
		}
	return max;
	}
	public static int Width(Node root,int level)
	{
		if(root==null)
			return 0;
		else {
			if(level==1)
				return 1;
			else
				return Width(root.left,level-1)+Width(root.right,level-1);
		}
	}
	public static int maxSumAtLevel(Node root)
	{
		int max =0; 
		int h = depth(root);
		for(int i=1;i<=h;i++)
		{
			int temp= getMaxSum(root,i);
			if(temp>max)max=temp;
		}
	return max;
	}
	public static int getMaxSum(Node root,int level)
	{
		if(root==null)
			return 0;
		else {
			if(level==1)
				return root.value;
			else
				return getMaxSum(root.left,level-1)+getMaxSum(root.right,level-1);
		}
	}
	public static void pathLength(Node root)
	{
		int[] path = new int[256];
		getPath(root,path,0);
		
	}
	public static void getPath(Node root,int[] path,int pathlen)
	{
		if(root==null)
			return;
		
		path[pathlen] = root.value;
		pathlen++;
		
		if(root.left == null && root.right ==null) {
			printArray(path,pathlen);
		}
		else {
			getPath(root.left,path,pathlen);
			getPath(root.right,path,pathlen);
		}
	}
	public static void printArray(int[] path,int pathlen)
	{
		for(int i=0;i<pathlen;i++)
		{
			System.out.print(path[i]+" ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		Node root = new Node(5);
		Node root1 = new Node(6);
		System.out.println("Binary Tree Example");
		System.out.println("Bulding Tree with root value "+ root.value);
		tree.insert(root, 2);
		tree.insert(root, 4);
		tree.insert(root, 8);
		tree.insert(root, 6);
		tree.insert(root, 7);
		tree.insert(root, 3);
		tree.insert(root, 9);
		
		tree2.insert(root1, 3);
		tree2.insert(root1, 5);
		tree2.insert(root1, 9);
		tree2.insert(root1, 7);
		tree2.insert(root1, 8);
		tree2.insert(root1, 4);
		tree2.insert(root1, 10);
		
		System.out.print("Traversing tree in order");
		delete(root);
		tree.traverseInorder(root);
		System.out.println("");
		
		System.out.println("Check if element is present or not,Enter Element :");
		int key  =24;
		System.out.println(IsPresent(root,key));
		System.out.println("Size of the tree with using recursion : "+nodeCount(root));
		System.out.println("Size of the tree without using recursion : "+size(root));
		System.out.println("Depth of the tree with using recursion : "+depth(root));
		System.out.println("Depth of the tree with using Iteration : "+depthByIteration(root));
		System.out.println("Depth of the tree without using recursion : "+DepthWithoutRecursion(root));
		System.out.println("Minimun depth of the tree without using recursion : "+minDepth(root));
		Node ans = deepestNode(root);
		System.out.println("Deepest Node of the tree is: "+ans.value);
		System.out.println("Number of leaf nodes in the tree is : "+Leaves(root));
		System.out.println("Number of Full nodes in the tree is : "+FullNodes(root));
		System.out.println("Number of Half nodes in the tree is : "+halfNodes(root));
		System.out.println("Are two trees identical ? : "+areIdentical(root,root1));
		System.out.println("Diameter of tree is : "+Diameter(root));
		System.out.println("Diameter of tree by alternative method is : "+getDiameter(root));
		System.out.println("Maximum Width of tree is : "+maxWidth(root));
		System.out.println("Maximum Sum  at any level of tree is : "+maxSumAtLevel(root));
		System.out.println("Pathlengths of tree are : ");
		pathLength(root);
	}
}
