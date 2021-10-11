import java.io.*;
import java.lang.*;
import java.util.*;
class RotateArray{
	public static void rotate(int[] arr,int n,int d){
		for(int i=0;i<d;i++){
			rotateAnti(arr, n);
		}
	}
	public static void rotateAnti(int[] arr,int n){
		int temp;
		temp = arr[0];
		for(int i=0;i<n-1;i++){
			arr[i] = arr[i+1];
		}
		arr[n-1] = temp;
	}
	public static void main(String[] args){
		//scanner obj
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter Array Elements:");
		for(int i=0;i<n;i++){
			arr[i] = scn.nextInt();
		}
		System.out.println("Enter value of D tp rotate array by D elements (clockwise)");
		int d = scn.nextInt();
		rotate(arr,n,d);
		System.out.println("Array After rotating array by D elements (clockwise)");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
