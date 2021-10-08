You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

class Solution {
    public int arrangeCoins(int n) {
        long low = 1, high = n;
        
        while(low <= high){
            long mid = low + (high-low)/2;
            long sum  = mid*(mid+1)/2;
            
            if(sum == n){
                return (int)mid;
            } else if(sum < n){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return (int)high;
    }
}
