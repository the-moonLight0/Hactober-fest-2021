import java.util.HashSet;
import java.util.Scanner;

public class vikky {


    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n-1;i++){
            HashSet<Character> h = new HashSet<>();
            int no_in_left = 0;
            for(int j=0;j<i;j++){
                if(!h.contains(s.charAt(j))){
                    h.add(s.charAt(j));
                    no_in_left++;
                }
            }
//            System.out.println(no_in_left);
            int no_of_rigth = 0;
            HashSet<Character> hh = new HashSet<>();
            for(int j=i;j<n;j++){
                if(!hh.contains(s.charAt(j))){
                    hh.add(s.charAt(j));
                    no_of_rigth++;
                }
            }
//            System.out.println(no_of_rigth);
            ans = Math.max(Math.min(no_in_left,no_of_rigth),ans);
        }
        System.out.println(ans);
    }
}
