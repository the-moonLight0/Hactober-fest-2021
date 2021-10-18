//package codeforces;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class apartments {
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        int r = 0;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int [] size = new int [n];
        int [] presentSize = new int [m];
        for (int i = 0; i < n; i++) {
            size[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            presentSize[i] = sc.nextInt();
        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < size.length; i++) {
//            pq.add(size[i]);
//        }
//        for (int i = 0; i < size.length; i++) {
//            size[i] = pq.remove();
//        }
//        for (int i = 0; i < presentSize.length; i++) {
//            pq.add(presentSize[i]);
//        }
//        for (int i = 0; i < presentSize.length; i++) {
//            presentSize[i] = pq.remove();
//        }
        sort(size,0, size.length-1);
        sort(presentSize,0, presentSize.length-1);
//        Arrays.sort(size);
//        Arra/ys.sort(presentSize);
        int i=0;
        int j=0;
        int ans = 0;
        while (i<n && j<m){
//            boolean fla = true;
//            System.out.println(size[i]+" "+presentSize[j]);
            if(Math.abs(presentSize[j]-size[i])<=k){
//                System.out.println("PP");
                ans++;
                j++;
                i++;
//                fla = false;
            }
            else if(presentSize[j]>size[i]){
                i++;
            }else{
                j++;
            }

        }
        System.out.println(ans);
    }
}
