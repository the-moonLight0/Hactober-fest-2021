package oneDArray;
//problem linkj : https://practice.geeksforgeeks.org/problems/kadanes-algorithm-i/1/?track=DSASP-DP&batchId=154#
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] array = {-5,-1,-2,-3,-4};
        System.out.println(maxSubArrayNaive(array));
        System.out.println(kadane(array, array.length));

    }
    public static int maxSubArrayNaive(int[] array ){
        int max = -999999999;
        for(int i=0;i<array.length;i++){
            int curr = 0;
            for(int j=i;j<array.length;j++){
                curr+=array[j];
                max=Math.max(max,curr);
            }
        }
        return max;
    }
    public static long kadane(int arr[], int n) {
        int currSum = -99999;
        int maxSum =  -99999;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            currSum = Math.max(currSum+arr[i],arr[i]);
            sb.append(currSum).append(" ");
            maxSum = Math.max(maxSum,currSum);
        }
        System.out.println(sb);
        return maxSum+0L;
    }
    /*   O(1) solution
    int maxSubArraySum(int arr[], int n){
       int res = -999999999;
       int ans = -999999999;
       int[] max = new int[n];
       for(int i=0;i<n;i++){
           res = Math.max(arr[i],arr[i]+res);
           ans = Math.max(ans,res);
       }
       return ans;
       }
     */
}
