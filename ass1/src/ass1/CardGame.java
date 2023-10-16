package ass1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CardGame {
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private List<Card> cards;
	private Map<Player, List<Card>> hm1 = new HashMap<Player, List<Card>>();
	private static final int numCard = 7;
	private int currentPlayer = 0;
	
	public CardGame() {
		cards = Card.getaPackofCards(); //create a set of card
	}
	
	public ArrayList<Player> getPlayer(){
		return playerList;
	}
	
	public int numOfCardPerPlayer() {
		return numCard;
	}
	
	public void createPlayer(int num) {
		for (int i = 1; i <= num; i++) {
			playerList.add(new Player(i)); //add player into the list and set their id
			playerList.get(i-1).setPlayerName("Player "+i); //assign player name
		}
	}
	
	public void distributeCard(ArrayList<Player> list) {
		int start = 0, end;
		this.playerList = list;
		Card.shuffle(cards); //shuffle the cards
		for (Player p: playerList) {
			p.setPoints(0); //set all player point to 0
			List<Card> pCards = new ArrayList<Card>();
			end = start + numCard; //ensure no repeated card
			for (int i=start; i < end; i++) {
				pCards.add(cards.get(i)); //every player get 7 cards
			}
			start = end;
			hm1.put(p, pCards); //add into hash map	
		}
		
	}
	
	public Player nextPlayer() { 
		Player p;
		if(currentPlayer == playerList.size()) {
			currentPlayer = 1;
			p = playerList.get(0);
		}
		else {
			p = playerList.get(currentPlayer);
			currentPlayer++;
		}	
		return p;
	}
	
	public void displayCard(Player p) {
		int totalCard = hm1.get(p).size(); //get the number of cards that player currently have
		for(int i=1; i<=totalCard; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void displayScore() {
		System.out.println();
		for (Player p: playerList) {
			System.out.println(p.getPlayerName() + " Score -> " + p.getPoints()); //display each player score
		}
	}
	
	public void playGame(int pNum) {
		
		Card maxCard = null;
		Player maxPlayer = new Player(0);
		Scanner input = new Scanner(System.in);
		createPlayer(pNum);
		System.out.println("Game Started...");
		distributeCard(playerList);
		for (int i=0; i < numCard; i++) {
			for (int j=1; j <= pNum; j++) {
				Player player = nextPlayer();
				int option;
				System.out.println("\n1. display Cards available \n2. Stop Game");
				System.out.println("Chance for Player..." + player.getPlayerId());
				System.out.println("Please provide your option:");
				
				option = input.nextInt();
				
				while (option != 1 && option != 2) {
					System.out.println("Please provide a valid option: ");
					option = input.nextInt();
				}
				
				if (option == 1) {
					displayCard(player);
					System.out.println("Select your card number:");
					int num = input.nextInt();
					while (num > hm1.get(player).size() || num < 1) {
						System.out.println("Please choose within the number above: ");
						num = input.nextInt();
					}
					Card c = hm1.get(player).get(num-1); //get the selected card
					System.out.println("Card Selected -> " + c.toString());
					if (maxCard == null) { //for the first player
						maxCard = c;
						maxPlayer = player;
					}
					else {
						if(maxCard.compareTo(c) < 0) { //when the card is bigger than the previous maxCard
							maxCard = c;
							maxPlayer = player;
						}
					}
					hm1.get(player).remove(num-1); //remove the card selected
				}
				else {
					return;
				}
			}
			if(maxPlayer.getPlayerId() > 0) { //if there exists a maxPlayer
				maxPlayer.setPoints(maxPlayer.getPoints() + 1);
			}
			maxCard = null;
			maxPlayer = null; //clear the variable for next round
			displayScore();
		}
		input.close();
	}
	
	public void displayWinner() {
		int maxPoint = -1;
		List<Player> winner = new ArrayList<Player>();
		
		for(Player p: playerList) {
			if(maxPoint == -1) {
				maxPoint = p.getPoints();
				winner.add(p);
			}
			else {
				if(p.compareTo(winner.get(0)) > 0) { //who get the max point who is the winner
					maxPoint = p.getPoints();
					winner.add(p);
					for(int i=0; i<winner.size();i++) {
						if(winner.get(i).getPoints() < maxPoint) {
							winner.remove(i);
						}
					}
				}
				else if (p.compareTo(winner.get(0)) == 0) { //if there exists more than one winner
					winner.add(p);
				}
			}
		}
		
		System.out.println("The winner(s) is:");
		for(int j=0; j<winner.size();j++) {
			System.out.println(winner.get(j).getPlayerName());
		}
		
	}
}
