import java.util.*;
public class surgical_Strike {

	
	
	
	
	public static void func(int[][] q,int[] s ,int[][] nmarr,int E) {
		int u = 0;
		int c = 0;
		for(int i=0;i<q.length;i++) {
			u=q[i][0];
			c=q[i][1];
			if(E==c) {
				return 2;
			}
			for(int j=0;j<s.length;j++) {
				if(s[i]==c) {
					return 1;
				}
			}
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//print 2D array
	public static void D(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
//		int n=scn.nextInt();
		int[] array=new int[4];
		for(int i=0;i<4;i++) {
			array[i]=scn.nextInt();
		}
		int nm1=array[0];
		int[][] nm1arr=new int[nm1-1][3];
		for(int i=0;i<nm1-1;i++) {
			for(int j=0;j<3;j++) {
				nm1arr[i][j]=scn.nextInt();
			}
		}
//		D(nm1arr);
		int[] s=new int[array[1]];
		for(int i=0;i<s.length;i++) {
			s[i]=scn.nextInt();
		}
		int[][] q=new int[array[2]][2];
		for(int i=0;i<q.length;i++) {
			for(int j=0;j<q[0].length;j++) {
				q[i][j]=scn.nextInt();
			}
		}
//		D(q);
	}

}
