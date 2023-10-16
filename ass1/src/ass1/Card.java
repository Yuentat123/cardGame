package ass1;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {
	private Card() {}
	public enum rank {
		TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
		
		//Return the order of the enum in the rank. 
		private int order;
		
		private rank(int a) {
			this.order=a;
		}
		
		public int getOrder() {
			return order;
		}
	}
	
	public enum suit{
		SPADE,HEART,CLUB,DIAMOND;
	}
	
	private rank Rank;
	private suit Suit;
	
	//Accessor
	public rank getRANK() {
		return Rank;
	}
	 
	//Accessor
	public suit getSUIT() {
		return Suit;
	}
	
	public static List<Card>getaPackofCards(){
		List<Card> deck= new ArrayList<Card>();
		for(suit types: suit.values()) {
			for(rank cNums: rank.values()) {
				Card cards=new Card();
				cards.Rank=cNums;
				cards.Suit=types;
				deck.add(cards);
			}
		}
		return deck;
	}
	
	//Sort the card 
	public static void shuffle(List<Card>cards) {
		Collections.shuffle(cards);
	}
	
	@Override
	public int compareTo(Card o) {
		if(this.getRANK()==o.getRANK()) {
			return 0;
		}
		else if(this.getRANK().getOrder()>o.getRANK().getOrder()){
			return 1;
		}
		else
			return -1;
	}
	
	@Override
	public String toString() {
		return "Card[Type="+ Suit +" "+"Number="+Rank+"]";
	}
}
