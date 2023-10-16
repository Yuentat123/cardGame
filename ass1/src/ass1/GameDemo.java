package ass1;

import java.util.Scanner;

public class GameDemo {
	public static void main(String[] args) {
		int option = 1;
		do {
			Scanner input = new Scanner(System.in);
			
			System.out.println("Card Game");
			System.out.println("Player Options");
			System.out.println("1. Start Game\n2. Exit Game");
			System.out.println("Please provide your option: ");
			option = input.nextInt();
			
			while (option != 1 && option != 2) { //input validation
				System.out.println("Please provide a valid option: ");
				option = input.nextInt();
			}
			if (option == 1) {
				CardGame cardgame = new CardGame();
				System.out.println("Provide the Number of Players(should be greater than 1 and less than 4):");
				int playerNum = input.nextInt();
				while (playerNum < 2 || playerNum > 4) {
					System.out.println("Please provide a valid number: ");
					playerNum = input.nextInt();;
				}
				
				cardgame.playGame(playerNum);
				cardgame.displayWinner();
			}
			else {
				System.out.println("Thank you! Program Exit!");
				System.exit(2);
			}
			System.out.print("\n\n");
		}while(option == 1);
	}
	

}
