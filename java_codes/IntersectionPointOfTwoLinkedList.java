public class IntersectionPointOfTwoLinkedList {
    static class Node {
        int data;
        Node next;
    }

    static Node intersectPoint(Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;
        if (ptr1 == null || ptr2 == null) {
            return null;
        }
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if (ptr1 == ptr2) {
                return ptr1;
            }
            if (ptr1 == null) {
                ptr1 = head2;
            }
            if (ptr2 == null) {
                ptr2 = head1;
            }
        }
        return ptr1;
    }

    static void print(Node node) {
        if (node == null)
            System.out.print("null");
        while (node.next != null) {
            System.out.print(node.data + ".");
            node = node.next;
        }
        System.out.print(node.data);
    }

    public static void main(String[] args) {

        Node newNode;
        Node head1 = new Node();
        head1.data = 10;
        Node head2 = new Node();
        head2.data = 3;
        newNode = new Node();
        newNode.data = 6;
        head2.next = newNode;
        newNode = new Node();
        newNode.data = 9;
        head2.next.next = newNode;
        newNode = new Node();
        newNode.data = 15;
        head1.next = newNode;
        head2.next.next.next = newNode;
        newNode = new Node();
        newNode.data = 30;
        head1.next.next = newNode;
        head1.next.next.next = null;
        Node intersect_node = null;

        intersect_node = intersectPoint(head1, head2);
        System.out.print("INTERSEPOINT LIST :");
        print(intersect_node);
    }
}

