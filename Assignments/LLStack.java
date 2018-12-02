/* 
   LLStack.java
   Zhixi Tan
   V00821283
*/



public class LLStack <E> implements Stack<E>{
	
	    private Node <E> top;
	
	
		public LLStack (){
			top = null;
	    }
	
	/**
	 * @return true if the stack is empty, false if it is not.
	 */
	public boolean isEmpty(){
	  if(top == null){
        return true;
      }else{
        return false;
      }
	}
	/**
	 * Places an element at the top of the stack.
	 * @param element The element to be added.
	 */
	public void push (E element){
		top = new Node (element,top);
	}
	
    /**
     * Remove the top elememt from the stack.
     * @return The element that was removed.
     */  
    public E pop() throws StackEmptyException{
	    if (! isEmpty()){
         Node curr = top;
         top = top.next;
        return (E)curr.item;
      }else{
        throw new StackEmptyException("Stack Empty");
      }
    }
 
    /**
 	 * Looks at the top elememt of the stack without removing it.
	 * @return The top element.
	 */
    public E peek() throws StackEmptyException{
	    if(! isEmpty()){
         return (E)top.item;
      }else{
        throw new StackEmptyException("Stack Empty");
      }
    }
    
    /**
     * Remove all elements from the stack.
     */
    public void popAll(){
	   top = null;
    }

	
}