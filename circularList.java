import java.util.Scanner;
public class circularList {
	public class Node{
		int data;
		Node next;
		Node prev;
	}
	private Node head;
	private Node tail;
	private Node cur;
	private int size;
	
	public void Add(int data) {
		if(size==0) {
			Node s=new Node();
			s.data=data;
			head=tail=cur=s;
			s.next=head;
			s.prev=head;
			size++;
		}
		else {
			Node s=new Node();
			s.data=data;
			Node temp=cur.next;
			cur.next=s;
			s.next=temp;
			size++;
		}
	}
	public void q2() {
		cur=cur.next;
	}
	public void dis() {
		System.out.print(cur.data);
	}

	public static void main(String[] args) {
		circularList s=new circularList();
		s.Add(1);
		Scanner scn=new Scanner(System.in);
		int loop=scn.nextInt();
		for(int i=0;i<loop;i++) {
			int u=scn.nextInt();
			if(u==1) {
				int p=scn.nextInt();
				s.Add(p);
			}
			else if(u==2){
				s.q2();
			}
			else if(u==3) {
				s.dis();
			}
		}

	}

}
