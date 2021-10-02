package stack;

import java.util.Stack;

// problem link : https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1/?track=SPC-Stack&batchId=154
public class LargestHistogramRectangle {
    public static long getMaxAreaNaive(long[]  arr, long n)  {
        //time complexity O(n^2)
        // space complexity O(1)
        long ans = 0L;
        for(int i=0;i<n;i++){
            int j=i+1;
            while(j<n && arr[j]>=arr[i])j++;
            int k = i-1;
            while(k>=0 && arr[k]>=arr[i])k--;
            long total = (j-i)*arr[i]+ (i-k-1)*arr[i];
            ans = Math.max(ans , total);
        }
        return ans;
    }
    public static long getMaxAreaEfficient(long arr[], long n)  {
        // time complexity O(5n)
        // space complexity O(3n)
        Stack<Integer> leftSmall = new Stack<>();
        int[]  res = new int[(int)n];
        for(int i=0;i<(int)n;i++){
            while(!leftSmall.isEmpty() && arr[leftSmall.peek()]>=arr[i])
                leftSmall.pop();
            if(leftSmall.isEmpty())res[i] = i+1;
            else res[i] = i-leftSmall.peek();
            leftSmall.push(i);
        }
        Stack<Integer> rightSmall = new Stack<>();
        for(int i=(int)n-1;i>=0;i--){
            while(!rightSmall.isEmpty() && arr[rightSmall.peek()]>=arr[i])
                rightSmall.pop();
            if(rightSmall.isEmpty())res[i]+=n-i-1;
            else res[i] += rightSmall.peek()-i-1;
            rightSmall.push(i);

        }
        long max = 0L;
        for(int i=0;i<n;i++){
            long total = arr[i]*res[i];
            max = Math.max(total,max);
        }
        return max;
    }

}
