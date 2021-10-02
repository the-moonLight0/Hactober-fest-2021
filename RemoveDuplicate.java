package oneDArray;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,2,2,2,2,2,3,4,4};
        int newSize = removeDuplicates(array);
        for(int i = 0;i<newSize;i++)
            System.out.print(array[i]+" ");
    }
    public static int removeDuplicates(int[] nums) {
        int bound = 0;               //contains index of distinct array formed
        for(int i = 0;i<nums.length;i++){
            if(nums[bound]!=nums[i]){
                nums[bound+1]=nums[i];
                bound++;
            }
        }
        return bound+1;
    }
}
