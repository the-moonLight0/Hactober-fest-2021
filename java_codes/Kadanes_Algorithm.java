
/* time complexity - o(n) */
public class Kadanes_Algorithm
{
    public static int max_subarray(int [] arr)
    {
        int current =0;
        int max_sum =0;
        int start =0;
        int s = 0;
        int end =0;

        for(int i =0;i<arr.length;i++)
        {
            current = current+arr[i];
            if(current >max_sum) {
                max_sum = current;
                start = s;
                end = i;
            }

            if(current <0) {
                current = 0;
                s = i+1;
            }
        }
        System.out.println("The max sum of subarray ranges from "+start+" to " + end +" ");
        return max_sum;
    }
    public static void main(String [] args)
    {
        int arr[] = new int[]{1,2,3,-2,5};
        System.out.println("The maximum sum is: "+ max_subarray(arr));
    }
}
