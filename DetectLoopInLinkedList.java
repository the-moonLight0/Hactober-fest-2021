class DetectLoopInLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    static public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Function to detect first node of loop
    // in a linked list that may contain loop
    static boolean detectLoop(Node h) {
        if (head == null)
            return false;
        else {
            while (head != null) {
                if (head.data == -1) {
                    return true;
                } else {
                    head.data = -1;
                    head = head.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DetectLoopInLinkedList llist = new DetectLoopInLinkedList();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        llist.head.next.next.next.next.next = llist.head.next.next;
        if (detectLoop(llist.head))
            System.out.println("1");
        else
            System.out.println("0");
    }
}
