/**
 * CSC115 Assignment 2 : Containers.
 * IntegerLinkedList.java
 * @author Zhixi Tan V00821283
 */

/*
 * NOTE TO PROGRAMMER:
 * Complete the implementation of all the methods as specified.
 *
 * Start by creating "stub" methods that are required by the 
 * IntegerList interface.
 * Return null or simple values where the methods have return values.
 * Then compile, correcting any syntax errors and repeat.
 * 
 */

/**
 * IntegerLinkedList is a sequential list of integers, that uses
 * a linked data structure in its implementation.
 */
public class IntegerLinkedList implements IntegerList {

	private IntegerNode head;
	private IntegerNode tail;
	private int count;

// PROGRAMMER TO PLACE HEADER COMMENT HERE
	public IntegerLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * IntegerList Interface methods..
	 * NOTE THAT THESE do not need header comments. They use the
	 * comments from the IntegerList interface.
	 */


	// PROGRAMMER INSERT REQUIRED METHODS HERE

    public void insertFirst(int k) {
        IntegerNode newNode = new IntegerNode(k,null,head);
        
        head = newNode;
        
        count++;
    }
    
    public void insertLast(int k){
        IntegerNode newNode = new IntegerNode(k);
       
        
        if(head == null){
            
            head = newNode;
        
        }else{    
            IntegerNode curr = head;
            
            while(curr.next != null){
                curr = curr.next;
            }
            
            curr.next = newNode	;
            
            }
            count ++;
    }
    
    public int size(){
        return count;
    }
    
    public int get(int pos){
        if( pos>= 0 && pos<count){
            int data = 0;
            
            IntegerNode n = head;
            
            for(int i=0;i<pos;i++){
                n = n.next;
            }
            
            data = n.item;
            
            return data;
        }
        
        return -1;
    }
    
    public void removeAll(){
        head = null;
        count = 0;
    }
    
    public void remove(int value){
        IntegerNode curr = head;
        IntegerNode prev = null;
        
        for (curr = head; curr != null; curr = curr.next) {
            if(curr.item == value) {
                
                if (prev == null) {
                    
                    head = curr.next;
                
                } else {
                    
                    prev.next = curr.next;
                }
                
                    count--;
            }
            
            prev = curr;
            
        }
    }
    
    public String toString(){
        
        if(head == null){
            return "{}";
        }
            IntegerNode curr = head;
            String str = "{";
            
            //while current.next == null, skip this 
            while(curr.next != null){
                str += curr.item;
                str += ",";
                curr = curr.next;
            }
            
            str+= curr.item;
            str+= "}";
            return str;

    }

}
