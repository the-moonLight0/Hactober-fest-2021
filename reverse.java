class Solution {
    public int reverse(int x) {
        long ans = 0;
        while(x!=0){
            int r = x%10;
            ans=ans*10+r;
            if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE)return 0;
            x = x/10;
        }
        
        return (int)ans;
    }
}
