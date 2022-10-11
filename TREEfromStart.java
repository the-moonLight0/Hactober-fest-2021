public class TREEfromStart {
	public static class Node {
		public int data;
		public Node left;
		public Node right;
		public  Node() {
			
		}
		public Node(int val) {
					data = val;
		}
		
	}
	public static Node addnode(Node root,int val) {
		//for root
		if(root==null) {
			Node nn = new Node(val);
			return nn;
		}
		//for left
		if(val<=root.data) {
			root.left = addnode(root.left,val);
		}
		//for right
		else {
			root.right = addnode(root.right,val);
		}
		return root;
	}

	public static void display(Node root) {
		if(root!=null) {
			System.out.println(root.data);
			display(root.left);
			display(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Node root=addnode(null,7);
		addnode(root,5);
		addnode(root,4);
		addnode(root,2);
		addnode(root,9);
		display(root);
	}

}
