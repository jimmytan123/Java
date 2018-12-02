/*
 * CSC115 Assignment 1 : The Baseball team.
 * PlayerList.java
 * Zhixi Tan V00821283
 */


/**
 * PlayerList is a sequential list of Players.
 * The list can be of any size.
 */
public class PlayerList {
	private static final int INITIAL_SIZE = 2;

	private Player[] storage;
	private int count;

	/**
 	 * Create an empty PlayerList.
	 */
	public PlayerList() {
        
	  // Initialize the storage array and set count to 0.
      this.storage = new Player[INITIAL_SIZE];
      count = 0;
	}

	/**
	 * Retrieves the player at the given index starting at 0.
	 * Pre-Condition: The index must be between 0 and size()-1.
	 * @param index The position in the list, which must be in {0, size-1).
	 * @return The given Player if the index is inside the list bounds.
	 */
	public Player get(int index) {
	   
	 if(index>=0 && index<size()){
		  
		return storage[index];
	 }
		
		return null;
	}

	/**
	 * Removes the Player at position index.
	 * Pre-Condition: The index is between 0 and size()-1, inclusive.
	 * If index is out of bounds, nothing is removed.
	 * @param index The position in the list, 
	 *		where index 0 is the first Player.
	 */
	public void remove(int index) {
       
       if (0<=index && index<size()){
        for(int i=index;i<size();i++){
	        storage[index]=storage[index+1];
	        count --;
	    }
	
	   }
	}

	/**
	 * @return The number of elements in the list.
	 */
	public int size() {
		return count;
   }

	/**
	 * Adds a player to the list.
	 * Does not check for duplicates.
	 * @param p The new player.
	 */
	public void add(Player p) {
		/*
		 * NOTE TO PROGRAMMER:
		 * The array you allocated to store Players might
		 * get full, but you are still required to add this
 		 * Player (until the JVM runs out of memeory!)
		 *
		 * This means that you should check to see if the array
		 * is currently full. If it is, allocate a new array
		 * that is twice as big, then copy the values over
		 * and updaet the storage reference to be the new array.
		 * Finally, add the new Player.
		 */
	if(storage.length<=count){
	   Player [] storage2 = new Player[2*storage.length];

	   for(int i=0;i< count;i++){
              storage2[i]=storage[i];
            
        }
			storage=storage2;
						
			storage[count]=p;
            
        }else if(storage.length>count){
	          storage[count]=p;
        }
                    
       count = count +1;

    }

	/**
	 * Finds the Player in the list.
	 * @param p The player that we are looking for.
 	 * @return The index number of the player
	 * 		or -1 if the player is not in the list.
	 */
	
	public int find(Player p) {
			
		
		for(int i=0; i<count; i++){

			if (storage[i].getName().equals(p.getName())){
			    return i;
			   
			}else{
				return -1;
		    }
		}
		return -1;
	}

}
