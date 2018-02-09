package lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LCR {
	Random rand = new Random();
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<String> names = new ArrayList<String>(Arrays.asList("Ash","Brock","Misty","Jessie","James"));
	boolean running = true;
	int currentPlayer = -1;
	int centerChips = 0;
	
	public LCR(int numPlayers, int chipsPer) {
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player(chipsPer,names.get(i)));
		}
	}
	
	public void run() {
		while (running) {
			if (gameOver()) {
				break;
			}
			currentPlayer++;
			int rolls;
			if (players.get(currentPlayer).getChips() < 3) {
				rolls = players.get(currentPlayer).getChips();
			} else {
				rolls = 3;
			}
			executeRoll(rolls);
		}
		//FileIO stuff
		//print results
	}
	
	private void executeRoll(int n) {
		for (int i = 0; i < n; i++) {
			int roll = roll();
			switch (roll) { //roll a number of times = current player chipNum
			case 4: case 5: case 6: 
				break;
			case 1:
				left(players.get(currentPlayer));
				break;
			case 2: 
				center(players.get(currentPlayer));
				break;
			case 3: 
				right(players.get(currentPlayer));
				break;
			}
		}
	}
	
	private int roll() {
		int roll = rand.nextInt(6) + 1;
		return roll;
	}
	
	private void left(Player p) { //adjusted
		if (currentPlayer == 0) {
			players.get(currentPlayer).giveChip(players.get(players.size()));
		} else {
			players.get(currentPlayer).giveChip(players.get(currentPlayer-1));
		}
	}
	private void center(Player p) {
		centerChips++;
		players.get(currentPlayer).loseChip();
	}
	private void right(Player p) {
		if (currentPlayer == players.size()) {
			players.get(currentPlayer).giveChip(players.get(0));
		} else {
			players.get(currentPlayer).giveChip(players.get(currentPlayer+1));
		}
	}
	/*
	 LEGACY CODE
	private void leftFirst(Player p) {
		players.get(currentPlayer).giveChip(players.get(currentPlayer-1)); //watch bounds of Array
	}
	private void rightFirst(Player p) {
		players.get(currentPlayer).giveChip(players.get(currentPlayer+1)); //watch bounds of Array
	}
	 */
	
	public boolean gameOver() {
		int count = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getChips() > 0) {
				count ++;
			}
		}
		if (count < 2) {
			return true;
		} else {
			return false;
		}
	}
}
