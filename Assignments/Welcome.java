/*
* For assignments: 1 ID:v00821283 Zhixi Tan
*         Welcome
*         CSc 110 Assignment 1: Introduction to Programming
*/



public class Welcome {
    public static void main (String [] args) {
        System.out.println("Welcome\n");
        
        
        
        printTotemPole();
        printFrog();
        printTotemPole();
        printPig();
        printTotemPole();
        printFrog();
        printTotemPole();
        printPig();
        printTotemPole();
        printTotemPole();  
        System.out.println("      ");		
        calcSurfaceArea();
    } 
    
    /* name: print a pig
       purpose: print a pig
       input: none
       output:the picture of the pig
    */
    public static void printPig(){
        System.out.println("  ^__^");
        System.out.println(" (0  0)");
        System.out.println("  (oo)  ");
        System.out.println(" (\")_(\")@");
    
    }
    
    /* name: print a frog
       purpose: print a frog
       input: none
       output: the picture of the frog
    */   
     
    public static void printFrog(){
        System.out.println("  @..@");
        System.out.println(" (----) ");
        System.out.println("( >__< )");
        System.out.println("\"\"    \"\" ");
    
    }
    
    /* name: print the line
       purpose: print the line
       input: none 
       output: the picture of the line
    */   
       
    public static void printTotemPole(){
        System.out.println("/~~~~~~\\");   
    
    }
	
	/* name: calculate the area
	   purpose: calculate the area
	   input: none
	   output: get the final area of the cylinder
	*/   
	public static void calcSurfaceArea(){
		double diameter;
		double hight;
		double Pi;
		double Circumference;
		double TopArea;
		double WallsArea;
		diameter=4;
		hight=5;
		Pi=3.14;
		Circumference=Pi*diameter;
		TopArea=Pi*(diameter/2)*(diameter/2);
		WallsArea=Circumference*hight;
		System.out.print("Surface Area is ");
        System.out.println(2*TopArea+WallsArea);
	}         
}
        
