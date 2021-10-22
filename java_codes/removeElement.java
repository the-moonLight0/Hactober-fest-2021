class Solution {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
       int j=0;
        int i=0;
       while(j<len){
           if(nums[j]!=val){
               nums[i]=nums[j];
               i++;
           }
           j++;
       }
        int count=i;
        for(j=count;j<len;j++){
            nums[i]='_';
        }
        return count;
    }
}
