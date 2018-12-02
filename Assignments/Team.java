/*
 * Assignment 1 : The Baseball team.
 * Team.java
 * Zhixi Tan V00821283
 */

/*
 * NOTE TO PROGRAMMER:
 * Implement each method as per its description.
 * Do not change the javadoc commenting or
 * the method header.
 * You may remove this comment block when you are finished.
 *
 * NOTE that some methods have a return statement.
 * These are to ensure that the shell will compile successfully.
 * They will need to be replaced with working code.
 * 
 * BEFORE CHANGING ANYTHING:
 * Put all the java files into a single directory and type:
 * 	javac *.java
 * Even though nothing works yet, everything compiles.
 * Successful compilation produces no output, but a set of *.class
 * files were created.
 *
 * Next, check out the professional web documentation that
 * is created (by extracting the javadoc comments above each method).
 * Type:
 *	javadoc *.java
 * Then open (double-click) the file called index.html.
 */

/**
 * A Team is a baseball team with a name and Players.
 */
public class Team {
	private String name;
	private PlayerList players;

	/**
	 * Create an empty team.
	 * @param name The name of the team.
	 */
	public Team(String name) {
		/*
		 * NOTE TO PROGRAMMER:
		 * You must allocate a PlayerList here.
		 */
		
	}

	/**
 	 * Creates a team with a single player.
	 * @param name The name of the team.
	 * @param p The single player.
	 */
	public Team(String name, Player p) {
		name = this.name;
		//p=this.player;
	}

	/**
	 * @return the name of the team.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the team.
	 * @param newName The new name of the team.
	 */
	public void setName(String newName) {
		this.name = newName;
		
	}

	/**
 	 * Adds a new new player to the team.
	 * This method does not check for duplicates, so it is
	 * possible to add the same Player more than once.
	 * @param p The new player.
	 */
	public void addPlayer(Player p) {
		players.add(p);
	}

	/**
	 * Remove a player from the team.
	 * @param p The player to remove.
	 * 	If p is not on the team, nothing happens.
 	 */
	public void removePlayer(Player p) {
		//players.remove(p);
	}

	/**
	 * @return The number of players on the team.
	 */
	public int getPlayerCount() {
		return players.size();
	}

	/**
	 * Accesses Player in the team, by its order in list.
	 * Pre-Condition: The position is between 0 and getPlayerCount()-1
	 * @param pos The position of the player to access, which
	 * 	must not be out of bounds.
	 * @return The player.
	 */
	public Player getPlayer(int pos) {
		//if(0<pos && pos<getPlayerCount()-1){
			//return Team.[pos];
		//}
		return null;
	}

	/**
	 * @return a string representation of the team.
	 */
	public String toString() {
		/*
		 * NOTE TO PROGRAMMER:
		 * Nothing to do here, this one is complete.
		 */
		StringBuilder s = new StringBuilder(getPlayerCount()*20);
		s.append(name);
		s.append(":");
		for (int i=0;i<players.size();i++) {
			s.append("\n");
			s.append(players.get(i));
		}
		return s.toString();
	}
}
