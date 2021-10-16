import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Word_Cart {

    static ArrayList<String> words = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void Add() throws IOException {
        char ch;
        do
        {
            System.out.println("Enter the Word you want to add");
            words.add(br.readLine());
            System.out.println("Want to add more Words Y/N");
            ch = br.readLine().charAt(0);
        }while (ch!='N' && ch!='n');
    }
    public static void delete() throws IOException {
        char ch;
        do
        {
            if(words.size()==0){
                System.out.println("Your Word_Cart is Empty!! Please Add words");
                break;
            }
            System.out.println("Words present are : ");
            for(String str : words){
                System.out.print(str+" ");
            }
            System.out.println("\nEnter the Word you want to delete");
            words.remove(words.indexOf(br.readLine()));
            System.out.println("Want to delete more Words Y/N");
            ch = br.readLine().charAt(0);
        }while (ch!='N' && ch!='n');
    }

    public static void check() throws IOException {
        if(words.size()==0){
            System.out.println("Your Word_Cart is Empty!! Please Add words");
        }
        else {
            System.out.println("Enter the Word you Want to check ");
            String st = br.readLine();
            if (words.contains(st)) {
                System.out.println("The Word " + st + " is Already Present");
            } else {
                System.out.println("The Word " + st + " is Not Present");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("1. Add the Word to your Cart");
            System.out.println("2. Delete Words from Your Cart");
            System.out.println("3. Check Whether the word is present in your Cart or not");
            System.out.println("4. Delete all Words from Your Cart");
            System.out.println("5. Preview Your Word_Cart");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            int ch = Integer.parseInt(br.readLine());

            switch (ch) {
                case 1:
                    Add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    check();
                    break;
                case 4:
                    words.clear();
                    System.out.println("Your Word List is Empty Now!!!!!");
                    break;
                case 5:
                    if(words.size()==0){
                        System.out.println("Your Word_Cart is Empty!! Please Add words");
                    }
                    else {
                        System.out.println("Words present in your Word_Cart are : ");
                        for (String str : words) {
                            System.out.print(str+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Oops!! You entered invalid choice");
            }
        }
    }
}
