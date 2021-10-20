#Deleting a node from the linked list
class Node:
    def __init__(self,data):
        self.data=data
        self.next=None

class LinkedList:

    def __init__(self):
        self.head=None

    def add(self,data):
        new = Node(data)
        if self.head is None:
            self.head=new
            return
        ptr=self.head
        while ptr.next is not None:

            ptr=ptr.next
        ptr.next=new

    def display(self):
        ptr=self.head
        while ptr is not None:
            print(ptr.data,end="->")
            ptr=ptr.next
        print("Null")

    def search(self,data):
        ptr=self.head
        count=0
        while ptr is not None:
            if ptr.data==data:
                return count

            ptr=ptr.next
            count+=1
    def delete(self,data):
        ptr = self.head

        if ptr and ptr.data == data:
            self.head=ptr.next
            ptr=None
            return

        prev = None
        while ptr and ptr.data != data:
            prev = ptr
            ptr = ptr.next
        if ptr is None:
            return
        prev.next = ptr.next
        ptr = None



ll=LinkedList()

ll.add(3)
ll.add(4)
ll.add(5)
ll.add(6)
ll.add(1)
ll.add(2)
ll.display()

ll.delete(4)
ll.display()