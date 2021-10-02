class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        
        HashMap<Integer,Integer> hm=new HashMap();
        int [] n=new int[2];
        for(int i=0;i<nums.length;i++){
            
            int p=target-nums[i];
            if(hm.containsKey(p)){
                
                n[0]=hm.get(p);
                n[1]=i;
                return n;
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return new int[2];
    }
}