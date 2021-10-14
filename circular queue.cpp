#include <iostream>
#define SIZE 5  //fixed size i.e 5

using namespace std;

class Queue {
   private:
  int items[SIZE], front, rear;

   public:
  Queue() {
    front = -1;
    rear = -1;
  }

  bool isFull() {
    if (front == 0 && rear == SIZE - 1) {
      return true;
    }
    if (front == rear + 1) {
      return true;
    }
    return false;
  }

  bool isEmpty() {
    if (front == -1)
      return true;
    else
      return false;
  }

  void enQueue(int element) {
    if (isFull()) {
      cout << "Queue is full";
    } else {
      if (front == -1) front = 0;
      rear = (rear + 1) % SIZE;
      items[rear] = element;
      cout << endl<< "Inserted " << element << endl;
    }
  }

  int deQueue() {
    int element;
    if (isEmpty()) {
      cout << "Queue is empty" << endl;
      return -1;
    } else {
      element = items[front];
      if (front == rear) {
        front = -1;
        rear = -1;
      }
      else {
        front = (front + 1) % SIZE;
      }
      return element;
    }
  }

  void display() {
    int i;
    if (isEmpty()) {
      cout << endl
         << "Empty Queue" << endl;
    } else {
        cout<<"elements are "<<endl;
      for (i = front; i != rear; i = (i + 1) % SIZE)
        cout << items[i]<<" ";
      cout << items[i];
    }
  }
};

int main() {
  Queue q;

  int op=0;
    cout<<"Circular queue using array choose options:"<<endl;
    while(op!=-1){
        cout<<endl;
        cout<<"1 for enqueue"<<endl;
        cout<<"2 for dequeue"<<endl;
        cout<<"3 for displaying"<<endl;
        cout<<"-1 to exit"<<endl;
        cin>>op;
        cout<<endl;
        if(op==1){
            int val;
            cout<<"Enter the value to be inserted"<<endl; cin>>val;
            q.enQueue(val);
            cout<<endl;
        }

        if(op==2){
            cout<<"Removed element is "<<q.deQueue()<<endl<<endl;
        }

        if(op==3){
            q.display();
            cout<<endl;
        }
    }
}


