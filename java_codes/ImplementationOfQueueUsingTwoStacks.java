//Implementing Queue using two Stacks
import java.util.Stack;

public class queue_using_2stacks {
    public static void main(String[] args) {
        QueueStacks obj =new QueueStacks();
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        System.out.println(obj.dequeue());
        obj.enQueue(4);
        obj.enQueue(5);
        obj.enQueue(6);
        System.out.println(obj.peek());
        System.out.println(obj.peek());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());

    }
}

class QueueStacks{
    Stack <Integer> s1;
    Stack <Integer> s2;
    int size;

    public QueueStacks(){
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public int size(){
       size=s1.size()+s2.size();
       return size;
    }

    public void enQueue(int value){
        s1.push(value);
    }

    public void exchangeStacks(){
        int element=s1.pop();
        s2.push(element);
    }

    public int dequeue(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                exchangeStacks();
            }
        }
        return s2.pop();

    }

    public int peek(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                exchangeStacks();
            }
        }
        return s2.peek();
    }

}
