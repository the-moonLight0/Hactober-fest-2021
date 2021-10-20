#Searching an item in the linked list
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

ll=LinkedList()

ll.add(3)
ll.add(4)
ll.add(5)
ll.add(6)
ll.display()
print("4 is at index: ",ll.search(4))
print("6 is at index: ",ll.search(6))


