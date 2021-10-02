package stack;
//problem link : https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1/?track=SPC-Stack&batchId=154
// solution link: https://www.youtube.com/watch?v=-6KHfvHyrJw&t=183s
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }
    public static String infixToPostfix(String str) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(isCharacter(ch))
                postfix.append(ch);
            else if(ch=='(')
                stack.push(ch);
            else if(ch==')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());
                if(stack.peek()=='(')stack.pop();
            }
            else{
                    while (!stack.isEmpty() && stack.peek()!='(' && precedence(stack.peek(),ch))
                        postfix.append(stack.pop());
                    stack.push(ch);
            }

        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix.toString();
    }
    public static boolean isCharacter(char ch){
        if( ch == '(' || ch ==')' || ch =='^' || ch=='*'|| ch=='/' || ch=='+' || ch=='-')
            return false;
        return true;
    }
    public static boolean precedence(char x1 , char x2){
        if(x1=='^')return true;
        if((x1=='*' || x1=='/') && x2!='^')return true;
        if((x1=='+' || x1=='-') && (x2!='^' && x2!='*' && x2!='/'))return true;
        return false;
    }
}
