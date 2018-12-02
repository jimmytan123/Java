/*
        For assignments: 2 ID:v00821283 Zhixi Tan
        Loopy
        CSc 110 Assignment 2: Introduction to Loops, parameters and return values
        Input:size
        Output:Images and area
*/



public class Loopy {
    public static void main(String [] args) {
	    drawShape(1);
	    drawShape(2);
	    drawShape(3);
	    System.out.println();
	    drawImage(1);
	    drawImage(2);
	    drawImage(3);
	    System.out.println();
		rectangleArea(7.0,3.0);
		triangleArea(7.0,6.0);
		circleArea(5.0);
		circumferenceCircle(5.0);
	    cylinderSurfaceArea(7.0,5.0);
	    rectPrismSurfaceArea(7.0,7.0,3.0);
	    triPrismSurfaceArea(7.0,6.0);
	    houseSurfaceArea(10.0,14.0,6.0,8.0);
	}
    
     
    //draw the images 
    public static void drawShape(int size) {
        
        for (int i=0; i<= size; i++){
		    System.out.print("/");
		}

		for (int i=0; i<= size;i++) {
		    System.out.print("\\");
		}
		
		System.out.print("\n/");
		
		for (int i=0; i<size;i++) {
			System.out.print("**");
		}
		
		System.out.print("/ \n");
		
		for (int i=0; i<=size; i++) {
			System.out.print("\\");
		}
		
		for (int i=0; i<=size; i++) {
			System.out.print("/");
		}
		
		System.out.println();
	}	
    
    
    
    public static void drawImage(int numShapes) {
	    for (int i=1; i<= numShapes; i++) {
	         drawShape(i);
	    }
	  
	    for (int i=numShapes; i>=1;i--)   {  
	        drawShape(i);
	    }
	    
	}     
	
	//calculate the total area
	public static double rectangleArea(double length, double width) {
	    
	    double total= length*width;
	    System.out.println("rectangle: with length " + length + ", base: " + width);
	    System.out.println("        area:" + total);
	    System.out.println();
	    
	    return total;
	}    
	
	public static double triangleArea(double height, double base) {
	    
	    double total= (height*base)/2;
	    System.out.println("triangle: with height " + height + ", base: " + base);
	    System.out.println("        area:" + total);
	    System.out.println();
	    
	    return total;
	} 
	
    public static double circleArea(double diameter) {
        
        double total= Math.PI*(diameter/2)*(diameter/2);
        System.out.println("circle: with diameter " + diameter);
        System.out.println("        area: " + total);
        
        return total;
    }
    
    public static double circumferenceCircle(double diameter) {
         
        double total= Math.PI*diameter;
        System.out.println("        circumference: " + total);
        System.out.println();

        
        return total;
    }
    
    public static double cylinderSurfaceArea(double height, double diameter) {
    
        double total= 2*Math.PI*(diameter/2)*(diameter/2) + Math.PI*diameter*height;
        System.out.println("cylinder: with height " + height + ", diameter: " + diameter);
        System.out.println("        surface area: " + total);
        System.out.println();

        
        return total;
    }
    
    public static double rectPrismSurfaceArea(double height, double depth, double width) {
        
        double total= height*width*2+depth*width*2+height*depth*2;
        System.out.println("rectangular prism: with height " + height + ", depth: " + depth + ", width: " + width);
        System.out.println("        surface area: " + total);
        System.out.println();
        
        return total;
    }    
    public static double triPrismSurfaceArea(double height, double width) {

        double total=width*height*3+2*(width*Math.sqrt(3)/2*width)/2;
        System.out.println("triagular prism: with height " + height + ", width: " + width);
        System.out.println("        surface area: " + total);
        System.out.println();
        
        return total;
    }    
    public static double houseSurfaceArea(double wallHeight, double peekHeight, double width, double depth) {
        
        double Walls=depth*wallHeight*2+width*wallHeight*2+(peekHeight-wallHeight)*width;
        double Tops=Math.sqrt((peekHeight-wallHeight)*(peekHeight-wallHeight)+width*width/4)*depth*2;
        double total= Walls+Tops;
        System.out.println("house: with wall height " + wallHeight +", peek height: " + peekHeight+ ", width: " + width + ", depth: " + depth);
        System.out.println("        surface area: " + total);
        System.out.println();

        return total;
    }    
}    