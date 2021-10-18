import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class vik_twitter {
    static int numberOfTokens(int expiryLimit, List<List<Integer>> commands)
    {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int time=0;

        for(int c=0;c<commands.size();c++){

            int action=commands.get(c).get(0);
            int token_id=commands.get(c).get(1);
            time=commands.get(c).get(2);

            if(action==0){
                mp.put(token_id,expiryLimit+time);
            }

            else if(action==1){
                if(mp.get(token_id)!=null){
                    int expiry_time=mp.get(token_id);
                    if(expiry_time>=time){
                        mp.put(token_id, time + expiryLimit);
                    }
                }
            }
        }
        int count=0;
        for (int ele : mp.values()) {
            if(ele>=time){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] Args){
        List<List<Integer>> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int expiry = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
//            arr.add();
            List<Integer> ar = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                ar.add(sc.nextInt());
            }
            arr.add(ar);
        }
        System.out.println(numberOfTokens(expiry,arr));

    }
}
