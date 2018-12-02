/*
For assignments: 3 ID:v00821283 Zhixi Tan
RocketLaunch.java
CSC 110 Assignment 3: Nested Loops, parameters and return values and Scanner
Input: size,numBoosters,msg,key,num
Output:Required rocket and encryption or decryption
*/
import java.util.*;

public class RocketLaunch {
    public static void main(String [] args) {
         
         
         Scanner myScan = new Scanner(System.in);
         System.out.println("What size rocket would you like to build?");
         int size = myScan.nextInt();
         System.out.println("How many boosters?");
         int numBoosters = myScan.nextInt();
         
         drawRocket(size,numBoosters);
         System.out.println();
          
         
         Scanner myScan2 = new Scanner(System.in);
         System.out.println("What is your message?");
         String msg = myScan2.nextLine();
         System.out.println("What is your key?");
         int key = myScan2.nextInt();
         System.out.println("type 1 for encrypt or 2 for decrypt?");
         int num= myScan2.nextInt();
        
         EncryptionOrDecryption(msg,key,num);
         System.out.println();
    }    
           /*
            PURPOSE: to print a ascii rocket ship
            INPUT: int size, controls the proportions of the rocket
            int numBoosters, controls how many boosters are drawn
            OUTPUT: an ascii representation of Apollo Spaceship
           */     
               
             public static void drawRocket(int size, int numBoosters) {
             SpaceCraft(size);
             line1(size);
             LemAdapater(size); 
             line2(size);
             InstrumentUnit(size);
             line2(size);
             Booster(size,numBoosters);
             line2(size);
             Tail(size);
                         
         }       
              /*
                Name:SpaceCraft
                Purpose:draw the spacecraft
                Input:size
                Output:the image of the required spacecraft
              */
                 public static void SpaceCraft(int size) {    
                     for (int i=1; i<=2*size; i++) {
                     System.out.println();
                        
                       for (int j = 1; j <= (-1*i + 2*size+3); j++) {
                       System.out.print(" ");
                       }
                       
                       for (int j=0; j<i-1; j++) {
                       System.out.print("/");
                       }
                       
                       System.out.print("**");
                       
                       for (int j=0; j< i-1; j++) {
                       System.out.print("\\");
                       }
                    
                     }
                       System.out.println();
                }
                
              /*
                Name:Line1
                Purpose:draw the line1
                Input:size
                Output:the image of the required line1
              */                 
                 public static void line1(int size){
                     
                     for (int i=0; i<2; i++){
                     System.out.print(" ");
                     }
                     
                     System.out.print("+");
                     
                     for (int i=0; i<2*size; i++){
                     System.out.print("=*");
                     }
                     
                     System.out.print("+");
                     System.out.println();

                 }  
                 
              /*
                Name:Lemadapater
                Purpose:draw the lemadapater
                Input:size
                Output:the image of the required lemadapater
              */

                   public static void LemAdapater(int size){
                
                     
                     System.out.print(" //");
                     
                     for (int i=1; i<=2*size; i++) {
                     System.out.print(" %");
                     } 
                     
                     System.out.print("\\\\");
                     
                     System.out.println();

                     System.out.print("//");
                     
                     for (int i=1; i<=2*size+1; i++) {
                     System.out.print(" %");
                     } 

                     System.out.print("\\\\");
                    
                     System.out.println();
                  } 
                  
              /*
                Name:Line2
                Purpose:draw the line2
                Input:size
                Output:the image of the required line2
              */                  
                  public static void line2(int size) {
                   System.out.print("+");    
                   
                   for (int i=0; i<2*size+2; i++){
                     System.out.print("=*");
                     }             
                     
                     System.out.print("+");
                     System.out.println();

                  }
                  
              /*
                Name:InstrumentUnit
                Purpose:draw the instrument unit
                Input:size
                Output:the image of the required instrument unit
              */
                  
                   public static void InstrumentUnit(int size) {
                   
                      for (int i=1; i<=2; i++){
                       System.out.print("||");
                       
                       for (int j=1; j<=2*size+1;j++){
                        System.out.print("~#");
                       }
                       
                       System.out.print("||");
                       System.out.println();
                      }
                   }
                   
