import java.util.Scanner;
 
 /* Class AVLNode */
 class AVLNode
 {    
     AVLNode left, right;
     int data;
     int height;
 
     /* Constructor */
     public AVLNode()
     {
         left = null;
         right = null;
         data = 0;
         height = 0;
     }
     /* Constructor */
     public AVLNode(int n)
     {
         left = null;
         right = null;
         data = n;
         height = 0;
     }     
 }
 
 /* Class AVLTree */
 class AVLTree
 {
     private AVLNode root;     
 
     /* Constructor */
     public AVLTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }
     /* Function to insert data */
     public void insert(int data)
     {
         root = insert(data, root);
     }
     /* Function to get height of node */
     private int height(AVLNode t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to insert data recursively */
     private AVLNode insert(int x, AVLNode t)
     {
         if (t == null)
             t = new AVLNode(x);
         else if (x < t.data)
         {
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x < t.left.data )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( x > t.data )
         {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x > t.right.data)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */     
     private AVLNode rotateWithLeftChild(AVLNode k2)
     {
         AVLNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private AVLNode rotateWithRightChild(AVLNode k1)
     {
         AVLNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private AVLNode doubleWithLeftChild(AVLNode k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private AVLNode doubleWithRightChild(AVLNode k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }    
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(AVLNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public int search(int val)
     {
         return search(root, val);
     }
     private int search(AVLNode r, int val)
     {
         int found = -1;
         while ((r != null) && found==-1)
         {
             int rval = r.data;
             if (val < rval) {
            	 if(r.left.data==val) {
            		 found = r.data;
            		 return found;
            	 }
                 r = r.left;
             }
             else if (val > rval) {
            	 if(r.right.data==val) {
            		 found = r.data;
            		 return found;
            	 }
                 r = r.right;
             }
             else
             {
                 found = -1;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
}
 
 /* Class AVL Tree Test */
 public class AVLTreeTest
 {
     public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /* Creating object of AVLTree */
        AVLTree avlt = new AVLTree(); 
        
        int a = scan.nextInt();
        /*  Perform tree operations  */
        int i = 0;
        while(i<a)    
        {
        	
            String choice = scan.next();
            
            int index1=choice.indexOf(" ");
            char number=choice.charAt(index1+1);
            int num=Integer.parseInt(number);
            if(choice.charAt(0)=='A') {
            	int add = Integer.parseInt(choice,choice.charAt(choice.length()-1));
            	avlt.insert(add);
            } else if(choice=="PARENT") {
            	int s = Integer.parseInt(choice,choice.charAt(choice.length()-1));
            	int ans = avlt.search(s);
            	System.out.print(ans);
            } else {
            	int count = avlt.countNodes();
            	System.out.print(count);
            }
            
            
//            switch (choice)
//            {
//            case 1 : 
//                System.out.println("Enter integer element to insert");
//                avlt.insert( scan.nextInt() );                     
//                break;                          
//            case 2 : 
//                System.out.println("Enter integer element to search");
//                System.out.println("Search result : "+ avlt.search( scan.nextInt() ));
//                break;                                          
//            case 3 : 
//                System.out.println("Nodes = "+ avlt.countNodes());
//                break;     
//            case 4 : 
//                System.out.println("Empty status = "+ avlt.isEmpty());
//                break;     
//            case 5 : 
//                System.out.println("\nTree Cleared");
//                avlt.makeEmpty();
//                break;         
//            default : 
//                System.out.println("Wrong Entry \n ");
//                break;   
//            }
// 
//            System.out.println("\nDo you want to continue (Type y or n) \n");
//            ch = scan.next().charAt(0); 
            i++;
        }              
    }
 }
