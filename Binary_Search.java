//BINARY SEARCH PROGRAM IN JAVA

import java.util.Scanner;
import java.util.*;
public class binary{    
public static void toBinary(int decimal){    
     int binary[] = new int[40];    
     int index = 0;    
     while(decimal > 0){    
       binary[index++] = decimal%2;    
       decimal = decimal/2;    
     }    
     for(int i = index-1;i >= 0;i--){    
       System.out.print(binary[i]);    
     }    
System.out.println();//new line  
}    
public static void main(String args[]){      
System.out.println("Decimal of 3 is: ");  
toBinary(3);    
System.out.println("Decimal of 21 is: ");  
toBinary(21);    
System.out.println("Decimal of 31 is: ");    
toBinary(31);  
}}      