              /*
                Name:Booster
                Purpose:draw the booster
                Input:size
                Output:the image of the required booster
              */
                   
                   public static void booster(int size) {
                   
                     //part I of the booster
                     for (int i=0; i<size+1; i++){
                     
                     System.out.print("|");
                     
                        for (int j=0; j<size-i; j++) {
                        System.out.print(".");
                        }
                        
                        for (int j=0; j<i+1;j++) {
                        System.out.print("/\\");
                        }
                        
                        for (int j=0; j<size-i; j++) {
                        System.out.print(".");
                        }
                        
                        for (int j=0; j<size-i; j++) {
                        System.out.print(".");
                        }
                        
                        for (int j=0; j<i+1;j++) {
                        System.out.print("/\\");
                        }
                        
                        for (int j=0; j<size-i; j++) {
                        System.out.print(".");
                        }
                        
                        System.out.print("|");
                        System.out.println();
                        
                     }
                   
                      //part II of the booster
                      for (int i=0; i<size+1; i++){
                      
                      System.out.print("|");
                      
                      for (int j=0; j<i; j++){
                      System.out.print(".");
                      }
                      
                      for (int j=0; j<=-i+size;j++) {
                      System.out.print("\\/");
                      }
                        
                      for (int j=0; j<i; j++){
                      System.out.print(".");
                      } 
                      
                      for (int j=0; j<i; j++){
                      System.out.print(".");
                      } 
                      
                      for (int j=0; j<=-i+size;j++) {
                      System.out.print("\\/");
                      }							                                     
                      
                      for (int j=0; j<i; j++) {
                      System.out.print(".");
                      }
                      
                      System.out.print("|");
                      System.out.println();
                    }
                     
                   } 
                    
              /*
                Name:Booster
                Purpose:draw the required size and numbers of the boosters
                Input:size,numBoosters
                Output:the image of the required boosters
              */
                    public static void Booster(int size, int numBoosters) {
	                   for (int i=1; i<= numBoosters; i++) {
	                   booster(size);
	                 }
	                }
                    
                   //print the tail 
                   public static void Tail(int size) {  
                     System.out.print("//");
                      
                      for ( int i=0; i< size; i++){
                      System.out.print("  /\\");
                      }
                      
                      System.out.print("  \\\\");
                      System.out.println();
                   }
                   
                /*
                   purpose: Encryption or Decryption
                   Input:msg,key,num
                   Output:encrypted and decrypted message
                */
                   
                   public static void EncryptionOrDecryption(String msg, int key, int num) {     
         
                   if (num==1){
                   encrypt(msg,key);
                   } 
      
                   else if (num==2){
                   decrypt(msg,key);
                   }
                  }
       
                  /*
                   PURPOSE: encrypts msg given an encryption key between 1 and 95
                   INPUT: String msg, the message to be encrypted
                   int key, the amount to increase the ascii character by
                   to encrypt the message
                   OUTPUT: an encrypted version of msg returned as a String
                  */ 
                                   
                  public static String encrypt(String msg, int key) {
                  int size = msg.length();
                  String newWord = "";
        
                  for (int i=0;i < size; i++){
                   char letter = msg.charAt(i);
                   int value = (int) letter;
                   value=value+key;
           
                  char capital =(char) value;
                  newWord= newWord + capital;
                }
                  System.out.println("Your message encrypted is: " + newWord);
                  return newWord;
              }
    
                /*
                 PURPOSE: decrypts msg given an encryption key between 1 and 95
                 INPUT: String msg, the message to be decrypted
                 int key, the amount to shift the ascii character by
                 to decrypt the message
                 OUTPUT: a decrypted version of msg returned as a String
                */
                                 
                 public static String decrypt(String msg, int key) {
                 int size = msg.length();
                 String newWord = "";
        
                 for (int i=0;i < size; i++){
                 char letter = msg.charAt(i);
                 int value = (int) letter;
                 value=value-key;
           
                 char capital =(char) value;
                 newWord= newWord + capital;
              }
                 System.out.println("Your message decrypted is: " + newWord);
                 return newWord;
            }
}
