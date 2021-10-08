import java.util.*;
import java.lang.*;
import java.io.*;
class LCS{
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		    System.out.println("Enter First String");
		    String s1=sc.next();            // Take both the string as input
			System.out.println("Enter second String");
	        String s2=sc.next();
		    
		    System.out.println("length of longest subsequence present in both of them "+lcs(s1.length(), s2.length(), s1, s2));
	}
    static int lcs(int p, int q, String s1, String s2){
        // your code here
        char[] m = s1.toCharArray();
        char[] n = s2.toCharArray();
        int t[][] = new int[p+1][q+1];
        for(int i=1;i<p+1;i++){
            for(int j=1;j<q+1;j++){
                if(m[i-1]==n[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[p][q];
    }
    
}