

//import BinaryTree.Node;


public class BinaryTree2 {

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
	
	public static void traverseInorder(Node node)
	{
		if(node != null) {
			traverseInorder(node.left);
			System.out.print("  "+ node.value);
			traverseInorder(node.right);
		}
	}
	
	public static int depth(Node root) {
		if(root==null)
			return 0  ;
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		
		return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
		
		
	}
	public static boolean checkPathSum(Node root,int sum)
	{
		if(root==null)
			return false;
		if(root.value == sum)
			return true;
		else
			return checkPathSum(root.left,sum-root.value) || checkPathSum(root.right,sum-root.value);
	}
	
	public static int Sum(Node root)
	{
		if(root==null)
			return 0;
		
		return root.value+Sum(root.left)+Sum(root.right);
	}
	public static Node getMirror(Node root)
	{
		if(root!=null)
		{
			getMirror(root.left);
			getMirror(root.right);
			
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
	public static Node buildBinaryTree(char[] inorder,char[] preorder) {
		if(preorder.length ==0 || preorder.length != inorder.length)
			return null;
		
		return buildBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	public static Node buildBT(char[] preorder , int preStart,int preEnd,char[] inorder,int inStart,int inEnd) {
		if(preStart>preEnd || inStart>inEnd)
			return null;
		
		int data = preorder[preStart];
		Node cur = new Node(data);
		
		int offset = inStart;
		for(;offset<inEnd;offset++) {
			if(preorder[offset]==data)
				break;
		}
		
		cur.left= buildBT(preorder,preStart+1,preStart+offset-inStart,inorder,inStart,offset-1);
		cur.left =buildBT(preorder,preStart+offset+1-inStart,preEnd,inorder,offset+1,inEnd);
		return cur;
	}
	public static boolean printAncistors(Node root,Node node) {
		if(root==null)
			return false;
		if(root.left == node||root.right ==node|| printAncistors(root.left,node)|| printAncistors(root.right,node))
			{
				System.out.print(root.value+" ");
				return true;
			}
			return false;
	}
	public static void main(String[] args)
	{
		BinaryTree2 tree = new BinaryTree2();
		BinaryTree2 tree2 = new BinaryTree2();
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
		
		tree.traverseInorder(root);
		System.out.println("");
		
	
		System.out.println("Depth of the tree with using Iteration : "+depth(root));
		//Give an algorithm for checking the existence of path with given sum. That
		//means, given a sum, check whether there exists a path from root to any of the nodes.
		System.out.println("Existence of path with given sum? : "+checkPathSum(root,14));
		System.out.println("Sum of nodes in a Tree is : "+Sum(root));
		//System.out.println("Mirror of given tree is : ");
		//traverseInorder(getMirror(root));
		System.out.println("");
		
		//char[] preorder = {'A','B','D','E','C','F'};
		//char[] inorder = {'D','B','E','A','F','C'};
		
		//System.out.println("Tree made by Inderorder and preorder sequence is : ");
		//traverseInorder(buildBinaryTree(inorder,preorder));
		
		System.out.println( "Ancestor of a given node are  : ");
		printAncistors(root,root.left.right);
		
	}
}
