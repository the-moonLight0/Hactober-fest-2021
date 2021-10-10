import java.lang.*;

public class SplitArrayToAddAtEnd {
    public static void SplitAndAdd(int[] A, int length, int rotation) {
        int[] tmp = new int[length * 2];
        System.arraycopy(A, 0, tmp, 0, length);
        System.arraycopy(A, 0, tmp, length, length);
        System.arraycopy(tmp, rotation, A, rotation - rotation, rotation + length - rotation);
    }

    public static void main(String[] args) {
        int arr[] = {12, 10, 5, 6, 52, 36};
        int n = arr.length;
        int position = 2;
        SplitAndAdd(arr, n, position);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}
