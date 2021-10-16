Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.
  
  class Solution {
    public int numberOfSteps(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 2 ){
            return 2;
        }
        if(n == 1){
            return 1;
        }
        if(n %2 == 0){
            return 1 + numberOfSteps(n / 2);
        }
        if(n % 2 != 0){
            return 1 + numberOfSteps(n - 1);
        }
        return 0;
        
    }
}
