import java.util.Stack;

public class min_reversal_brackects {
    public static int min_brack(String s) {
        /* Approach -1 Using 2 pointer approach - o(n)
        /*Approach -2  - o(n)*/
        Stack<Character> st = new Stack();
        int len = s.length();
        if (len % 2 == 1)
            return 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '{')
                st.push(s.charAt(i));
            else {
                if (s.charAt(i) == '}' && st.peek() == '{')
                    st.pop();
                else
                    st.push(s.charAt(i));
            }
        }
        int size = st.size();
        int count_close = 0;
        while (st.peek() == '}' && st.empty() == false) {
            st.pop();
            count_close++;
        }
        int count_open = size - count_close;
        int ans = (int) ((int) (Math.ceil(count_close / 2)) + (Math.ceil(count_open / 2)));
        //ans = (size/2)+count_open%2;
        return ans;


    }

    public static void main(String[] args) {
        String s = "{{{{";
        System.out.println(min_brack(s));
    }
}
