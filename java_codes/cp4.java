//package codeforces;

import java.io.*;
import java.util.Scanner;

public class MICROSOFT {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < test; i++) {
            sc.nextLine();
            int k = sc.nextInt();
            int n =sc.nextInt();
            int m = sc.nextInt();
            int [] n1 = new int [n];
            int []m1 = new int [m];
            for (int j = 0; j < n; j++) {
                n1[j] = sc.nextInt();
            }
            for (int j = 0; j <m ; j++) {
                m1[j] = sc.nextInt();
            }
            int index1 = 0;
            int index2 = 0;
            String ans ="";
            boolean flag = false;
            while (index1<n && index2<m){
                if(n1[index1]<=k){
                    ans+=n1[index1]+" ";
                    index1++;
                    if(n1[index1-1]==0){
                        k++;
                    }
                }
                else if(m1[index2]<=k){
                    ans+=m1[index2]+" ";
                    index2++;
                    if(m1[index2-1]==0){
                        k++;
                    }
                }else{
//                    System.out.println("a");
                    log.write(-1+"\n");
                    flag = true;
                    break;
                }
            }
            if(!flag) {
//                log.write(ans+"\n");


                while (index2 < m) {
//                        System.out.println(k+" "+m1[index2]);
                    if (m1[index2] <= k) {
                        ans += m1[index2]+" ";
                        index2++;
                        if(m1[index2-1]==0){
                            k++;
                        }
                    }else{
//                            System.out.println("p");
                        log.write(-1+"\n");
                        flag =true;
                        break;
                    }
                }


                while (index1 < n) {
                    if (n1[index1] <= k) {
                        ans += n1[index1]+" ";
                        index1++;
                        if(n1[index1-1]==0){
                            k++;
                        }
                    }else{
//                            System.out.println("pp");
                        log.write(-1+"\n");
                        flag =true;
                        break;
                    }
                }

            }
            if(!flag){
                log.write(ans+"\n");
            }

        }
        log.flush();
    }

}
