<---------Stack Introduction------------>
Stack is a linear data structure that follows a particular order in which the operations are performed. The order may be LIFO(Last In First Out) or FILO(First In Last Out).
Mainly the following three basic operations are performed in the stack:

• Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
• Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
• Peek or Top: Returns the top element of the stack.
• isEmpty: Returns true if the stack is empty, else false.
  
  
  
  <---------------How to understand a stack practically?---------------> 
  
  
There are many real-life examples of a stack. Consider the simple example of plates stacked over one another in a canteen. The plate which is at the top is the first one to be removed, i.e. the plate which has been placed at the bottommost position remains in the stack for the longest period of time. So, it can be simply seen to follow the LIFO/FILO order.

Time Complexities of operations on stack:

push(), pop(), isEmpty() and peek() all take O(1) time. We do not run any loop in any of these operations.
 

<------Applications of stack------->

How to understand a stack practically?
  
There are many real-life examples of a stack. Consider the simple example of plates stacked over one another in a canteen. The plate which is at the top is the first one to be removed, i.e. the plate which has been placed at the bottommost position remains in the stack for the longest period of time. So, it can be simply seen to follow the LIFO/FILO order.

Time Complexities of operations on stack:

push(), pop(), isEmpty() and peek() all take O(1) time. We do not run any loop in any of these operations.
 

<----------Implementing Stack using Arrays-------------->
  
  
  class Stack {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack
 
    boolean isEmpty()
    {
        return (top < 0);
    }
    Stack()
    {
        top = -1;
    }
 
    boolean push(int x)
    {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }
 
    int pop()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top--];
            return x;
        }
    }
 
    int peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
    
    void print(){
    for(int i = top;i>-1;i--){
      System.out.print(" "+ a[i]);
    }
  }
}
class Main {
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}
Output : 

10 pushed into stack
20 pushed into stack
30 pushed into stack
30 Popped from stack
Top element is : 20
Elements present in stack : 20 10  
  
  <------------Pros and Cons----------->
  
  
Pros: Easy to implement. Memory is saved as pointers are not involved. 
Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.
  
  
 
  <--------------Implementing Stack using Linked List:------------------->
    
    
    
    public class StackAsLinkedList {
 
    StackNode root;
 
    static class StackNode {
        int data;
        StackNode next;
 
        StackNode(int data) { this.data = data; }
    }
 
    public boolean isEmpty()
    {
        if (root == null) {
            return true;
        }
        else
            return false;
    }
 
    public void push(int data)
    {
        StackNode newNode = new StackNode(data);
 
        if (root == null) {
            root = newNode;
        }
        else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
        System.out.println(data + " pushed to stack");
    }
 
    public int pop()
    {
        int popped = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = root.data;
            root = root.next;
        }
        return popped;
    }
 
    public int peek()
    {
        if (root == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return root.data;
        }
    }
    public static void main(String[] args)
    {
 
        StackAsLinkedList sll = new StackAsLinkedList();
 
        sll.push(10);
        sll.push(20);
        sll.push(30);
 
        System.out.println(sll.pop()
                           + " popped from stack");
 
        System.out.println("Top element is " + sll.peek());
    }
}
Output:

10 pushed to stack
20 pushed to stack
30 pushed to stack
30 popped from stack
Top element is 20
Elements present in stack : 20 10 
  
  <------------Pros and Cons----------->
  
  
Pros: The linked list implementation of a stack can grow and shrink according to the needs at runtime. 
Cons: Requires extra memory due to involvement of pointers.

