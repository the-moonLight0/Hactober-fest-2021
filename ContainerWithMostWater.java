import java.util.Scanner;
/*
Given n non-negative integers a_1, a_2, ..., a_n    where each represents a point at coordinate (i, a_i)
 . ‘ n ‘ vertical lines are drawn such that the two endpoints of line i is at (i, a_i)
              and (i, 0)               .
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
    public static void main(String args[]){

        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int height[]=new int[n];

        for(int i=0;i<n;i++) {
            height[i] = sc.nextInt();
        }
        int maxArea=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                maxArea=Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }}
        System.out.print(maxArea);}
}

