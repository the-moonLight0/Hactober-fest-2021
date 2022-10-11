
import java.util.Scanner;
import java.lang.String;
public class Queues {
	public class Node{
		int data;
		Node next;
		
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void enqueue(int data) {
		if(size==0) {
		Node s=new Node();
		s.data=data;
		s.next=null;
		head=tail=s;
		size++;
		dis();
	}
		else {
			Node s=new Node();
			s.data=data;
			s.next=null;
			tail.next=s;
			tail=s;
			size++;
			dis();
		}
	}
		public void dequeue() {
			if(size<=1) {
				System.out.println("EMPTY");
				size--;
			}
			if(size>1) {
				Node temp=head.next;
				head=temp;
				size--;
				dis();
			}
		}
		public void inc(int x,int d) {
			
			if(x<size) {
				Node temp=head;
				int first=1;
				int p=size-x;
				while(first<p) {
					temp=temp.next;
					first++;
				}
				while(temp!=null) {
					System.out.println(head.data);
					temp.data=temp.data+d;
					System.out.println(head.data);
					temp=temp.next;
				}
				dis();
			}
		}
		public void dis() {
			//System.out.println(head.data);
		}
		

	public static void main(String[] args) {
		Queues list=new Queues();
		Scanner scn=new Scanner(System.in);
		int loop=scn.nextInt();
		String k=scn.nextLine();
		for(int i=0;i<loop;i++) {
		String s=scn.nextLine();
		char c=s.charAt(0);
		if(c=='e') {
			String h=s.substring(8);
			int n=Integer.parseInt(h);
			list.enqueue(n);
		}
		else if(c=='d') {
			list.dequeue();
		}
		else if(c=='i'){
			String h=s.substring(4);
			int f=h.indexOf(" ");
			
			int n=Integer.parseInt(h.substring(0,f));
			int m=Integer.parseInt(h.substring(f+1));
			
			list.inc(n,m);
		}
			 
		}

	}

}
