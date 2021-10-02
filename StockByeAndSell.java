package oneDArray;
/**
 * ***************************IMPORTANT******************************
 *
 */

import java.util.Scanner;
//problem link : https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1/?track=DSASP-Arrays&batchId=154
public class StockByeSell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase --> 0){
            int n= sc.nextInt();
            int[] array = new int[n];
            for(int i=0;i<n;i++)array[i] = sc.nextInt();
            stockBuySell(array, n);
        }
    }
    static void stockBuySell(int[] arr, int n) {
        int purchase = -1;
        boolean isProfit = false;
        for(int i=0;i<n-1;i++){
            if(purchase ==-1 && i==0 && arr[i]<arr[i+1]){
                purchase = i;
                // case like 1 2 3 ....
            }
            else if(purchase ==-1 &&i>0 && arr[i-1]>=arr[i] && arr[i]<arr[i+1]){
                purchase = i;
                // case 5 4 6 or 4 4 4 5
            }
            else if(purchase != -1 && arr[i - 1] <= arr[i] && arr[i + 1] < arr[i]){
                System.out.print("("+purchase+" "+i+") ");
                purchase=-1;
                isProfit = true;
                //case 4 6 5 or 4 4 4 3
            }


        }
        if(purchase!=-1)
            System.out.print("("+purchase+" "+(n-1)+") "); //case if last day was a profit day
        else if(!isProfit)
            System.out.print("No Profit");


    }
    // time and space complexity : O(n) , although, we can reduce space complexity to O(1)
// this solution is done using FSM , FSM : https://user-images.githubusercontent.com/55681638/109997644-6ae48800-7d36-11eb-88a6-b4eab7a91032.jpg


        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] buy = new int[n];
            int[] sell = new int[n];
            int[] nothing = new int[n];
            buy[0] = -prices[0];
            for (int day = 1; day < n; day++) {
                buy[day] = Math.max(buy[day - 1], Math.max(nothing[day - 1] - prices[day], sell[day - 1] - prices[day]));
                sell[day] = Math.max(sell[day - 1], buy[day - 1] + prices[day]);
                nothing[day] = Math.max(nothing[day - 1], sell[day - 1]);
            }
            return sell[n - 1];
        }

}
