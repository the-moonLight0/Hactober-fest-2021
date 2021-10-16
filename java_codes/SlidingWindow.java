package oneDArray;

import java.util.Scanner;

public class SlidingTechnique {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase -- >0){
            int n  =sc.nextInt();
            int k =sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++)arr[i] = sc.nextInt();
            System.out.println(sliding(arr,n,k));
        }
    }
    public static long sliding(int[] arr, int n,int k){
        long res = 0L;
        if(k>n)return -1;
        for(int i=0;i<k;i++)res+=arr[i];
        if(k==n)return res;
        long sum = res;
        for(int i = k;i<n;i++){
            res = res +arr[i]- arr[i-k];
            sum=Math.max(res,sum);
        }

        return sum;
    }
}
