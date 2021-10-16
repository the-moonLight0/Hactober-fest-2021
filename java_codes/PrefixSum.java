package oneDArray;

public class PrefixSum {
    public static void main(String[] args) {
        int[] array = {2,8,3,9,6,5,4};
        prefixSum(array);
        System.out.println(getSum(0,4,array));
        System.out.println(getSum(3,4,array));
        System.out.println(getSum(2,6,array));
    }
    public static void prefixSum(int[] array){
        for(int i=1;i<array.length;i++)
            array[i]+=array[i-1];

    }
    public static int getSum(int x,int y,int[] array) {
        if(x==0)return array[y];
        return array[y]-array[x-1];
    }
}
