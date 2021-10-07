/**************************************

*              Instructions: 

* Just click Run and type in your name

***************************************/

import java.util.Scanner;

import java.util.Random;

public class Program{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Player a;

        if (input.equals("")){

            a = new Player("Defaultius Minimus");

        } else {

            a = new Player(input);

        }

        Player b = new Player();

        int turnCount = 0;

        sc.close();

        System.out.println("Hello and welcome to Zone Hunter!\n");

        System.out.println("Today's Zone Hunters are:");

        System.out.println(a.getName() + " -vs- " + b.getName());

        System.out.println("\nZone Hunters, to the starting zone!");

        

        //Loop through turns and advance player to next zone

        while (turnCount < 5){

            System.out.println("\n-------------------------\n");

            a.move();

            System.out.println(a.getName() + " moves into " + a.checkZone());

            b.move();

            System.out.println(b.getName() + " moves into " + b.checkZone() + "\n");

            //Roll dice to see which player claims the current zone

            //Reroll if necessary

            do {

                a.rollDice();

                System.out.println(a.getName() + " rolls a " + a.getRoll());

                b.rollDice();

                System.out.println(b.getName() + " rolls a " + b.getRoll() + "\n");

                if (a.getRoll() > b.getRoll()){

                    a.addCount();

                    turnCount++;

                    System.out.println(a.getName() + " has claimed " + a.checkZone());

                }

                if (b.getRoll() > a.getRoll()) {

                    b.addCount();

                    turnCount++;

                    System.out.println(b.getName() + " has claimed " + b.checkZone());

                }

                if (a.getRoll() == b.getRoll()){

                    System.out.println("Rerolling...");

                }

            } while (a.getRoll() == b.getRoll());

        }

        

        //Calculate which player claimed more zones after all

        //zones have been visited

        if (turnCount == 5){

            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-\n");

            System.out.println(a.getName() + " has claimed " + a.getZoneCount() + " zones.");

            System.out.println(b.getName() + " has claimed " + b.getZoneCount() + " zones.");

            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-\n");

            if (a.getZoneCount() > b.getZoneCount()){

                System.out.println(a.getName() + " wins the zone hunt!");

            }

            else {

                System.out.println(b.getName() + " wins the zone hunt!");

            }

        }   

        System.out.println("\nThank you for running my code!\nI hope you enjoyed Zone Hunter :)");

    } //END main END

} //END Program END

public class Player{

    private String name;

    Random rand = new Random();

    private int playerAt;

    private int roll;

    private String zone;

    private int zoneCount;

    

    //Default constructor

    Player(){

        this("Defaultius Maximus");

        playerAt = 0;

        zoneCount = 0;

    }

    

    //Constructor with parameter

    Player(String nm){

        name = nm;

        playerAt = 0;

        zoneCount = 0;

    }

    

    String getName(){

        return name;

    }

    

    //Give a random integer between 1 and 6

    void rollDice(){

        roll = rand.nextInt(6)+1;

    }

    

    int getRoll(){

        return roll;

    }

    

    int getPlayerAt(){

        return playerAt;

    }

   

    //Advance player to next zone 

    void move(){

        playerAt++;

    }

    

    void addCount(){

        zoneCount++;

    }

    

    int getZoneCount(){

        return zoneCount;

    }

    

    String checkZone(){

        switch (playerAt){

            case 0:

                zone = "Home";

                break;

            case 1:

                zone = "Zone 1";

                break;

            case 2:

                zone = "Zone 2";

                break;

            case 3:

                zone = "Zone 3";

                break;

            case 4:

                zone = "Zone 4";

                break;

            case 5:

                zone = "Zone 5";

        }

        return zone;

    }

    

} //END Player END
