import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	private static Cell cell;
	private static Player player1, player2;
	public static ArrayList<Cell> fromLadders = new ArrayList<>();
	public static ArrayList<Cell> toLadders = new ArrayList<>();
	public static ArrayList<Cell> fromSnake = new ArrayList<>();
	public static ArrayList<Cell> toSnake = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Cell> cells = new ArrayList<>();

		for(int i=1; i<=100; i++) {
			 cell = new Cell(i);
			 cells.add(cell);
			switch(cell.getCell()) {
			case 4, 9, 21, 28, 51, 72, 80: 
				cell.setIsLadder(true);
				cell.setIsSnake(false);
				fromLadders.add(cell);
				break;
			case 17, 54, 62, 64, 87, 93, 95, 98: 
				cell.setIsLadder(false);
				cell.setIsSnake(true);
				toSnake.add(cell);
				fromSnake.add(cell);
				break;
			case 14, 31, 38, 42, 67, 84, 91, 99:
				toLadders.add(cell);
				break;
			case 7, 19, 34, 36, 60, 73, 79:
				toSnake.add(cell);
				break;
			default: 
				cell.setIsLadder(false);
				cell.setIsSnake(false);
				break;		
			}
			
			
		}
		game();
	
	}
	
	public static void game() {
		userInput();
		System.out.println("Snake and Ladder Game");
		System.out.println("Both players are in the starting position currently.");	
		
		rollDice(player1);
		
	}
	public static void userInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Player 1's name: ");
		String p1 = input.next();
		player1 = new Player(p1);
		player1.setPosition(0);
		System.out.println("Enter Player 1's name: ");
		String p2 = input.next();
		player2 = new Player(p2);
		player2.setPosition(0);
	}
	public static void rollDice(Player player) {
		if(player.getPosition() >=  100) {
			if(!(player == player1)) {
				System.out.println(player2.getName() + " is the winner!");
				return;
			}
			else if(!(player == player2)) {
				System.out.println(player2.getName() + " is the winner!");
				return;
			}
		}
		int dice = (int) (Math.random() * 6) + 1;

		Scanner inp = new Scanner(System.in);
		String q = "It's " + player.getName() + "'s turn. Roll the dice? (y/n)";
		System.out.println(q);
		String x = inp.next();
		if(!(x == "y")) {
		player.setPosition(player.getPosition() + dice);
		
		if(player.getPosition() > 100) {player.setPosition(100);}
		
		System.out.println("The dice returned " + dice + ". " + player.getName() + " moves to position " + player.getPosition());
		for (int i =0; i < fromLadders.size(); i++) {
			if(player.getPosition() == fromLadders.get(i).getCell()) {
				player.setPosition(toLadders.get(i).getCell());
				System.out.println("Woah, this is a ladder cell. " + player.getName() + " moves to position " + player.getPosition());
				
			}
			else if(player.getPosition() == fromSnake.get(i).getCell()) {
				player.setPosition(toSnake.get(i).getCell());
				System.out.println("Oops. This is a snake cell. " + player.getName() + " moves to position " + player.getPosition());
				
			}
			
		}
		if(player.getPosition() >=  100) {
			if(!(player == player1)) {
				System.out.println(player2.getName() + " is the winner!");
				return;
			}
			else if(!(player == player2)) {
				System.out.println(player1.getName() + " is the winner!");
				return;
			}
		}
		if(player == player1) {
			rollDice(player2);
		}
		else if(player == player2) {
			rollDice(player1);
		}
		}
    }
	
}
