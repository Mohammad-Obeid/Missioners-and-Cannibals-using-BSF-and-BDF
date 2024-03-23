package application;


public class State {
	private int missionariesLeft,cannibalsLeft,
	boat,missionariesRight,cannibalsRight;
	
	
	 public State() {
		super();
	}

	public State(int missionariesLeft, int cannibalsLeft, int boat,
         int missionariesRight, int cannibalsRight) {
		 this.missionariesLeft = missionariesLeft;
		 this.cannibalsLeft = cannibalsLeft;
		 this.boat = boat;
		 this.missionariesRight = missionariesRight;
		 this.cannibalsRight = cannibalsRight;
	 }

	public int getMissionariesLeft() {
		return missionariesLeft;
	}

	public void setMissionariesLeft(int missionariesLeft) {
		this.missionariesLeft = missionariesLeft;
	}

	public int getCannibalsLeft() {
		return cannibalsLeft;
	}

	public void setCannibalsLeft(int cannibalsLeft) {
		this.cannibalsLeft = cannibalsLeft;
	}

	public int getBoat() {
		return boat;
	}

	public void setBoat(int boat) {
		this.boat = boat;
	}

	public int getMissionariesRight() {
		return missionariesRight;
	}

	public void setMissionariesRight(int missionariesRight) {
		this.missionariesRight = missionariesRight;
	}

	public int getCannibalsRight() {
		return cannibalsRight;
	}

	public void setCannibalsRight(int cannibalsRight) {
		this.cannibalsRight = cannibalsRight;
	}

	@Override
	public String toString() {
		return missionariesLeft + "," +cannibalsLeft + "," + boat
				+ "," + missionariesRight + "," + cannibalsRight;
	}
	 
	public static boolean validState(State s) {
		if(s.getMissionariesLeft()<s.getCannibalsLeft() && s.getMissionariesLeft()>0
				
				|| s.getMissionariesRight()<s.getCannibalsRight() && s.getMissionariesRight()>0
				
				|| s.getCannibalsLeft()<0 
				|| s.getCannibalsRight()<0 
				|| s.getMissionariesLeft()<0
				|| s.getMissionariesRight()<0
				
				||s.getCannibalsLeft()>3 
				|| s.getCannibalsRight()>3 
				|| s.getMissionariesLeft()>3
				|| s.getMissionariesRight()>3
				
				|| s.getBoat()<0 || s.getBoat() >1
				
				|| s.getMissionariesLeft() + s.getMissionariesRight()<3
				|| s.getCannibalsLeft() +s.getCannibalsRight() <3
				
				|| s.getMissionariesLeft() + s.getMissionariesRight()>3
				|| s.getCannibalsLeft() +s.getCannibalsRight() >3
				
				)return false;
		
		return true;
	}
	
	
	public String generatenewStates(State s) {
		String x="";
		int[][] possibleMoves = {
                {1, 0},   // Move 1 missionary
                {2, 0},   // Move 2 missionaries
                {0, 1},   // Move 1 cannibal
                {0, 2},   // Move 2 cannibals
                {1, 1}    // Move 1 missionary and 1 cannibal
        };//3,2,1,0,1
		for (int[] move : possibleMoves) {
            State newState;
            if(validState(s)) {
            // Determine the direction of the move based on the boat position
            if (s.getBoat() == 0) {  // Boat on the right side
                newState = new State(//3,3,0,0,0 first turn in the for loop
                        s.getMissionariesLeft() - move[0],//2,3,0,0,0
                        s.getCannibalsLeft() - move[1],//2,3,0,0,0
                        1,  // Boat moves to the left side//2,3,1,0,0
                        s.getMissionariesRight() + move[0],//2,3,1,1,0
                        s.getCannibalsRight() + move[1]//2,3,1,1,0
                );
                
            } else {  // Boat on the left side
                newState = new State(//2,3,1,1,0
                		s.getMissionariesLeft() + move[0],//3,3,1,1,0
                		s.getCannibalsLeft() + move[1],//3,3,1,1,0
                        0,  // Boat moves to the right side//3,3,0,1,0
                        s.getMissionariesRight() - move[0],//3,3,0,0,0
                        s.getCannibalsRight() - move[1]//3,3,0,0,0
                );
                
            }
            if(validState(newState)) {
            	//System.out.println(newState.toString());
            	x+=newState.toString()+"\n";
            }	
	}
            }
		return x;
	}
	
	
	
	
	
	
}

