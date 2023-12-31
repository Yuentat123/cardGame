package ass1;

public class Player implements Comparable<Player> {
	private int playerId;

	private String playerName;

	private int points;

	private String  result;
	
	//constructor
	public Player(int id){
		this.playerId = id;
	}

	//Accessor
	public int getPlayerId(){
		return playerId;
	}

	//Accessor
	public String getPlayerName() {
		return playerName;
	}
	
	//Accessor
	public int getPoints(){
		return points;
	}

	//Accessor
	public String getResult(){
		return result;
	}
	
	//Mutator
	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}
	
	 //Mutator
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}	      

	//Mutator
	public void setPoints(int points){
		this.points = points;
	}	
	  
	//Mutator
	public void setResult(String result){
	    this.result = result;
	}
	  
	@Override
	public int hashCode(){
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + playerId;
	    return result;
	 }

	@Override
	 public boolean equals(Object obj){
	    if (this == obj)
	    	return true;
	    if (obj == null)
	    	return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Player other = (Player) obj;
	    if (playerId != other.playerId)
	    	return false;
	    return true;
	 }

	 @Override
	 public int compareTo(Player o){
		 if (this.getPoints() == o.getPoints()) {
			 return 0;
	     }
	     else if (this.getPoints() > o.getPoints()){
	         return 1;
	     }
	     else {
	         return -1;
	     }
	 }
}

