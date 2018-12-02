/* 
   Name : Zhixi Tan
   Student Number: V00821283
   purpose:play the chuck a luck game
   input: Scanner scanner,
          RandomObject
   output: prompts to ask user for bet and updates of bankroll
*/
   

import java.util.Scanner;
import java.util.Random;

public class ChuckALuck {
	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			Random rand = new Random(System.currentTimeMillis());
		    play(scan,rand);
			
	}
 /* purpose: to play the chuck a luck game
    input: Scanner scanner, 
           RandomObject
    output: prompts to ask user for bet and updates of bankroll
 */   
   
     public static void play(Scanner scanner,Random randomObject)  { 
           
           // ask player to add money to bankroll
           int Times=1;
           double money=0;
           System.out.print("How much do you want to add to your bankroll? ");  
           double addmoney = scanner.nextDouble();
           money=money+addmoney; 
           money=myMethod(scanner,randomObject,money,Times);
          
          // "play again?" 
           System.out.println();
           System.out.println("Do you want to keep playing?");
           String answer=scanner.next();
           while(answer.equalsIgnoreCase("yes")){
              if(money>0){
              Times=Times+1;
              money=myMethod(scanner,randomObject,money,Times);
              System.out.println();
              System.out.println("Do you want to keep playing?");
              answer=scanner.next();
              System.out.println();
              }else {
              System.out.println("Sorry, you don't have enough money to bet.");
              System.exit(0);
              }
            }
        }
     
	       
    
/* 
   purpose: choose amount of money to bet, choose a number, to play the start betting
   input: 
          Scanner scan 
          Random rand
          double money
          int Times
          
   output: prompts to ask user for bet and updates of bankroll
*/
      
    public static double myMethod(Scanner scan, Random rand, double money,int Times) {
	       System.out.println();
	       System.out.printf("What is the value of your next bet ($0.00 - %.2f)? ",money);
	       double bet = scan.nextDouble();
	       System.out.print("Choose a number between 1 and 6: ");
	       int guess = scan.nextInt();
	       
	       System.out.print("Dice rolls:");
		   int roll1=rand.nextInt(6)+1;
		   System.out.print(" "+roll1);
		   int roll2=rand.nextInt(6)+1;
		   System.out.print(" "+roll2);
		   int roll3=rand.nextInt(6)+1;
		   System.out.print(" "+roll3);
		   
        		   	
		if(guess==roll1 && guess==roll2 && guess==roll3){
			System.out.println();
			System.out.println("Winnings = "+ bet*10);		
			money = money+bet*10;
			System.out.printf("After bet "+ Times +" your bankroll is %.2f%n",  money);
			
		}else if (guess==roll1 && guess==roll2 || guess==roll1 && guess==roll3 || guess==roll2 && guess==roll3){
			System.out.println();
			System.out.println("Winnings = "+ bet*2);
			money = money+bet*2;
			System.out.printf("After bet "+ Times +" your bankroll is %.2f%n",  money);
			
		}else if (guess==roll1 || guess==roll2 || guess==roll3){
			System.out.println();
			System.out.println("Winnings = "+ bet);
			money = money+bet;
			System.out.printf("After bet "+ Times +" your bankroll is %.2f%n", money);
			
		}else {
			System.out.println();
			System.out.println("Winnings = 0.00");
			money = money-bet;
			System.out.printf("After bet "+ Times +" your bankroll is %.2f%n", money);

		}
         return money;
       }
       
}

		
	
	

 	    
	   

	
